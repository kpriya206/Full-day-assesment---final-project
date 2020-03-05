package com.hexaware.MLP196.factory;

import com.hexaware.MLP196.persistence.OrdersDAO;
import com.hexaware.MLP196.persistence.DbConnection;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hexaware.MLP196.model.Orders;
/**
 * ordersFactory class used to fetch menu data from database.
 * @author hexware
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of orders object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().show();
    return orders.toArray(new Orders[orders.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of orders object.
   * @param ordId        order id
   * @param cusId        customer id
   * @param foodId       food id
   * @param ordQty       order quantity
   * @param ordTotalCost total cost of order
   * @param ordStatus    order status
   * @param date1      order Date
   * @param couponCode   coupon code
   * @param venId        vendor id
   * @param tokenNo      token number
   * @throws ParseException throws an exception.
   */
  public static int addOrders(final int ordId, final int cusId, final String foodId, final int ordQty,
      final float ordTotalCost, final Date date1, final String ordStatus, final int venId, final String couponCode,
      final int tokenNo) throws ParseException {
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date scbod = null;
    scbod = new java.sql.Date(date1.getTime());
    int i = dao().addingorders(ordId, cusId, foodId, ordQty, ordTotalCost, scbod, ordStatus, venId, couponCode, tokenNo);
    return i;
  }
  // /**
  //   * Call the data base connection.
  //   * @return the array of orders object.
  //   * @param ordQty order quantity
  //   */
  // public static int deleteOrders(final int ordQty) {
  //   int j = dao().deletingOrders(ordQty);
  //   return j;
  // }
  /**
    * Call the data base connection.
    * @return the array of orders object.
    * @param ordId order id
    * @param ordTotalCost total cost of order
    */
  public static int updateOrders(final int ordId, final float ordTotalCost) {
    int k = dao().updatingorders(ordId, ordTotalCost);
    return k;
  }
  /**
  * @return the array of orders object.
  * @param ordId order id
  */
  public static Orders disOrdStatus(final int ordId) {
    Orders k = dao().disordstatus(ordId);
    return k;
  }
 /**
  * @return the array of orders object.
  * @param ordId order Id
  * @param ordStatus order status
  */
  public static int changeStatus(final int ordId, final String ordStatus) {
    int k = dao().changestatus(ordId, ordStatus);
    return k;
  }
/**
  * @return the array of orders object.
  * @param cusId customer id
  */
  public static Orders cusOrdHis(final int cusId) {
    Orders k = dao().cusordhis(cusId);
    return k;
  }

/**
 * @param cusId         cusId
 * @param foodId        foodId
 * @param ordqty        ordqty
 * @param ordTotalprice ordTotalprice
 * @param d1          date
 * @param ordStatus     ordStatus
 * @param tokenNo       token number
 * @return the array of orders object.
* @throws ParseException thrwos an exception.
 */
  public static int insertOrders(final int cusId, final int ordTotalprice, final int ordqty, final Date d1,
      final String ordStatus, final String foodId, final int tokenNo) throws ParseException {
   // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date scbod = null;
    scbod = new java.sql.Date(d1.getTime());
    int k = dao().insertorders(cusId, ordTotalprice, ordqty, scbod, ordStatus, foodId, tokenNo);
    return k;
  }
/**
    * Call the data base connection.
    * @return the token number for order.
    */
  public static long createToken() {
    int token = (int) (Math.round(Math.random() * 100 + 1));
    return token;
  }
/**
  * @return the token number for order.
  * @param ordId order id
  */
  public static Orders getOrdCost(final int ordId) {
    Orders k = dao().getordcost(ordId);
    return k;
  }
/**
  *@return the token number for order.
  * @param ordId order id
  * @param ordStatus order status
  */
  public static int updateOrderStatus(final int ordId, final String ordStatus) {
    int k = dao().updateorderstatus(ordId, ordStatus);
    return k;
  }
/**
  *@return the token number for order.
  * @param ordId order id
  * @param couponCode coupon Code
  */
  public static int updateCoupon(final int ordId, final String couponCode) {
    int k = dao().updateCouponCode(ordId, couponCode);
    return k;
  }
  /**
   * tests that updateCoupon is handled correctly.
   * @param newOrd mocking the dao class
   * @return the token number for order.
   */
  public static int insertOrders(final Orders newOrd) {
    final int insertResult = dao().insertord(newOrd.getOrdId(), newOrd.getCusId(), newOrd.getFoodId(), newOrd.getOrdQty(), newOrd.getOrdTotalCost(),
        newOrd.getOrdDate(), newOrd.getOrdStatus(), newOrd.getVenId(), newOrd.getCouponCode(), newOrd.getTokenNo());
    return insertResult;
  }
   /**
  * Call the data base connection.
  * @param cusId customer id.
  * @param ordStatus customer id.
  * @return the array of orders object.
  */
  public static int updateOrdStatus(final int cusId, final String ordStatus) {
    //final java.sql.Date scpdate = new java.sql.Date(date.getTime());
    int i = dao().updateordStatus(cusId, ordStatus);
    return i;
  }
  /**
  * Call the data base connection.
  * @param ordId new orders.
  * @return the array of orders object.
  */
  public static Orders showOrders(final int ordId) {
    OrdersDAO cDao = dao();
    Orders ord = cDao.showOrd(ordId);
    return ord;
  }
   /**
  * Call the data base connection.
  * @param cusId new orders.
  * @return the array of orders object.
  */
  public static Orders checkCoupon(final int cusId) {
    Orders k = dao().checkcoup(cusId);
    return k;
  }
    /**
  * Call the data base connection.
  * @param cusId new orders.
  * @return the array of orders object.
  */
  public static Orders checkDate(final int cusId) {
    Orders k = dao().checkdate(cusId);
    return k;
  }
  /**
  *@return the token number for order.
  * @param cusId customer id
  * @param couponCode coupon Code
  */
  public static int upcoupcode(final int cusId, final String couponCode) {
    int k = dao().upCoupcode(cusId, couponCode);
    return k;
  }
   /**
  * Call the data base connection.
  * @param cusId new customer.
  * @return the array of customer object.
  */
  public static Orders ordhistory(final int cusId) {
    OrdersDAO cDao = dao();
    Orders cus = cDao.ordhis(cusId);
    return cus;
  }
}
