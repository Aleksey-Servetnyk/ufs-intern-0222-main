package ru.philit.ufs.model.converter.as_fs;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.philit.ufs.model.converter.esb.as_fs.OperationAdapter;
import ru.philit.ufs.model.entity.esb.as_fs.SrvCommitOperationRq;
import ru.philit.ufs.model.entity.oper.Operation;

public class OperationAdapterTest extends AsfsAdapterBaseTest {

  private static final String OPERATION_ID = "a55ed415-3976-41f7-912c-4c16ca78e969";
  Operation operation = new Operation();

  /**
   * Set up test data.
   */
  @Before
  public void setUp() {
    operation.setOperationId(OPERATION_ID);
    operation.setOperationNum("1");
    operation.setAmount(new BigDecimal("1.00"));
    operation.setOperatorId("1");
    operation.setId("1");
    operation.setCashOrderId("1");
    operation.setCurrencyType("RUB");
  }

  @Test
  public void testCommitOperationRq() {
    SrvCommitOperationRq request = OperationAdapter.requestCommitOperation(operation);
    assertHeaderInfo(request.getHeaderInfo());
    Assert.assertNotNull(request.getSrvCommitOperationRqMessage());
    Assert.assertEquals(request.getSrvCommitOperationRqMessage().getOperationId(), OPERATION_ID);
  }

}
