package com.hexaware.MLP196.factory;

import com.hexaware.MLP196.persistence.OffersDAO;
import com.hexaware.MLP196.persistence.DbConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP196.model.Offers;
/**
 * OffersFactory class used to fetch menu data from database.
 * @author hexware
 */
public class OffersFactory {
  /**
   *  Protected constructor.
   */
  protected OffersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OffersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OffersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of offers object.
   */
  public static Offers[] showOffers() {
    List<Offers> offers = dao().show();
    return offers.toArray(new Offers[offers.size()]);
  }
/**
 * Call the data base connection.
 * @return the array of Offers object.
 * @param couponCode coupon code.
 * @param offItem    offer item.
 * @param cusId      customer id.
 * @param ovenId     vendor id.
 * @param ordId      order id.
 * @param d1         dateOfCouponCode.
 * @throws ParseException threws exception.
 */
  public static int addOffers(final String couponCode, final String offItem, final int cusId, final int ovenId,
      final int ordId, final String d1) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date dt = sdf.parse(d1);
    int i = dao().addingoffers(couponCode, offItem, cusId, ovenId, ordId, dt);
    return i;
  }
// /**
//    * Call the data base connection.
//    * @return the array of customer object.
//    * @param offItem offer item.
//    */
//   public static int deleteOffers(final String offItem) {
//     int j = dao().deletingOffers(offItem);
//     return j;
//   }
/**
   * Call the data base connection.
   * @return the array of customer object.
   * @param couponCode coupon code
   * @param offItem offer item.
   */
  public static int updateOffers(final String couponCode, final String offItem) {
    int k = dao().updatingOffers(couponCode, offItem);
    return k;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param d1 date.
   * @param couponCode coupon code
   * @param ordId order id.
   */
  public static int update(final Date d1, final String couponCode, final int ordId) {
    int k = dao().updating(d1, couponCode, ordId);
    return k;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param couponCode coupon code.
   * @param cusId customer id.
   */
  public static int updateCoupon(final String couponCode, final int cusId) {
    int of = dao().updatecoupon(couponCode, cusId);
    return of;
  }
  /**
  * Call the data base connection.
  * @param newOff new offers.
  * @return the array of offers object.
  */
  public static int insertOff(final Offers newOff) {
    final int insertResult = dao().insertoff(newOff.getCouponCode(), newOff.getCusId(), newOff.getOffItem(), newOff.getVenId(),
        newOff.getOrdId(), newOff.getDateOfCouponCode());
    return insertResult;
  }
  /**
  * Call the data base connection.
  * @param newOff new offers.
  * @return the array of offers object.
  */
  public static int updateOffItem(final Offers newOff) {
    //final java.sql.Date scpdate = new java.sql.Date(date.getTime());
    int i = dao().updateoffitem(newOff.getOffItem(), newOff.getOrdId());
    return i;
  }
  /**
  * Call the data base connection.
  * @param ordId new offers.
  * @return the array of offers object.
  */
  public static Offers showOffers(final int ordId) {
    OffersDAO oDao = dao();
    Offers off = oDao.showOff(ordId);
    return off;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param couponCode coupon code.
   * @param cusId      customer id.
   * @param date      customer id.
   * @throws ParseException throws an exception.
   */
  public static int insertcoupoffers(final String couponCode, final Date date, final int cusId) {
    int of = dao().updatecoup(couponCode, date, cusId);
    return of;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param cusId customer id.
   */
  public static int checkCouponcus(final int cusId) {
    int k = dao().checkcouponcus(cusId);
    return k;
  }
 /**
* Call the data base connection.
 * @return the array of customer object.
* @param cusId customer Id.
*/
  public static int delcoupcode(final int cusId) {
    int j = dao().delCoupcode(cusId);
    return j;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param cusId customer id.
   */
  public static Offers endcoupdate(final int cusId) {
    Offers k = dao().endCoupdate(cusId);
    return k;
  }
}
