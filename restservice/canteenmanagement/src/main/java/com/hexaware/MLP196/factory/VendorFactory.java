package com.hexaware.MLP196.factory;

import com.hexaware.MLP196.persistence.VendorDAO;
import com.hexaware.MLP196.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP196.model.Vendor;
/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
    /**
     *  Protected constructor.
     */
  protected VendorFactory() {
  }
    /**
     * Call the data base connection.
     * @return the connection object.
     */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
    /**
     * Call the data base connection.
     * @return the array of Vendor object.
     */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
 /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param cusId customer id
   * @param venId vendor id
   * @param venName vendor name
   * @param venBal vendor balance
   * @param venPassword vendor password
   */
  public static int addVendor(final int cusId, final int venId, final String venName, final float venBal, final String venPassword) {
    int i = dao().addingvendor(cusId, venId,  venName, venBal, venPassword);
    return i;
  }
// /**
//   * Call the data base connection.
//   * @return the array of vendor object.
//    * @param venName vendor name
//   */
//   public static int deleteVendor(final String venName) {
//     int j = dao().deletingvendor(venName);
//     return j;
//   }
/**
  * Call the data base connection.
  * @return the array of vendor object.
  * @param venId vendor id
  * @param venName vendor name
  */
  public static int updateVendor(final int venId, final String venName) {
    int k = dao().updatingvendor(venId, venName);
    return k;
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param venName vendor name
   * @param venPassword vendor password
   */
  public static Vendor loginVendor(final String venName, final String venPassword) {
    Vendor i = dao().loggingVendor(venName, venPassword);
    return i;
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param venId customer id
   * @param venName vendor name
   * @param venPassword vendor password
   */
  public static int signupVendor(final int venId, final String venName, final String venPassword) {
    int i = dao().signingvendor(venId, venName, venPassword);
    return i;
  }
  /**
  * Call the data base connection.
  * @return the array of vendor object.
   * @param venId vendor id
  */
  public static Vendor getVenbalance(final int venId) {
    Vendor j = dao().getVenbalance(venId);
    return j;
  }
  /**
  * Call the data base connection.
  * @return the array of vendor object.
  * @param venId vendor id
  * @param venBal vendor Bal
  */
  public static int updateAmt(final int venId, final float venBal) {
    int j = dao().updateamt(venId, venBal);
    return j;
  }
  /**
  * Call the data base connection.
  * @param newVen new customer.
  * @return the array of customer object.
  */
  public static int insertVen(final Vendor newVen) {
    final int insertResult = dao().insertven(newVen.getCusId(), newVen.getVenId(), newVen.getVenName(), newVen.getVenBal(),
        newVen.getVenPassword());
    return insertResult;
  }
/**
  * Call the data base connection.
  * @param newVen new vendor.
  * @return the array of vendor object.
  */
  public static int updateVenPrice(final Vendor newVen) {
    //final java.sql.Date scpdate = new java.sql.Date(date.getTime());
    int i = dao().updatevenPrice(newVen.getVenBal(), newVen.getVenId());
    return i;
  }
  /**
  * Call the data base connection.
  * @param venName new vendor.
  * @return the array of vendor object.
  */
  public static Vendor showVendor(final String venName) {
    VendorDAO cDao = dao();
    Vendor ven = cDao.showVen(venName);
    return ven;
  }

}
