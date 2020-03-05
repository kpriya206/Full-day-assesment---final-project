package com.hexaware.MLP196.model;

import java.util.Date;
import java.util.Objects;

/**
 * Customer class used to display customer information.
 * @author hexware
 */
public class Offers {
/**
 * foodId to store foodId.
 */
  private String couponCode;
  private int cusId;
  private String offItem;
  private int venId;
  private int ordId;
  private Date dateOfCouponCode;
/**
 * @param argCouponCode to initialize coupon code.
 * @param argCusId to initialize customer id.
 * @param argOffItem to initialize off gift.
 * @param argVenId to initialize vendor id.
 * @param argOrdId to initialize order date.
 * @param argDateOfCouponCode to initialize date of coupon.
 * used to get details through constructor.
*/
  public Offers(final String argCouponCode, final int argCusId, final String argOffItem, final int argVenId,
      final int argOrdId, final Date argDateOfCouponCode) {
    this.couponCode = argCouponCode;
    this.cusId = argCusId;
    this.offItem = argOffItem;
    this.venId = argVenId;
    this.ordId = argOrdId;
    this.dateOfCouponCode =  new Date(argDateOfCouponCode.getTime());
  }
   /**
   * Default Constructor.
   */
  public Offers() {
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Offers offers = (Offers) obj;
    if (Objects.equals(couponCode, offers.couponCode)
        || Objects.equals(cusId, offers.cusId)
        || Objects.equals(offItem, offers.offItem)
        || Objects.equals(venId, offers.venId)
        || Objects.equals(ordId, offers.ordId)
        || Objects.equals(dateOfCouponCode, offers.dateOfCouponCode)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(couponCode, cusId, offItem, venId, ordId, dateOfCouponCode);
  }
  /**
  * @return this coupon code
  */
  public final String getCouponCode() {
    return couponCode;
  }
  /**
     * @return this Customer ID.
     */
  public final int getCusId() {
    return cusId;
  }
  /**
     * @return this offer item.
     */
  public final String getOffItem() {
    return offItem;
  }
  /**
     * @return this vendor id.
     */
  public final int getVenId() {
    return venId;
  }
  /**
     * @return order id.
     */
  public final int getOrdId() {
    return ordId;
  }
  /**
     * @return date of coupon code.
     */
  public final Date getDateOfCouponCode() {
    return new Date(dateOfCouponCode.getTime());
  }
  /**
     * @param argCouponCode gets the coupon code.
  */
  public final void setCouponCode(final String argCouponCode) {
    this.couponCode = argCouponCode;
  }
  /**
   * @param argCusId gets the customer id.
    */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
     * @param argOffItem gets the offer item.
     */
  public final void setOffItem(final String argOffItem) {
    this.offItem = argOffItem;
  }
/**
  * @param argVenId gets the Vendor id.
  */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
   /**
     * @param argOrdId gets the ord id.
     */
  public final void setOrdId(final int argOrdId) {
    this.ordId = argOrdId;
  }
  /**
     * @param argDateOfCouponCode gets the date of coupon code.
  */
  public final void setDateOfCouponCode(final Date argDateOfCouponCode) {
    this.dateOfCouponCode  = new Date(argDateOfCouponCode.getTime());
  }
}
