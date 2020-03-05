package com.hexaware.MLP196.model;

import com.hexaware.MLP196.persistence.CustomerDAO;
import com.hexaware.MLP196.factory.CustomerFactory;
//import com.hexaware.MLP196.model.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
/**
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
 /**
 * Test class for Customer.
 */
  private Customer c;
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    c = new Customer();
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  private static final double DELTA = 1e-15;
  /**
   * tests that empty employee list is handled correctly.
   */
  @Test
  public final void testCustomer() {
    Customer c0 = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    Customer c1 = new Customer(6, "SAKTHIPRIYA", "SAKTHI", 500.00f,  "sakthipriya@hexaware.com");
    assertNotEquals(c0, null);
    assertNotEquals(c1, null);
    assertEquals(c0.getCusId(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusId());
    assertEquals(c0.getCusName(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusName());
    assertEquals(c0.getCusPassword(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusPassword());
    assertEquals(c0.getCusWallet(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusWallet(), DELTA);
    assertEquals(c0.getCusEmail(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusEmail());
    c1.setCusId(6);
    c1.setCusName("SAKTHIPRIYA");
    c1.setCusPassword("SAKTHI");
    c1.setCusWallet(500.00f);
    c1.setCusEmail("sakthipriya@hexaware.com");
    assertNotEquals(c1, new Customer(8, "KARPAGAPRIYA", "KAGS", 100.00f, "kpriya@hexaware.com"));
    assertEquals(c0.hashCode(),
        new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").hashCode());
    assertEquals(c0, new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] cus = CustomerFactory.showCustomer();
    assertEquals(0, cus.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) {
    final Customer c0 = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    final Customer c1 = new Customer(6, "SAKTHIPRIYA", "SAKTHI", 500.00f, "sakthipriya@hexaware.com");
    final ArrayList<Customer> cus = new ArrayList<Customer>();
    new Expectations() {
      {
        cus.add(c0);
        cus.add(c1);
        dao.show(); result = cus;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] cus1 = CustomerFactory.showCustomer();
    assertEquals(2, cus1.length);
    assertEquals(new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com").getCusId(),
        cus1[0].getCusId());
    assertEquals(new Customer(6, "SAKTHIPRIYA", "SAKTHI", 500.00f, "sakthipriya@hexaware.com").getCusId(),
        cus1[1].getCusId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerDefaultConstructor() {
    Customer newCustomer = new Customer();
    assertEquals(newCustomer.hashCode(), new Customer().hashCode());
    newCustomer.setCusId(1);
    assertNotEquals(newCustomer.getCusId(), new Customer().getCusId());
  }
/**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerParameterisedConstructor() {
    Customer newCustomer = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    // testing customer variables are initialized through getters which in turn to know where its returning a correct values.
    assertEquals(5, newCustomer.getCusId());
    assertEquals("karpaga", newCustomer.getCusName());
    assertEquals("kags", newCustomer.getCusPassword());
    assertEquals(450.0f, newCustomer.getCusWallet(), DELTA);
    assertEquals("priya206@hexaware.com", newCustomer.getCusEmail());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerSetId() {
    Customer newCustomer1 = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    newCustomer1.setCusId(5);
    assertEquals(5, newCustomer1.getCusId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerSetName() {
    Customer newCustomer1 = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    newCustomer1.setCusName("karpaga");
    assertEquals("karpaga", newCustomer1.getCusName());
  }
/**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerSetPassword() {
    Customer newCustomer1 = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    newCustomer1.setCusPassword("kags");
    assertEquals("kags", newCustomer1.getCusPassword());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerSetWallet() {
    Customer newCustomer1 = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    newCustomer1.setCusWallet(450.0f);
    assertEquals(450.0f, newCustomer1.getCusWallet(), DELTA);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testCustomerSetEmail() {
    Customer newCustomer1 = new Customer(5, "karpaga", "kags", 450.0f, "priya206@hexaware.com");
    newCustomer1.setCusEmail("priya206@hexaware.com");
    assertEquals("priya206@hexaware.com", newCustomer1.getCusEmail());
  }
}
