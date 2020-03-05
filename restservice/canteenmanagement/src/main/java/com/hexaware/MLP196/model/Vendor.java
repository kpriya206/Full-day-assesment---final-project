package com.hexaware.MLP196.model;
import java.util.Objects;

/**
 * Vendor class used to display vendor information.
 * @author asritha-hexware
 */

public class Vendor {
    /**
 * venId to store vendorId.
 */
  private int cusId;
  private int venId;
  private String venName;
  private Float venBal;
  private String venPassword;
/**
     * Default Constructor.
     */
  public Vendor() {

  }
  /**
   * @param argCusId to initialize vendor id.
   * used to get details through constructor.
   * @param argVenId to initialize vendor id.
   * used to get details through constructor.
   * @param argVenName to initialize vendor name.
   * used to get details through constructor.
   * @param argVenBal to initialize vendor email id.
   * used to get details through constructor.
   * @param argVenPassword to initialize vendor Password.
   * used to get details through constructor.
    */
  public Vendor(final int argCusId, final int argVenId, final String argVenName,
                  final Float argVenBal, final String argVenPassword) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.venName = argVenName;
    this.venBal = argVenBal;
    this.venPassword = argVenPassword;
  }
  @Override
      public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    Vendor vendor = (Vendor) obj;
    if (Objects.equals(cusId, vendor.cusId)
          || Objects.equals(venId, vendor.venId)
          || Objects.equals(venName, vendor.venName)
          || Objects.equals(venBal, vendor.venBal)
          || Objects.equals(venPassword, vendor.venPassword)) {
      return true;
    }
    return false;
  }
  @Override
      public final int hashCode() {
    return Objects.hash(cusId, venId, venName, venBal, venPassword);
  }
      /**
       * @return this customer Id.
       */
  public final int getCusId() {
    return cusId;
  }
    /**
       * @return this vendor id.
       */
  public final int getVenId() {
    return venId;
  }
    /**
       * @return this vendor name.
       */
  public final String getVenName() {
    return venName;
  }
    /**
       * @return this vendor balance.
       */
  public final float getVenBal() {
    return venBal;
  }
  /**
       * @return this vendor Password.
       */
  public final String getVenPassword() {
    return venPassword;
  }
   /**
       * @param argCusId gets the customer id.
       */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
    /**
       * @param argVenId gets the vendor id.
       */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
    /**
       * @param argVenName gets the vendor name.
       */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
    /**
       * @param argVenBal gets the vendor balance.
       */
  public final void setVenBal(final float argVenBal) {
    this.venBal = argVenBal;
  }
  /**
       * @param argVenPassword gets the vendor Password.
       */
  public final void setVenPassword(final String argVenPassword) {
    this.venPassword = argVenPassword;
  }
}
