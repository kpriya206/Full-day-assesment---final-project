package com.hexaware.MLP196.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import com.hexaware.MLP196.model.Customer;
import com.hexaware.MLP196.persistence.CustomerDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Car
/**
   * tests that customer login is handled correctly.
   */
public class CustomerFactoryTest {
  /**
  * default constructor testing.
 */
  @Test
public final void testdefaultConstructor() {
    CustomerFactory mf = new CustomerFactory();
    CustomerFactory mf1 = new CustomerFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
 /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testGetAllCustomer(@Mocked final CustomerDAO dao) {
    final Customer cus1 = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    final ArrayList<Customer> cusList = new ArrayList<Customer>();
    new Expectations() {
      {
        cusList.add(cus1);
        dao.show();
        result = cusList;
      }
    };

    new MockUp<CustomerFactory>() {

      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    Customer[] cusList1 = CustomerFactory.showCustomer();
    assertEquals(cus1, cusList1[0]);
  }
  /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void validateLogin(@Mocked final CustomerDAO dao) {
    final Customer expectedOut = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    new Expectations() {
      {
        dao.checkCustomer("RIYAREGI", "REGI");
        result = expectedOut;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    Customer actualOut = CustomerFactory.loginCustomer("RIYAREGI", "REGI");
    assertEquals(expectedOut, actualOut);
  }
    /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void signupcus(@Mocked final CustomerDAO dao) {
    final int cus3 = 1;
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.signingupcustomer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
        result = cus3;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.signupCustomer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    assertEquals(cus3, ca);
  }
   /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void editcus(@Mocked final CustomerDAO dao) {
    final int cus4 = 1;
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.editCustomer(5, "RIYAREGI");
        result = cus4;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.editdetailsCustomer(5, "RIYAREGI");
    assertEquals(cus4, ca);
  }
 /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void signupnewcus(@Mocked final CustomerDAO dao) {
    final int cus5 = 1;
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.signingupcustomer(5, "RIYAREGI", "REGI", "riyaregi@hexaware.com");
        result = cus5;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.signUpCustomer(5, "RIYAREGI", "REGI", "riyaregi@hexaware.com");
    assertEquals(cus5, ca);
  }
/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void returncusbal(@Mocked final CustomerDAO dao) {
    final Customer cus6 = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.cusbal(5);
        result = cus6;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    Customer ca = CustomerFactory.cusBalance(5);
    assertEquals(cus6, ca);
  }

/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void changecusdetail(@Mocked final CustomerDAO dao) {
    final int cus6 = 1;
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.editcus(5, "riyaregi@hexaware.com");
        result = cus6;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.editCus(5, "riyaregi@hexaware.com");
    assertEquals(cus6, ca);
  }

/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updatecuswallet(@Mocked final CustomerDAO dao) {
    final int cus6 = 1;
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.updatecusbal(5, 1000.00f);
        result = cus6;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.updateCusBal(5, 1000.00f);
    assertEquals(cus6, ca);
  }
/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void insertCus(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.insertCus(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.insertCus(c);
    assertEquals(1, ca);
  }
  /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updatecusprice(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.updateCusPrice(1000.0f, 5);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = CustomerFactory.updateCusPrice(c);
    assertEquals(1, ca);
  }
   /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showCustomer(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer(5, "RIYAREGI", "REGI", 1000.00f, "riyaregi@hexaware.com");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.showCus("kags");
        result = c;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    Customer ca = CustomerFactory.showCustomer("kags");
    assertEquals(c, ca);
  }
}
