package com.hexaware.MLP196.model;

import com.hexaware.MLP196.persistence.OrdersDAO;
import com.hexaware.MLP196.factory.OrdersFactory;

//import com.hexaware.MLP196.model.Orders;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Test class for Orders.
 */
@RunWith(JMockit.class)
public class OrdersTest {
  private Date d1 = new Date();
  private Date d2 = new Date();
  private SimpleDateFormat sdf;
   /**
   * Tests the equals/hashcode methods of the employee class.
   */
  private static final double DELTA = 1e-15;
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  private Orders ord;
   /**
   * tests that empty employee list is handled correctly.
   * @throws ParseException throws an exception.
   */
  @Before
  public final void initInput() throws ParseException {
    String date1 = "2020/09/09";
    String date2 = "2020/07/05";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    d2 = sdf.parse(date2);
    ord = new Orders();
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testOrders() {
    final Orders ord0 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    final Orders ord1 = new Orders(101, 2, "FID03", 3, 400, d2, "ORDERED", 11, "FREE2020", 70);
    assertNotEquals(ord0, null);
    assertNotEquals(ord1, null);
    assertEquals(ord0.getOrdId(),
        new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50).getOrdId());
    ord1.setOrdId(100);
    assertEquals(ord1, new Orders(101, 2, "FID03", 3, 400, d2, "ORDERED", 11, "FREE2020", 70));
    assertEquals(ord0.hashCode(),
        new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50).hashCode());
    assertEquals(ord0, new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Orders>();
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] order1 = OrdersFactory.showOrders();
    assertEquals(0, order1.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
  */
  @Test
  public final void testListAllSome(@Mocked final OrdersDAO dao) {
    final Orders ord0 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    final Orders ord1 = new Orders(101, 2, "FID03", 3, 400, d2, "ORDERED", 11, "FREE2020", 70);
    final ArrayList<Orders> order2 = new ArrayList<Orders>();
    new Expectations() {
      {
        order2.add(ord0);
        order2.add(ord1);
        dao.show();
        result = order2;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] ord2 = OrdersFactory.showOrders();
    assertEquals(2, ord2.length);
    assertEquals(new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50).getOrdId(),
        ord2[0].getOrdId());
    assertEquals(new Orders(101, 2, "FID03", 3, 400, d2, "ORDERED", 11, "FREE2020", 70).getOrdId(),
        ord2[1].getOrdId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersDefaultConstructor() {
    Orders newOrders = new Orders();
    assertEquals(newOrders.hashCode(), new Orders().hashCode());
    newOrders.setOrdId(1);
    assertNotEquals(newOrders.getOrdId(), new Orders().getOrdId());
  }
/**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersParameterisedConstructor() {
    Orders newOrders = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
     // testing customer variables are initialized through getters which
    //in turn to know where its returning a correct values.
    assertEquals(100, newOrders.getOrdId());
    assertEquals(1, newOrders.getCusId());
    assertEquals("FID01", newOrders.getFoodId());
    assertEquals(2, newOrders.getOrdQty());
    assertEquals(200, newOrders.getOrdTotalCost(), DELTA);
    assertEquals(d1, newOrders.getOrdDate());
    assertEquals("ORDERED", newOrders.getOrdStatus());
    assertEquals(10, newOrders.getVenId());
    assertEquals("FREE2020", newOrders.getCouponCode());
    assertEquals(50, newOrders.getTokenNo());
  }
    /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetOrdId() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setOrdId(100);
    assertEquals(100, newOrders1.getOrdId());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetCusId() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setCusId(1);
    assertEquals(1, newOrders1.getCusId());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetFoodId() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setFoodId("FID01");
    assertEquals("FID01", newOrders1.getFoodId());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetOrdQty() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setOrdQty(2);
    assertEquals(2, newOrders1.getOrdQty());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdTotalCost() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200.0f, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setOrdTotalCost(200);
    assertEquals(200.0f, newOrders1.getOrdTotalCost(), DELTA);
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetDate() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setOrdDate(d1);
    assertEquals(d1, newOrders1.getOrdDate());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetOrdStatus() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setOrdStatus("ORDERED");
    assertEquals("ORDERED", newOrders1.getOrdStatus());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetVenId() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setVenId(10);
    assertEquals(10, newOrders1.getVenId());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetTokenNo() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setTokenNo(50);
    assertEquals(50, newOrders1.getTokenNo());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testOrdersSetCouponCode() {
    Orders newOrders1 = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    newOrders1.setCouponCode("FREE2020");
    assertEquals("FREE2020", newOrders1.getCouponCode());
  }
}
