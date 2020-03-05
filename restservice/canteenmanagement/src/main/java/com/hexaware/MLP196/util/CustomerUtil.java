package com.hexaware.MLP196.util;
import java.util.Scanner;
import com.hexaware.MLP196.factory.CustomerFactory;
import com.hexaware.MLP196.factory.OrdersFactory;
import com.hexaware.MLP196.model.Customer;
import com.hexaware.MLP196.model.Orders;

/**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
public class CustomerUtil {
  private final Scanner option = new Scanner(System.in, "UTF-8");
// PROFILE METHOD - 1. display order history  2. edit customer details
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
  public final void profile() {

    System.out.println("Enter the customer id:");
    int cusId = option.nextInt();
    System.out.println("choose the option 1 or 2 :");
    int choose = option.nextInt();
    switch (choose) {
      case 1:
        Orders o =  OrdersFactory.cusOrdHis(cusId);
        System.out.println("Order History of " + cusId + "\t" + "is :" + o.getOrdStatus());
        break;
      case 2:
        System.out.println("EDIT DETAILS OF CUSTOMER");
        editdetails();
        break;
      default:
        System.out.println("WRONG");
    }
  }
  private void editdetails() {
    System.out.println("Enter the Customer id:");
    final int cusId = option.nextInt();
    System.out.println("enter customer email id");
    final String cusEmail = option.next();
    CustomerFactory.editCus(cusId, cusEmail);
  }
  /**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
  private OrderUtil ordUtil = new OrderUtil();
  /**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
  public final void accessCustomer() {
    System.out.println(" WELCOME TO CANTEEN MANAGEMENT SYSTEM - CUSTOMER");
    System.out.println("1.Log In");
    System.out.println("2.Sign Up");
    System.out.println("Choose an option");
    final int choose = option.nextInt();
    switch (choose) {
      case 1:
        System.out.println("-------------------------------------");
        System.out.println(" Enter the customer name : ");
        final String name = option.next();
        System.out.println(" Enter the customer password : ");
        final String password = option.next();
        final Customer c = CustomerFactory.loginCustomer(name, password);
        try {
          if (c.getCusName().equals(name) && c.getCusPassword().equals(password)) {
            System.out.println("VALID USER : PLACE AN ORDER \n ");
            ordUtil.placingorder();
            System.out.println("......... THANK YOU FOR ORDERING .....................");
          }
        } catch (RuntimeException e) {
          throw e;
        } catch (final Exception e) {
          System.out.println(" NOT VALID USER : PLEASE REGISTER ");
        }
        break;

      case 2:
        System.out.println(" Enter the customer Id :");
        final int cusId = option.nextInt();
        System.out.println(" Enter the customer name : ");
        final String username = option.next();
        System.out.println(" Enter the password : ");
        final String pwd = option.next();
        System.out.println(" Enter the wallet amount : ");
        final String email = option.next();
        CustomerFactory.signUpCustomer(cusId, username, pwd, email);
        break;
      default:
        System.out.println("wrong entry");
    }
  }
}
