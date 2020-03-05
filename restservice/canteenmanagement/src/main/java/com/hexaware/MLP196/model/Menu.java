package com.hexaware.MLP196.model;
import java.util.Objects;

/**
 * Customer class used to display customer information.
 * @author karpagapriya-hexware
 */
public class Menu {
/**
 * foodId to store cusId.
 */
  private String foodId;
  private String foodName;
  private Float foodPrice;
  private String foodCat;
/**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argFoodId to initialize cus id.
 * used to get details through constructor.
 * @param argFoodName to initialize cus name.
 * used to get details through constructor.
 * @param argFoodPrice to initialize cus password.
 * used to get details through constructor.
 * @param argFoodCat to initialize cus wallet details.
       * used to get details through constructor
 *
 */
  public Menu(final String argFoodId, final String argFoodName,
                final float argFoodPrice, final String argFoodCat) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.foodPrice = argFoodPrice;
    this.foodCat = argFoodCat;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) || Objects.equals(foodName, menu.foodName)
        || Objects.equals(foodPrice, menu.foodPrice) || Objects.equals(foodCat, menu.foodCat)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, foodPrice, foodCat);
  }
    /**
     * @return this food ID.
     */
  public final String getFoodId() {
    return foodId;
  }
  /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }
  /**
     * @return this food price.
     */
  public final Float getFoodPrice() {
    return foodPrice;
  }
  /**
     * @return this food category.
     */
  public final String getFoodCat() {
    return foodCat;
  }
 /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final String argFoodId) {
    this.foodId = argFoodId;
  }
  /**
     * @param argFoodName gets the food name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
     * @param argFoodPrice gets the food price.
     */
  public final void setFoodPrice(final Float argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }
  /**
     * @param argFoodCat gets the food category.
     */
  public final void setFoodCat(final String argFoodCat) {
    this.foodCat = argFoodCat;
  }
}
