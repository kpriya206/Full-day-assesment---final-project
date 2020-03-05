package com.hexaware.MLP196.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

import com.hexaware.MLP196.factory.CustomerFactory;
import com.hexaware.MLP196.factory.MenuFactory;
import com.hexaware.MLP196.factory.OffersFactory;
import com.hexaware.MLP196.factory.OrdersFactory;
import com.hexaware.MLP196.model.Customer;
//import com.hexaware.MLP196.model.Customer;
import com.hexaware.MLP196.model.Menu;
import com.hexaware.MLP196.model.Offers;
//import com.hexaware.MLP196.model.Offers;
import com.hexaware.MLP196.model.Orders;

/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class OrderUtil {
  private final Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * displaymenu method display the menu item stored in database.
   */
  public final void displaymenutable() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("FOOD_ID" + "\t" + "FOOD_NAME" + "\t" + "FOOD_PRICE" + "\t" + "FOOD_CAT");
    for (final Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodPrice() + "\t" + m.getFoodCat());
    }
  }
  /**
   * CliMain used as Client interface for java coading.
   * @author hexware
   * @throws ParseException throws an exception.
   */
  public final void placingorder() throws ParseException {
    int cusId;
    Date d2;
    int c = 0;
    System.out.println("Enter the customer id:");
    cusId = option.nextInt();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    //Orders cd = OrdersFactory.checkDate(cusId);
    Calendar cal = Calendar.getInstance();
    String date = sdf.format(cal.getTime());
    Date d1 = sdf.parse(date);
    cal.add(Calendar.DAY_OF_MONTH, 10);
    String endDate = sdf.format(cal.getTime());
    Date d3 = sdf.parse(endDate);
    System.out.println("\n------------------------MENU LIST-----------------------------");
    displaymenutable();
    System.out.println("\nEnter the food Id :");
    String foodId = option.next();
    System.out.println("\nEnter the food qty:");
    int ordQty = option.nextInt();
      // to check if there is any coupon for that customer and also checks if he is first customer or not
    Orders o = OrdersFactory.checkCoupon(cusId);
    if (o == null) {
      System.out.println("HURRAY!!! YOU HAVE WON A COUPON AND IS VALID UPTO" + d3);
      String coup = "FREE2020";
      OffersFactory.insertcoupoffers(coup, d3, cusId); // to update into the offers table after recieving coupon
      orderItems(foodId, cusId, d1, ordQty);  // normal place order
      OrdersFactory.upcoupcode(cusId, coup); // to update the coupon code into orders table
      System.out.println("THANK YOU !!!");
    } else {
      System.out.println("DO YOU HAVE ANY COUPON ??");
      String getCoup = option.next();
      if (getCoup.equals("n")) {
        orderItems(foodId, cusId, d1, ordQty);  // normal place order
      }
      if (getCoup.equals("y")) {
        Offers ed = OffersFactory.endcoupdate(cusId);
        if (ed != null) {
          d2 = ed.getDateOfCouponCode();
          c = d1.compareTo(d2);
          if (c < 0) {
            orderOffItems(foodId, cusId, d1, ordQty);  // place order with offer
          } else {
            orderItems(foodId, cusId, d1, ordQty);  // normal place order
          }
        }
      }
    }
  }
  /**
   * CliMain used as Client interface for java coading.
   * @author hexware
   * @param foodId food id.
   * @param cusId  customer id.
   * @param ordQty order quantity.
   * @param date   date.
   * @throws ParseException throws an exception.
   */
  public final void orderItems(final String foodId, final int cusId, final Date date, final int ordQty)
      throws ParseException {
    Menu m = MenuFactory.choosemenu(foodId);
    System.out.println("\nThe FOOD ID for the choosen item is:" + m.getFoodId());
    int totalPrice = (int) (m.getFoodPrice() * ordQty);
    System.out.println("\nThe TOTAL COST of ordered food is:");
    System.out.println(totalPrice);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    System.out.println("\nEnter the customer id :\n");
    int cId = option.nextInt();
    Customer c = CustomerFactory.cusBalance(cId);
    System.out.println("\nThe amount in customer wallet is = " + c.getCusWallet());
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    float cusbal = c.getCusWallet();
    if (cusbal < totalPrice) {
      System.out.println("....................... ORDER IS DENIED ...............................");
    } else {
      finalord(cId, foodId, totalPrice, ordQty, date, cusbal);
    }
  }
  /**
   * CliMain used as Client interface for java coading.
   * @author hexware
   * @param foodId food id.
   * @param cusId  customer id.
   * @param date   date.
   * @param ordQty order quantity.
   * @throws ParseException throws an exception.
   */
  public final void orderOffItems(final String foodId, final int cusId, final Date date, final int ordQty)
      throws ParseException {
    Menu m = MenuFactory.choosemenu(foodId);
    System.out.println("\nThe FOOD ID for the choosen item is:" + m.getFoodId());
    int totalPrice = (int) (m.getFoodPrice() * ordQty);
    System.out.println("\nThe TOTAL COST of ordered food is:" + totalPrice);
    int offamt = 100;
    int disamt = totalPrice - offamt;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    System.out.println("\nEnter the customer id :\n");
    int cId = option.nextInt();
    Customer c = CustomerFactory.cusBalance(cId);
    if (c != null) {
      float b = c.getCusWallet();
      System.out.println("\nThe amount in customer wallet is = " + b);
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
      float cusbal = c.getCusWallet();
      if (cusbal < disamt) {
        System.out.println("....................... ORDER IS DENIED ...............................");
      } else {
        finalord(cId, foodId, disamt, ordQty, date, cusbal);
         ///// remove the coupon code from orders table
        OffersFactory.delcoupcode(cId);
      }
    } else {
      System.out.println("Enter valid cus Id");
    }
  }
  /**
   * CliMain used as Client interface for java coading.
   * @author hexware
   * @return the token number.
   */
  public final int tokenGenerate() {
    int orders = (int) OrdersFactory.createToken();
    return orders;
  }
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 * @param foodId food id.
 * @param cusId  customer id.
 * @param date   date.
 * @param disamt discount amt.
 * @param ordQty order quantity.
 * @param cusbal customer balance.
 * @throws ParseException throws an exception.
 */
  public final void finalord(final int cusId, final String foodId, final int disamt, final int ordQty, final Date date,
      final float cusbal) throws ParseException {
    System.out.println("\n.............. ORDER IS ACCEPTED !!!! ..........................\n");
    System.out.println("\nCUSTOMER ID IS:\n" + cusId + "\nFOOD ID IS:\n" + foodId);
    System.out.println("\nTOTAL COST:\n" + disamt + "\nORDER DATE IS:\n" + date);
    Customer c = CustomerFactory.cusBalance(cusId);
    float bal = c.getCusWallet();
    bal = bal - disamt;
    System.out.println("\nThe remaining balance amount in customer wallet is" + bal + "\n");
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    String y = "ACCEPTED";
    String n = "DENIED";
    Locale locale = Locale.ENGLISH;
    System.out.println("DO YOU WANT TO CONTINUE THE ORDER :");
    String response = option.next().toUpperCase(locale);
    if (response.equals("Y")) {
      System.out.println("YES!!! CONTINUE WITH MY ORDER" + y);
    } else {
      System.out.println("NO!!! CANCEL MY ORDER" + n);
    }
    CustomerFactory.updateCusBal(cusId, bal);
    System.out.println("\n ............... THE CUSTOMER WALLET IS UPDATED .............................\n");
    String ordStatus = "ORDERED";
    int otoken = tokenGenerate();
    System.out.println("The token generated is :" + otoken);
    OrdersFactory.insertOrders(cusId, disamt, ordQty, date, ordStatus, foodId, otoken);
    System.out.println("\n................... UPDATED INTO THE ORDER TABLE ......................\n");
  }
}
