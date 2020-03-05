package com.hexaware.MLP196.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import com.hexaware.MLP196.factory.OrdersFactory;
import com.hexaware.MLP196.model.Orders;
import com.hexaware.MLP196.persistence.OrdersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Orders
/**
   * tests that adding orders is handled correctly.
   * @throws ParseException
   */
public class OrdersFactoryTest {
  private Date d1 = new Date();
  private SimpleDateFormat sdf;
  /**
  * default constructor testing.
 */
  @Test
public final void testdefaultConstructor() {
    OrdersFactory mf = new OrdersFactory();
    OrdersFactory mf1 = new OrdersFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
/**
   * tests that adding orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void testGetAllOrders(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders ord = new Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    final ArrayList<Orders> ordersList = new ArrayList<Orders>();
    new Expectations() {
      {
        ordersList.add(ord);
        dao.show();
        result = ordersList;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] ordersList1 = OrdersFactory.showOrders();
    assertEquals(ord, ordersList1[0]);
  }
  /**
   * tests that adding orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void addOrders(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int oa = 1;
    new Expectations() {
      {
        dao.addingorders(100, 1, "FID01", 2, 200.0f, d1, "ORDERED", 10, "FREE2020", 50.0f);
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int oa1 = OrdersFactory.addOrders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    assertEquals(oa, oa1);
  }
    /**
   * tests that updating orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateOrders(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int ou = 1;
    new Expectations() {
      {
        dao.updatingorders(100, 200);
        result = ou;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int ou1 = OrdersFactory.updateOrders(100, 200);
    assertEquals(ou, ou1);
  }
  /**
   * tests that changeStatus is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void changeStatus(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int cs = 1;
    new Expectations() {
      {
        dao.changestatus(100, "ORDERED");
        result = cs;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    final int cs1 = OrdersFactory.changeStatus(100, "ORDERED");
    assertEquals(cs, cs1);
  }
  /**
   * tests that DisOrdStatus is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void disOrdStatus(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders up = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.disordstatus(100);
        result = up;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders up1 = OrdersFactory.disOrdStatus(100);
    assertEquals(up, up1);
  }
  /**
   * tests that CusOrdHis is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void cusOrdHis(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders oh = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.cusordhis(1);
        result = oh;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders oh1 = OrdersFactory.cusOrdHis(1);
    assertEquals(oh, oh1);
  }
    /**
   * tests that InsertOrders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void insertOrders(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final java.sql.Date sdate = new java.sql.Date(d1.getTime());
    new Expectations() {
      {
        dao.insertorders(1, 200, 2, sdate, "ORDERED", "FID01", 100);
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int oi1 = OrdersFactory.insertOrders(1, 200, 2, d1, "ORDERED", "FID01", 100);
    assertEquals(1, oi1);
  }
  /**
   * tests that getOrdCost is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void getOrdCost(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders og = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.getordcost(100);
        result = og;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders og1 = OrdersFactory.getOrdCost(100);
    assertEquals(og, og1);
  }
  /**
   * tests that updateOrderStatus is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateOrderStatus(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int ous = 1;
    new Expectations() {
      {
        dao.updateorderstatus(100, "ORDERED");
        result = ous;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int ous1 = OrdersFactory.updateOrderStatus(100, "ORDERED");
    assertEquals(ous, ous1);
  }
  /**
   * tests that updateCoupon is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateCoupon(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int ouc = 1;
    new Expectations() {
      {
        dao.updateCouponCode(100, "FREE2020");
        result = ouc;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int ouc1 = OrdersFactory.updateCoupon(100, "FREE2020");
    assertEquals(ouc, ouc1);
  }
  /**
   * tests that adding orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void insord(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders og = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.insertord(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int oa1 = OrdersFactory.insertOrders(og);
    assertEquals(1, oa1);
  }
 /**
   * tests that adding orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateord(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int expectedOut = 1;
    new Expectations() {
      {
        dao.updateordStatus(1, "ORDERED");
        result = expectedOut;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    int actualOut = OrdersFactory.updateOrdStatus(1, "ORDERED");
    assertEquals(expectedOut, actualOut);
  }
   /**
    * tests that customer login is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException throws a parse exception.
    */
  @Test
   public final void showOrders(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders og = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.showOrd(100);
        result = og;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders oa = OrdersFactory.showOrders(100);
    assertEquals(og, oa);
  }
  /**
   * tests that adding orders is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void ordhistory(@Mocked final OrdersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Orders expectedOut = new  Orders(100, 1, "FID01", 2, 200, d1, "ORDERED", 10, "FREE2020", 50);
    new Expectations() {
      {
        dao.ordhis(1);
        result = expectedOut;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders actualOut = OrdersFactory.ordhistory(1);
    assertEquals(expectedOut, actualOut);
  }
}
