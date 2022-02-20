package ru.philit.ufs.model.converter.esb.as_fs;

import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvCommitOperationRqMessageMapper;
import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvCreateOperationRqMessageMapper;
import ru.philit.ufs.model.entity.esb.as_fs.OpStatusType;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq.SrvCommitOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq.SrvCreateOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;
import ru.philit.ufs.model.entity.oper.OperationStatus;

public class MapStructOperationAdapter extends AsfsAdapter {

  //******** Converters ********

  private static OperationStatus operationStatus(OpStatusType statusType) {
    return (statusType != null) ? OperationStatus.getByCode(statusType.value()) : null;
  }

  //******** Mappers ********

  //******** SrvCommitOperationRq ********
  private static void map(Operation operation, SrvCommitOperationRqMessage message) {
    message = SrvCommitOperationRqMessageMapper.INSTANCE.toMessage(operation);
  }

  //******** SrvCreateOperationRq ********
  private static void map(Operation operation, SrvCreateOperationRqMessage message) {
    message = SrvCreateOperationRqMessageMapper.INSTANCE.toMessage(operation);
  }

  /**
   * Возвращает объект запроса сохранения операции.
   */
  public static SrvCommitOperationRq requestCommitOperation(Operation operation) {
    SrvCommitOperationRq request = new SrvCommitOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvCommitOperationRqMessage(new SrvCommitOperationRqMessage());
    map(operation, request.getSrvCommitOperationRqMessage());
    return request;
  }

  /**
   * Возвращает объект запроса создания операции.
   */
  public static SrvCreateOperationRq requestCreateOperation(Operation operation) {
    SrvCreateOperationRq request = new SrvCreateOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvCreateOperationRqMessage(new SrvCreateOperationRqMessage());
    map(operation, request.getSrvCreateOperationRqMessage());
    return request;
  }


}
