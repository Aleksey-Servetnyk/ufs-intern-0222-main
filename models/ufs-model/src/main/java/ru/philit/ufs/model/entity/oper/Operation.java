package ru.philit.ufs.model.entity.oper;

import java.math.BigDecimal;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.philit.ufs.model.entity.common.ExternalEntity;
import ru.philit.ufs.model.entity.common.OperationTypeCode;
/*
import ru.philit.ufs.model.entity.esb.as_fs.OpStatusType;
import ru.philit.ufs.model.entity.esb.as_fs.OperTypeLabel;
*/

/**
 * Сущность операции.
 */
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString
@Getter
@Setter
public class Operation extends ExternalEntity {

  private String id;
  private OperationStatus status;
  private OperationTypeCode typeCode;
  private String workplaceId;
  private Date createdDate;
  private Date committedDate;
  private String rollbackReason;

  private String operationId;

  //region From SrvCreateOperationRqMessage
  private String workPlaceUId;
  private String operatorId;
  //endregion

  //region From SrvUpdOperationRqMessage
  protected String cashOrderId;
  protected String operationNum;
  protected String repId;
  protected String senderAccountTypeId;
  protected String senderAccountCurrencyType;
  protected String senderBank;
  protected String senderBankBIC;
  protected String senderAccountId;
  protected BigDecimal amount;
  protected String recipientAccountTypeId;
  protected String recipientAccountCurrencyType;
  protected String recipientBank;
  protected String recipientBankBIC;
  protected String recipientAccountId;
  protected String currencyType;
  //endregion

}
