package com.hexaware.MLP196.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import com.hexaware.MLP196.factory.OffersFactory;
import com.hexaware.MLP196.model.Offers;
import com.hexaware.MLP196.persistence.OffersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Car
/**
   * tests that updating offers is handled correctly.
   * @throws ParseException throws an exception.
   */
public class OffersFactoryTest {
  private Date d1 = new Date();
  private SimpleDateFormat sdf;
  /**
  * default constructor testing.
 */
  @Test
public final void testdefaultConstructor() {
    OffersFactory mf = new OffersFactory();
    OffersFactory mf1 = new OffersFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
  /**
   * tests that updating offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void testGetAllOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date2 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date2);
    final Offers off = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    final ArrayList<Offers> offersList = new ArrayList<Offers>();
    new Expectations() {
      {
        offersList.add(off);
        dao.show();
        result = offersList;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };

    Offers[] offersList1 = OffersFactory.showOffers();
    assertEquals(off, offersList1[0]);
  }
  /**
   * tests that adding offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void addOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date2 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date2);
    final java.sql.Date sdate = new java.sql.Date(d1.getTime());
    final int oa = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.addingoffers("Free2020", "Spinach", 12, 2, 45, sdate);
        result = oa;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int oa1 = OffersFactory.addOffers("Free2020", "Spinach", 12, 2, 45, date2);
    assertEquals(oa, oa1);
  }
    /**
   * tests that updating offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int ou = 1;
    new Expectations() {
      {
        dao.updatingOffers("Free2020", "Spinach");
        result = ou;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ou1 = OffersFactory.updateOffers("Free2020", "Spinach");
    assertEquals(ou, ou1);
  }
  /**
   * tests that update offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void upOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int up = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Offers");
        dao.updating(d1, "Free2020", 12);
        result = up;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offeres Dao");
        return dao;
      }
    };
    int up1 = OffersFactory.update(d1, "Free2020", 12);
    assertEquals(up, up1);
  }
  /**
   * tests that update offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateCoupon(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    int expected = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Offers");
        dao.updatecoupon("Free2020", 12);
        result = 1;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offeres Dao");
        return dao;
      }
    };
    int up1 = OffersFactory.updateCoupon("Free2020", 12);
    assertEquals(expected, up1);
  }
  /**
   * tests that adding offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void insertoffers(@Mocked final OffersDAO dao) throws ParseException {
    String date2 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date2);
    final java.sql.Date sdate = new java.sql.Date(d1.getTime());
    final Offers up = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.insertoff("Free2020",  12, "Spinach", 2, 45, sdate);
        result = 1;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int oa1 = OffersFactory.insertOff(up);
    assertEquals(1, oa1);
  }
    /**
   * tests that update offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void updateOfferItem(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Offers up = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    new Expectations() {
      {
        System.out.println("Mocked find a Offers");
        dao.updateoffitem("Spinach", 45);
        result = 1;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offeres Dao");
        return dao;
      }
    };
    int up1 = OffersFactory.updateOffItem(up);
    assertEquals(1, up1);
  }
  /**
   * tests that adding offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void showoffers(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final Offers up = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.showOff(45);
        result = up;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Offers oa1 = OffersFactory.showOffers(45);
    assertEquals(up, oa1);
  }
}
