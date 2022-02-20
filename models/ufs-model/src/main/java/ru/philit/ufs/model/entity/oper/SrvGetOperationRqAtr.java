package ru.philit.ufs.model.entity.oper;

import javax.xml.datatype.XMLGregorianCalendar;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SrvGetOperationRqAtr {
  private XMLGregorianCalendar createdFrom;
  private XMLGregorianCalendar createdTo;
}
