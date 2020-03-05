package com.hexaware.MLP196.factory;

import com.hexaware.MLP196.persistence.CustomerDAO;
import com.hexaware.MLP196.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP196.model.Customer;

/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
/**
 * Call the data base connection.
 * @return the array of customer object.
 * @param cusId customer id
 * @param cusName customer name
 * @param cusPassword  customer
 * @param cusWallet customer
 * @param cusEmail customer email.
 */
  public static int signupCustomer(final int cusId, final String cusName, final String cusPassword, final Float cusWallet, final String cusEmail) {
    int i = dao().signingupcustomer(cusId, cusName, cusPassword, cusWallet, cusEmail);
    return i;
  }
// /**
// * Call the data base connection.
// * @return the array of customer object.
// * @param cusName customer name
// */
//   public static int removeCustomer(final String cusName) {
//     int j = dao().removingCustomer(cusName);
//     return j;
//   }
/**
* Call the data base connection.
* @return the array of customer object.
* @param cusId customer id
* @param cusName customer name
*/
  public static int editdetailsCustomer(final int cusId, final String cusName) {
    int k = dao().editCustomer(cusId, cusName);
    return k;
  }
/**
* Call the data base connection.
* @return the array of customer object.
* @param cusName customer name
* @param cusPassword customer password
*/
  public static Customer loginCustomer(final String cusName, final String cusPassword) {
    Customer c = dao().checkCustomer(cusName, cusPassword);
    return c;
  }
/**
* Call the data base connection.
* @return the array of customer object.
* @param cusId customer id.
* @param cusName customer name.
* @param cusPassword customer password.
* @param cusEmail customer email.
*/
  public static int signUpCustomer(final int cusId, final String cusName, final String cusPassword, final String cusEmail) {
    int c = dao().signingupcustomer(cusId, cusName, cusPassword, cusEmail);
    return c;
  }
/**
* Call the data base connection.
* @return the array of customer object.
* @param cusId customer id.
*/
  public static Customer cusBalance(final int cusId) {
    Customer c = dao().cusbal(cusId);
    return c;
  }
/**
  * Call the data base connection.
  * @return the array of customer object.
  * @param cusId customer id.
  * @param cusEmail customer email id.
  */
  public static int editCus(final int cusId, final String cusEmail) {
    int k = dao().editcus(cusId, cusEmail);
    return k;
  }
/**
  * Call the data base connection.
  * @return the array of customer object.
  * @param cusId customer id.
  * @param cusWallet customer wallet.
  */
  public static int updateCusBal(final int cusId, final Float cusWallet) {
    int k = dao().updatecusbal(cusId, cusWallet);
    return k;
  }
/**
  * Call the data base connection.
  * @param newCus new customer.
  * @return the array of customer object.
  */
  public static int insertCus(final Customer newCus) {
    final int insertResult = dao().insertCus(newCus.getCusId(), newCus.getCusName(), newCus.getCusPassword(), newCus.getCusWallet(),
        newCus.getCusEmail());
    return insertResult;
  }
  /**
  * Call the data base connection.
  * @param newCus new customer.
  * @return the array of customer object.
  */
  public static int updateCusPrice(final Customer newCus) {
    //final java.sql.Date scpdate = new java.sql.Date(date.getTime());
    int i = dao().updateCusPrice(newCus.getCusWallet(), newCus.getCusId());
    return i;
  }
  /**
  * Call the data base connection.
  * @param cusName new customer.
  * @return the array of customer object.
  */
  public static Customer showCustomer(final String cusName) {
    CustomerDAO cDao = dao();
    Customer cus = cDao.showCus(cusName);
    return cus;
  }

}
