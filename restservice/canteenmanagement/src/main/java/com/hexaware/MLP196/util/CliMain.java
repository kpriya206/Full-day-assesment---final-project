package com.hexaware.MLP196.util;
import java.util.Scanner;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private final Scanner option = new Scanner(System.in, "UTF-8");
  /**
   * main method is the basic entry point for the application.
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.entryAccess();
  }
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
  private CustomerUtil cusUtil = new CustomerUtil();
  /**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
  private VendorUtil venUtil = new VendorUtil();
  private void entryAccess() {
    System.out.println(".... KASK FOODS ......");
    System.out.println("1.CUSTOMER");
    System.out.println("2.VENDOR");
    System.out.println("3.EDIT PROFILE");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        cusUtil.accessCustomer();
        break;
      case 2:
        venUtil.accessVendor();
        break;
      case 3:
        cusUtil.profile();
        break;
      default:
        System.out.println("Either 1 or 2");
    }
  }
}
