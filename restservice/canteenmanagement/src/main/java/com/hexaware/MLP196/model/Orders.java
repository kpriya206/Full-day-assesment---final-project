package com.hexaware.MLP196.model;

import java.util.Date;
import java.util.Objects;

/**
 * Order class used to display order information.
 * @author Sowmya-hexware
 */

public class Orders {
/**
  * order to store orderId.
  */
  private int ordId;
  private int cusId;
  private String foodId;
  private int ordQty;
  private float ordTotalCost;
  private Date ordDate;
  private String ordStatus;
  private int venId;
  private String couponCode;
  private int tokenNo;
          /**
   * Default Constructor.
   */
  public Orders() {

  }
/**
* @param argOrdId to initialize order order id
* used to get details order through constructor.
* @param argCusId to initialize order customer id
* used to get details order through constructor.
* @param argFoodId to initialize order food id
* used to get details order through constructor.
* @param  argOrdQty to initialize order quantity
* used to get details order through constructor.
* @param argOrdTotalCost to initialize order total cost
* used to get details order through constructor.
* @param argOrdDate to initialize order date
* used to get details order through constructor.
* @param argVenId to initialize order vendor id
* used to get details order through constructor.
* @param argTokenNo to initialize order vendor id
* used to get details order through constructor.
* @param argOrdStatus to initialize order vendor id
* used to get details order through constructor.
* @param argCouponCode to initialize order vendor id
* used to get details order through constructor.
*/
  public Orders(final int argOrdId, final int argCusId,
             final String argFoodId, final int argOrdQty,
             final float argOrdTotalCost, final Date argOrdDate, final String argOrdStatus,
             final int argVenId, final String argCouponCode, final int argTokenNo) {
    this.ordId = argOrdId;
    this.cusId = argCusId;
    this.foodId = argFoodId;
    this.ordQty = argOrdQty;
    this.ordTotalCost = argOrdTotalCost;
    this.ordDate = new Date(argOrdDate.getTime());
    this.ordStatus = argOrdStatus;
    this.venId = argVenId;
    this.tokenNo = argTokenNo;
    this.couponCode = argCouponCode;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders order = (Orders) obj;
    if (Objects.equals(ordId, order.ordId) || Objects.equals(cusId, order.cusId)
        || Objects.equals(foodId, order.foodId)
        || Objects.equals(ordQty, order.ordQty) || Objects.equals(ordTotalCost, order.ordTotalCost)
        || Objects.equals(ordDate, order.ordDate)
        || Objects.equals(ordStatus, order.ordStatus) || Objects.equals(venId, order.venId)
        || Objects.equals(couponCode, order.couponCode)
        || Objects.equals(tokenNo, order.tokenNo)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(ordId, cusId, foodId, ordQty, ordTotalCost, ordDate, venId, couponCode, tokenNo);
  }
  /**
   * @return this order ID.
   */
  public final int getOrdId() {
    return ordId;
  }
  /**
   * @param argOrdId sets the order id.
   */
  public final void setOrdId(final int argOrdId) {
    this.ordId = argOrdId;
  }
/**
   * @return this customer ID.
   */
  public final int getCusId() {
    return cusId;
  }
  /**
   * @param argCusId sets the customer id.
   */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
   * @return order food id.
   */
  public final String getFoodId() {
    return foodId;
  }
  /**
   * @param argFoodId sets the order food id.
   */
  public final void setFoodId(final String argFoodId) {
    this.foodId = argFoodId;
  }
  /**
   * @return quantity.
   */
  public final int getOrdQty() {
    return ordQty;
  }
  /**
   * @param argOrdQty sets the quantity.
   */
  public final void setOrdQty(final int argOrdQty) {
    this.ordQty = argOrdQty;
  }
  /**
   * @return total cost.
   */
  public final float getOrdTotalCost() {
    return ordTotalCost;
  }
  /**
   * @param argOrdTotalCost sets the total cost.
   */
  public final void setOrdTotalCost(final int argOrdTotalCost) {
    this.ordTotalCost = argOrdTotalCost;
  }
    /**
      * @return argOrdDate.
      */
  public final Date getOrdDate() {
    return new Date(ordDate.getTime());
  }
  /**
  * @param argOrdDate sets the date.
  */
  public final void setOrdDate(final Date argOrdDate) {
    this.ordDate = new Date(argOrdDate.getTime());
  }
   /**
  * @return date.
  */
  public final String getOrdStatus() {
    return ordStatus;
  }
 /**
   * @param argOrdStatus sets the offer Id.
  */
  public final void setOrdStatus(final String argOrdStatus) {
    this.ordStatus = argOrdStatus;
  }
  /**
   * @return this vendor Id.
   */
  public final int getVenId() {
    return venId;
  }

  /**
   * @param argVenId sets the vendor id.
   */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
  /**
   * @return this coupon code.
   */
  public final String getCouponCode() {
    return couponCode;
  }

  /**
   * @param argCouponCode sets the coupon code.
   */
  public final void setCouponCode(final String argCouponCode) {
    this.couponCode = argCouponCode;
  }
  /**
   * @return this token  Number.
   */
  public final int getTokenNo() {
    return tokenNo;
  }
  /**
   * @param argTokenNo sets the vendor id.
   */
  public final void setTokenNo(final int argTokenNo) {
    this.tokenNo = argTokenNo;
  }
}
