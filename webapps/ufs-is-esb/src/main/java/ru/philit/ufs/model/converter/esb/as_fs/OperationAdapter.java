package ru.philit.ufs.model.converter.esb.as_fs;

import ru.philit.ufs.model.entity.esb.as_fs.OpStatusType;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq.SrvCommitOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq.SrvCreateOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvGetOperationRq.SrvGetOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvRollbackOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvRollbackOperationRq.SrvRollbackOperationRqMessage;
import ru.philit.ufs.model.entity.esb.as_fs.SrvUpdOperationRq;
import ru.philit.ufs.model.entity.esb.as_fs.SrvUpdOperationRq.SrvUpdOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;
import ru.philit.ufs.model.entity.oper.OperationStatus;
import ru.philit.ufs.model.entity.oper.SrvGetOperationRqAtr;

public class OperationAdapter extends AsfsAdapter {

  //******** Converters ********

  private static OperationStatus operationStatus(OpStatusType statusType) {
    return (statusType != null) ? OperationStatus.getByCode(statusType.value()) : null;
  }

  //******** Mappers ********

  //******** SrvCommitOperationRq ********
  private static void map(Operation operation, SrvCommitOperationRqMessage message) {
    message.setOperationId(operation.getOperationId());
  }

  //******** SrvCreateOperationRq ********
  private static void map(Operation operation, SrvCreateOperationRqMessage message) {
    message.setOperationType(operation.getOperationType());
    message.setOperatorId(operation.getOperatorId());
    message.setWorkPlaceUId(operation.getWorkPlaceUId());
  }

  //******** SrvRollbackOperationRq ********
  private static void map(Operation operation, SrvRollbackOperationRqMessage message) {
    message.setOperationId(operation.getOperationId());
    message.setRollbackReason(operation.getRollbackReason());
  }

  //******** SrvUpdOperationRq ********
  private static void map(Operation operation, SrvUpdOperationRqMessage message) {
    message.setOperationId(operation.getOperationId());
    message.setOperationType(operation.getOperationType());
    message.setOperatorId(operation.getOperatorId());
    message.setAmount(operation.getAmount());
    message.setOperationNum(operation.getOperationNum());
    message.setCashOrderId(operation.getCashOrderId());
    message.setCurrencyType(operation.getCurrencyType());
    message.setRecipientAccountCurrencyType(operation.getRecipientAccountCurrencyType());
    message.setRecipientAccountId(operation.getRecipientAccountId());
    message.setRecipientAccountTypeId(operation.getRecipientAccountTypeId());
    message.setRecipientAccountCurrencyType(operation.getRecipientAccountCurrencyType());
    message.setRecipientBank(operation.getRecipientBank());
    message.setRecipientBankBIC(operation.getRecipientBankBIC());
    message.setRepId(operation.getRepId());
    message.setSenderAccountCurrencyType(operation.getSenderAccountCurrencyType());
    message.setSenderAccountId(operation.getSenderAccountId());
    message.setSenderAccountTypeId(operation.getSenderAccountTypeId());
    message.setSenderBank(operation.getSenderBank());
    message.setSenderBankBIC(operation.getSenderBankBIC());
    message.setWorkPlaceUId(operation.getWorkPlaceUId());
  }

  //******** SrvGetOperationRq ********
  private static void map(SrvGetOperationRqAtr atrOperation, SrvGetOperationRqMessage message) {
    message.setOperationId(atrOperation.getOperationId());
    message.setCreatedFrom(atrOperation.getCreatedFrom());
    message.setCreatedTo(atrOperation.getCreatedTo());
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
   * Возвращает объект запроса на редактирование операции.
   */
  public static SrvUpdOperationRq requestUpdOperation(Operation operation) {
    SrvUpdOperationRq request = new SrvUpdOperationRq();
    request.setHeaderInfo(headerInfo());
    request.setSrvUpdOperationRqMessage(new SrvUpdOperationRqMessage());
    map(operation, request.getSrvUpdOperationRqMessage());
    return request;
  }

}
