package ru.philit.ufs.model.converter.esb.as_fs.mappers;

import org.mapstruct.factory.Mappers;
import ru.philit.ufs.model.entity.esb.as_fs.SrvUpdOperationRq.SrvUpdOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;

public interface SrvUpdOperationRqMessageMapper {
  SrvUpdOperationRqMessageMapper INSTANCE = Mappers.getMapper(SrvUpdOperationRqMessageMapper.class);
  SrvUpdOperationRqMessage toMessage(Operation operation);

}
