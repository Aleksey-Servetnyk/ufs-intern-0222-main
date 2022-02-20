package ru.philit.ufs.model.entity.oper;

import javax.xml.datatype.XMLGregorianCalendar;
import lombok.Getter;
import lombok.Setter;
import ru.philit.ufs.model.entity.common.ExternalEntity;

@Getter
@Setter
public class SrvGetOperationRqAtr extends ExternalEntity {
  private String operationId;
  private XMLGregorianCalendar createdFrom;
  private XMLGregorianCalendar createdTo;
}
