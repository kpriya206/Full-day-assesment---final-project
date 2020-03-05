package com.hexaware.MLP196.model;

import com.hexaware.MLP196.persistence.VendorDAO;
import com.hexaware.MLP196.factory.VendorFactory;
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
import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class VendorTest {
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  private static final double DELTA = 1e-15;
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  private Vendor v;
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    v = new Vendor();
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testVendor() {
    Vendor v10 = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    Vendor v11 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    assertNotEquals(v10, null);
    assertNotEquals(v11, null);
    v10.setCusId(0);
    v10.setVenId(10);
    v10.setVenName("RAM");
    v10.setVenBal(4000.0f);
    v10.setVenPassword("ram123");
    v11.setCusId(1);
    v11.setVenId(11);
    v11.setVenName("ASRI");
    v11.setVenBal(3500.0f);
    v11.setVenPassword("DADDY");
    assertEquals(v10.getCusId(),
        new Vendor(0, 10, "RAM", 4000.0f, "ram123").getCusId());
    assertEquals(v10.getVenId(),
        new Vendor(0, 10, "RAM", 4000.0f, "ram123").getVenId());
    assertEquals(v10.getVenName(),
        new Vendor(0, 10, "RAM", 4000.0f, "ram123").getVenName());
    assertEquals(v10.getVenPassword(),
        new Vendor(0, 10, "RAM", 4000.0f, "ram123").getVenPassword());
    assertEquals(v10.hashCode(),
        new Vendor(0, 10, "RAM", 4000.0f, "ram123").hashCode());
    assertEquals(v10, new Vendor(0, 10, "RAM", 4000.0f, "ram123"));

    assertEquals(v11.getCusId(),
        new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").getCusId());
    assertEquals(v11.getVenId(),
        new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").getVenId());
    assertEquals(v11.getVenName(),
        new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").getVenName());
    assertEquals(v11.getVenPassword(),
        new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").getVenPassword());
    assertEquals(v11.hashCode(),
        new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").hashCode());
    assertNotEquals(v10, new Vendor(1, 11, "ASRI", 3500.0f, "DADDY"));
  }
      /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Vendor>();
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] ven = VendorFactory.showVendor();
    assertEquals(0, ven.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
  */
  @Test
  public final void testListAllSome(@Mocked final VendorDAO dao) {
    final Vendor v10 = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    final Vendor v11 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    final ArrayList<Vendor> ven = new ArrayList<Vendor>();
    new Expectations() {
      {
        ven.add(v10);
        ven.add(v11);
        dao.show(); result = ven;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] ven1 = VendorFactory.showVendor();
    assertEquals(2, ven1.length);
    assertEquals(new Vendor(0, 10, "RAM", 4000.0f, "ram123").getVenId(),
        ven1[0].getVenId());
    assertEquals(new Vendor(1, 11, "ASRI", 3500.0f, "DADDY").getVenId(),
        ven1[1].getVenId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendordefaultConstructor() {
    Vendor newVendor = new Vendor();
    assertEquals(newVendor.hashCode(), new Vendor().hashCode());
    newVendor.setVenId(10);
    assertNotEquals(newVendor.getVenId(), new Vendor().getVenId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorParameterisedConstructor() {
    Vendor newVendor = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    // testing Vendor variables are initialized through getters which in turn to know where its returning a correct values.
    assertEquals(1, newVendor.getCusId());
    assertEquals(11, newVendor.getVenId());
    assertEquals("ASRI", newVendor.getVenName());
    assertEquals(3500.0f, newVendor.getVenBal(), DELTA);
    assertEquals("DADDY", newVendor.getVenPassword());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorSetId() {
    Vendor newVendor1 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    newVendor1.setVenId(11);
    assertEquals(11, newVendor1.getVenId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorSetCusId() {
    Vendor newVendor2 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    newVendor2.setCusId(1);
    assertEquals(1, newVendor2.getCusId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorSetVenName() {
    Vendor newVendor2 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    newVendor2.setVenName("ASRI");
    assertEquals("ASRI", newVendor2.getVenName());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorSetVenBal() {
    Vendor newVendor2 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    newVendor2.setVenBal(3500.0f);
    assertEquals(3500.0f, newVendor2.getVenBal(), DELTA);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorSetVenPassword() {
    Vendor newVendor2 = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    newVendor2.setVenPassword("DADDY");
    assertEquals("DADDY", newVendor2.getVenPassword());
  }
}
