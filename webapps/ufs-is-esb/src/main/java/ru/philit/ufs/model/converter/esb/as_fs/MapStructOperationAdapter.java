package ru.philit.ufs.model.converter.esb.as_fs;

import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvCommitOperationRqMessageMapper;
import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvCreateOperationRqMessageMapper;
import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvRollbackOperationRqMessageMapper;
import ru.philit.ufs.model.converter.esb.as_fs.mappers.SrvUpdOperationRqMessageMapper;
import ru.philit.ufs.model.entity.common.OperationTypeCode;
import ru.philit.ufs.model.entity.esb.as_fs.OpStatusType;
import ru.philit.ufs.model.entity.esb.as_fs.OperTypeLabel;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq.SrvCreateOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvRollbackOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvRollbackOperationRq.SrvRollbackOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvUpdOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvUpdOperationRq.SrvUpdOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;
import ru.philit.ufs.model.entity.oper.OperationStatus;

public class MapStructOperationAdapter extends AsfsAdapter {

  //******** Converters ********

  private static OpStatusType operationStatus(OperationStatus statusType) {
    return (statusType != null) ? OpStatusType.fromValue(statusType.code()) : null;
  }

  private static OperTypeLabel operTypeLabel(OperationTypeCode operationTypeCode) {
    return (operationTypeCode != null) ? OperTypeLabel.fromValue(operationTypeCode.code()) : null;
  }

  //******** Mappers ********
/*

  //******** SrvCommitOperationRqMessage ********
  private static void map(Operation operation, SrvCommitOperationRqMessage message) {
    message = SrvCommitOperationRqMessageMapper.INSTANCE.toMessage(operation);
    message.setOperationId(operation.getOperationId());
  }
*/

  //******** SrvCreateOperationRqMessage ********
  private static void map(Operation operation, SrvCreateOperationRqMessage message) {
    message = SrvCreateOperationRqMessageMapper.INSTANCE.toMessage(operation);
    message.setOperationType(operTypeLabel(operation.getTypeCode()));
  }

  //******** SrvRollbackOperationRqMessage ********
  private static void map(Operation operation, SrvRollbackOperationRqMessage message) {
    message = SrvRollbackOperationRqMessageMapper.INSTANCE.toMessage(operation);
  }

  //******** SrvUpdOperationRqMessage ********
  private static void map(Operation operation, SrvUpdOperationRqMessage message) {
    message = SrvUpdOperationRqMessageMapper.INSTANCE.toMessage(operation);
    message.setOperationType(operTypeLabel(operation.getTypeCode()));
    message.setOperationStatus(operationStatus(operation.getStatus()));
  }


  /**
   * Возвращает объект запроса сохранения операции.
   */
  public static SrvCommitOperationRq requestCommitOperation(Operation operation) {
    SrvCommitOperationRq request = new SrvCommitOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvCommitOperationRqMessage(SrvCommitOperationRqMessageMapper.INSTANCE.toMessage(operation));
    //map(operation, request.getSrvCommitOperationRqMessage());
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

  /**
   * Возвращает объект запроса отката операции.
   */
  public static SrvRollbackOperationRq requestRollbackOperation(Operation operation) {
    SrvRollbackOperationRq request = new SrvRollbackOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvRollbackOperationRqMessage(new SrvRollbackOperationRqMessage());
    map(operation, request.getSrvRollbackOperationRqMessage());
    return request;
  }

  /**
   * Возвращает объект запроса на редактирования операции.
   */
  public static SrvUpdOperationRq requestUpdOperation(Operation operation) {
    SrvUpdOperationRq request = new SrvUpdOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvUpdOperationRqMessage(new SrvUpdOperationRqMessage());
    map(operation, request.getSrvUpdOperationRqMessage());
    return request;
  }


}
