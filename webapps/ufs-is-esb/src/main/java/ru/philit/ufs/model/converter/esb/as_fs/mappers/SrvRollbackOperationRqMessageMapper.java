package ru.philit.ufs.model.converter.esb.as_fs.mappers;

import org.mapstruct.factory.Mappers;
import ru.philit.ufs.model.entity.esb.as_fs.SrvRollbackOperationRq.SrvRollbackOperationRqMessage;
import ru.philit.ufs.model.entity.oper.Operation;

public interface SrvRollbackOperationRqMessageMapper {
  SrvRollbackOperationRqMessageMapper INSTANCE = Mappers.getMapper(SrvRollbackOperationRqMessageMapper.class);
  SrvRollbackOperationRqMessage toMessage(Operation operation);

}
