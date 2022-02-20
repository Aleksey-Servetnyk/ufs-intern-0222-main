package ru.philit.ufs.model.converter.esb.as_fs.mappers;

import org.mapstruct.factory.Mappers;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCreateOperationRq.SrvCreateOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;

public interface SrvCreateOperationRqMessageMapper {
  SrvCreateOperationRqMessageMapper INSTANCE = Mappers.getMapper(SrvCreateOperationRqMessageMapper.class);
  SrvCreateOperationRqMessage toMessage(Operation operation);
}
