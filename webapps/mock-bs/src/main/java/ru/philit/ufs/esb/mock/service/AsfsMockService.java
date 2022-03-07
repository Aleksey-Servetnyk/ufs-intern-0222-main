package ru.philit.ufs.esb.mock.service;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.philit.ufs.esb.MessageProcessor;
import ru.philit.ufs.esb.mock.client.EsbClient;
import ru.philit.ufs.model.converter.esb.JaxbConverter;
import ru.philit.ufs.model.entity.esb.as_fs.HeaderInfoType;
import ru.philit.ufs.model.entity.esb.as_fs.OpStatusType;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRs;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRs.SrvCommitOperationRsMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq;

/**
 * Сервис на обработку запросов к АСФС.
 */
@Service
public class AsfsMockService extends CommonMockService implements MessageProcessor {

  private static final String CONTEXT_PATH = "ru.philit.ufs.model.entity.esb.as_fs";

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final EsbClient esbClient;

  private final JaxbConverter jaxbConverter = new JaxbConverter(CONTEXT_PATH);


  @Autowired
  public AsfsMockService(EsbClient esbClient) {
    this.esbClient = esbClient;
  }

  @PostConstruct
  public void init() {
    esbClient.addMessageProcessor(this);
    logger.info("{} started", this.getClass().getSimpleName());
  }

  @Override
  public boolean processMessage(String requestMessage) {
    try {
      Object request = jaxbConverter.getObject(requestMessage);
      logger.debug("Received message: {}", request);
      if (request != null) {
        if (request instanceof SrvCommitOperationRq) {
          sendResponse(getResponse((SrvCommitOperationRq) request));
        } else if (request instanceof SrvCreateOperationRq) {

        }
      }
    } catch (JAXBException e) {
      // this message can not be processed this processor
      logger.trace("this message can not be processed this processor", e);
    }
    return false;
  }

  private void sendResponse(Object responseObject) throws JAXBException {
    String responseMessage = jaxbConverter.getXml(responseObject);
    esbClient.sendMessage(responseMessage);
  }

  private SrvCommitOperationRs getResponse(SrvCommitOperationRq request) {
    SrvCommitOperationRs response = new SrvCommitOperationRs();
    response.setHeaderInfo(copyHeaderInfo(request.getHeaderInfo()));
    response.setSrvCommitOperationRsMessage(new SrvCommitOperationRsMessage());
    response.getSrvCommitOperationRsMessage().setOperationId("a55ed415-3976-41f7-912c-4c16ca78e969");
    response.getSrvCommitOperationRsMessage().setResponseCode("0");
    response.getSrvCommitOperationRsMessage().setOperationStatus(OpStatusType.COMMITTED);
    response.getSrvCommitOperationRsMessage().setCommittedDttm(xmlCalendar(new Date()));
    return response;
  }


  private HeaderInfoType copyHeaderInfo(HeaderInfoType headerInfo0) {
    HeaderInfoType headerInfo = new HeaderInfoType();
    headerInfo.setRqUID(headerInfo0.getRqUID());
    headerInfo.setRqTm(headerInfo0.getRqTm());
    headerInfo.setSpName(headerInfo0.getSystemId());
    headerInfo.setSystemId(headerInfo0.getSpName());
    return headerInfo;
  }
}
