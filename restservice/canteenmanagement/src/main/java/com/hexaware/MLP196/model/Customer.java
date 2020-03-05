package com.hexaware.MLP196.model;
import java.util.Objects;

/**
 * Customer class used to display customer information.
 * @author karpagapriya-hexware
 */
public class Customer {
/**
 * cusId to store cusId.
 */
  private int cusId;
  private String cusName;
  private String cusPassword;
  private Float cusWallet;
  private String cusEmail;
/**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argCusId to initialize cus id.
 * used to get details through constructor.
 * @param argCusName to initialize cus name.
 * used to get details through constructor.
 * @param argCusPassword to initialize cus password.
 * used to get details through constructor.
 * @param argCusWallet to initialize cus wallet details.
 * used to get details through constructor
 * @param argCusEmail to initialize cus wallet details.
 * used to get details through constructor
 *
 */
  public Customer(final int argCusId, final String argCusName,
                final String argCusPassword, final Float argCusWallet, final String argCusEmail) {
    this.cusId = argCusId;
    this.cusName = argCusName;
    this.cusPassword = argCusPassword;
    this.cusWallet = argCusWallet;
    this.cusEmail = argCusEmail;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    Customer customer = (Customer) obj;
    if (Objects.equals(cusId, customer.cusId) || Objects.equals(cusName, customer.cusName)
        || Objects.equals(cusPassword, customer.cusPassword)
        || Objects.equals(cusEmail, customer.cusEmail)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusName, cusPassword, cusWallet, cusEmail);
  }
    /**
     * @return this cus ID.
     */
  public final int getCusId() {
    return cusId;
  }
  /**
     * @return this cus Name.
     */
  public final String getCusName() {
    return cusName;
  }
  /**
   * @return this cus Password.
   */
  public final String getCusPassword() {
    return cusPassword;
  }
  /**
     * @return this cus Wallet Details.
     */
  public final float getCusWallet() {
    return cusWallet;
  }
   /**
   * @return this cus email.
   */
  public final String getCusEmail() {
    return cusEmail;
  }
 /**
     * @param argCusId gets the cus id.
     */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
     * @param argCusName gets the cus name.
     */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }
  /**
     * @param argCusPassword gets the cus Password.
     */
  public final void setCusPassword(final String argCusPassword) {
    this.cusPassword = argCusPassword;
  }
  /**
     * @param argCusWallet gets the cus Wallet Details.
     */
  public final void setCusWallet(final Float argCusWallet) {
    this.cusWallet = argCusWallet;
  }
  /**
     * @param argCusEmail gets the cus Password.
     */
  public final void setCusEmail(final String argCusEmail) {
    this.cusEmail = argCusEmail;
  }
}
