package com.hexaware.MLP196.util;

import java.util.Locale;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import java.util.Scanner;

//import com.hexaware.MLP196.factory.CustomerFactory;
import com.hexaware.MLP196.factory.OrdersFactory;
import com.hexaware.MLP196.factory.VendorFactory;
//import com.hexaware.MLP196.model.Customer;
import com.hexaware.MLP196.model.Orders;
import com.hexaware.MLP196.model.Vendor;

/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class VendorUtil {
  private final Scanner option = new Scanner(System.in, "UTF-8");
    /**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
  public final void accessVendor() {
    System.out.println("\n WELCOME TO CANTEEN MANAGEMENT SYSTEM - VENDOR");
    System.out.println("1.Log In");
    System.out.println("2.Sign Up");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        System.out.println("Enter the venName");
        final String name = option.next();
        System.out.println("Enter the password");
        final String password = option.next();
        final Vendor v = VendorFactory.loginVendor(name, password);
        try {
          if (v.getVenName().equals(name) || v.getVenPassword().equals(password)) {
            System.out.println("VALID VENDOR  : PLEASE SEE THE ORDERS TABLE");
            displayOrderstable();
            // venupdatebal(totalPrice);
            System.out.println("Enter the Order id:");
            final int ordId = option.nextInt();
            final Orders o = OrdersFactory.disOrdStatus(ordId);
            System.out.println("Order History of" + ordId + "is :" + "\n" + o.getOrdStatus());
            // vendor will update the order status of that particular customer
            System.out.println("..... GOING TO UPDATE ORDER STATUS - ACCEPTED OR DENIED....." + "\n");
            vendorresponse();
          }
        } catch (RuntimeException e) {
          throw e;
        } catch (final Exception e) {
          System.out.println(" NOT VALID VENDOR : PLEASE REGISTER ");
        }
        break;
      case 2:
        System.out.println("Enter the Vendor Id:");
        final int venId = option.nextInt();
        System.out.println("Enter the venName:");
        final String venName = option.next();
        System.out.println("Enter the password:");
        final String venPassword = option.next();
        VendorFactory.signupVendor(venId, venName, venPassword);
        break;
      default:
        System.out.println("wrong entry");
    }
  }
  /**
   * displayOrders method display the orders item stored in database.
   */
  private void displayOrderstable() {
    final Orders[] orders = OrdersFactory.showOrders();
    System.out.println("ORD_ID" + "\t" + "CUS_ID" + "\t" + "FOOD_ID" + "\t" + "ORD_QTY" + "\t" + "ORD_TOTALCOST" + "\t"
        + "ORD_DATE" + "\t" + "ORD_STATUS" + "\t" + "VEN_ID" + "\t" + "COUPON_CODE" + "\t" + "TOKEN_NO");
    for (final Orders o : orders) {
      System.out.println(
          o.getOrdId() + "\t" + o.getCusId() + "\t" + o.getFoodId() + "\t" + o.getOrdQty() + "\t" + o.getOrdTotalCost()
          + "\t" + o.getOrdDate() + "\t" + o.getOrdStatus() + "\t" + o.getVenId() + "\t" + o.getCouponCode() + "\t" + o.getTokenNo());
    }
  }
  /**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
  public final void vendorresponse() {
    //final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   // LocalDateTime localDateTime = LocalDateTime.now();
   // String cdate = dtf.format(localDateTime);
    String y = "ACCEPTED";
    String n = "DENIED";
    Locale locale = Locale.ENGLISH;
    System.out.println("DO YOU WANT TO CONTINUE THE ORDER :");
    String response = option.next().toUpperCase(locale);
    if (response.equals("Y")) {
      System.out.println("ORDER IS ACCEPTED");
      // OBTAINING THE ORDER COST BASED ON ID
      System.out.println("Enter the ord id:");
      int ordId = option.nextInt();
      Orders tp = OrdersFactory.getOrdCost(ordId);
      System.out.println("The cost of ordered item is :" + tp.getOrdTotalCost());
      float ordcost = tp.getOrdTotalCost();
      // OBTAINING THE VENDOR BALANCE
      System.out.println("Enter the VEN ID :");
      int venId = option.nextInt();
      Vendor vb = VendorFactory.getVenbalance(venId);
      System.out.println("The vendor wallet amt is :" + vb.getVenBal());
      float venbal =  vb.getVenBal();
      // TO ADD THE VENDOR BALANCE + ORDERED COST
      float venAmtinc = ordcost + venbal;
      System.out.println("The vendor amount incremented is:" + venAmtinc);
      // Update this venAmtinc into the vendor table
      VendorFactory.updateAmt(venId, venAmtinc);
      OrdersFactory.updateOrderStatus(ordId, y);
      System.out.println(".... THE VENDOR STATUS IS UPDATED....\n" +  "...... THE VENDOR BALANCE IS UPDATED ............");
    } else {
      System.out.println("ORDER IS DENIED" + "STATUS:" + n);
      System.out.println("AMOUNT WILL BE RETURNED SOON !!!");
    //float ordcost;
   // the total price of order will be added with the customer wallet
      //System.out.println("Enter the customer id:");
    //  int cusId = option.nextInt();
    }
  }
}
