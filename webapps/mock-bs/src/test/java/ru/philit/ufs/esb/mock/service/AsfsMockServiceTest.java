package ru.philit.ufs.esb.mock.service;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.philit.ufs.esb.mock.client.EsbClient;

public class AsfsMockServiceTest {

  @Mock
  private EsbClient esbClient;

  private AsfsMockService service;

  /**
   * Set up test data.
   */
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    service = new AsfsMockService(esbClient);
  }

  @Test
  public void testInit() throws Exception {
    service.init();
  }

  @Test
  public void testProcessMessage_SrvCommitOperationRq() throws Exception {
    String requestMessage = "<SrvCommitOperationRq><HeaderInfo/></SrvCommitOperationRq>";
    Assert.assertTrue(service.processMessage(requestMessage));
  }

  @Test
  public void testProcessMessage_Other() throws Exception {
    String requestMessage = "Not valid xml";
    assertFalse(service.processMessage(requestMessage));
  }

}
