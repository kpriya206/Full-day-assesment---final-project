package com.hexaware.MLP196.model;

import com.hexaware.MLP196.persistence.OffersDAO;
import com.hexaware.MLP196.factory.OffersFactory;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Offers.
 */
@RunWith(JMockit.class)
public class OffersTest {
  private Date d1 = new Date();
  private Date d2 = new Date();
  private SimpleDateFormat sdf;
  /**
   * tests that empty employee list is handled correctly.
   * @throws ParseException exception.
   */
  @Before
  public final void initInput() throws ParseException {
    String date1 = "2020/09/09";
    String date2 = "2020/07/05";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    d2 = sdf.parse(date2);
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
public final void testOffers() {
    Offers oFF06 = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    Offers oFF07 = new Offers("Free2020", 13, "blacktea", 7, 43, d2);
    assertNotEquals(oFF06, null);
    assertNotEquals(oFF07, null);
    assertEquals(oFF06.getCouponCode(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getCouponCode());
    assertEquals(oFF06.getOffItem(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getOffItem());
    assertEquals(oFF06.getCusId(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getCusId());
    assertEquals(oFF06.getVenId(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getVenId());
    assertEquals(oFF06.getOrdId(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getOrdId());
    assertEquals(oFF06.getDateOfCouponCode(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).getDateOfCouponCode());
    oFF07.setCouponCode("Free2020");
    oFF07.setCusId(13);
    oFF07.setOffItem("blacktea");
    oFF07.setVenId(7);
    oFF07.setOrdId(43);
    assertEquals(oFF06, new Offers("Free2020", 12, "Spinach", 2, 45, d1));
    assertEquals(oFF06.hashCode(),
        new Offers("Free2020", 12, "Spinach", 2, 45, d1).hashCode());
    assertEquals(oFF06, new Offers("Free2020", 12, "Spinach", 2, 45, d1));
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OffersDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Offers>();
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] of = OffersFactory.showOffers();
    assertEquals(0, of.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OffersDAO dao) {
    final Offers oFF06 = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    final Offers oFF07 = new Offers("Free2020", 12, "Spinach", 2, 45, d1);
    final ArrayList<Offers> oa = new ArrayList<Offers>();
    new Expectations() {
      {
        oa.add(oFF06);
        oa.add(oFF07);
        dao.show(); result = oa;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] oa1 = OffersFactory.showOffers();
    assertEquals(2, oa1.length);
    assertEquals(new Offers("Free2020", 12, "Spinach", 2, 45, d1).getCouponCode(),
        oa1[0].getCouponCode());
    assertEquals(new Offers("Free2020", 13, "blacktea", 7, 43, d2).getCouponCode(),
        oa1[1].getCouponCode());
  }
   /**
 * @final to test the whether the coupon code is setting
 */
  @Test
public final void testOffersDefaultConstructor() {
    Offers newOffers = new Offers();
    assertEquals(newOffers.hashCode(), new Offers().hashCode());
    newOffers.setCouponCode("Free2020");
    assertNotEquals(newOffers.getCouponCode(), new Offers().getCouponCode());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersParameterisedConstructor() {
    Offers newOffers = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    assertEquals("Free2020", newOffers.getCouponCode());
    assertEquals(14, newOffers.getCusId());
    assertEquals("Badam", newOffers.getOffItem());
    assertEquals(65, newOffers.getOrdId());
    assertEquals(5, newOffers.getVenId());
    assertEquals(d1, newOffers.getDateOfCouponCode());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersSetCouponCode() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setCouponCode("Free2020");
    assertEquals("Free2020", newOffers2.getCouponCode());
  }
/**
 * @final test whether cusid is handled correctly
 */
  @Test
public final void testOffersSetCusId() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setCusId(14);
    assertEquals(14, newOffers2.getCusId());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersSetOfferItem() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setOffItem("Badam");
    assertEquals("Badam", newOffers2.getOffItem());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersSetOrdId() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setOrdId(5);
    assertEquals(5, newOffers2.getOrdId());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersSetVenId() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setVenId(65);
    assertEquals(65, newOffers2.getVenId());
  }
/**
* @final to test the whether the coupon code is setting
*/
  @Test
public final void testOffersSetDateofCoupon() {
    Offers newOffers2 = new Offers("Free2020", 14, "Badam", 5, 65, d1);
    newOffers2.setDateOfCouponCode(d1);
    assertEquals(d1, newOffers2.getDateOfCouponCode());
  }
}
