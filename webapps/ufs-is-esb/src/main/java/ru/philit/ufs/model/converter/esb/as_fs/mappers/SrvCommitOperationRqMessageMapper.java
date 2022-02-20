package ru.philit.ufs.model.converter.esb.as_fs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq.SrvCommitOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;

@Mapper
public interface SrvCommitOperationRqMessageMapper {
  SrvCommitOperationRqMessageMapper INSTANCE = Mappers.getMapper(SrvCommitOperationRqMessageMapper.class);
  SrvCommitOperationRqMessage toMessage(Operation operation);
}
