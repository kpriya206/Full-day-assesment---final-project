package com.hexaware.MLP196.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

//import com.hexaware.MLP196.factory.VendorFactory;
import com.hexaware.MLP196.model.Vendor;
import com.hexaware.MLP196.persistence.VendorDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Vendor
/**
   * tests that adding Vendor is handled correctly.
   */
public class VendorFactoryTest {
  /**
  * default constructor testing.
 */
  @Test
public final void testdefaultConstructor() {
    VendorFactory mf = new VendorFactory();
    VendorFactory mf1 = new VendorFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
  /**
   * tests that adding Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testGetAllVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(0, 10, "KESAV", 4000.0f, "ram123");
    final ArrayList<Vendor> venList = new ArrayList<Vendor>();
    new Expectations() {
      {
        venList.add(v1);
        dao.show();
        result = venList;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] venList1 = VendorFactory.showVendor();
    assertEquals(v1, venList1[0]);
  }
  /**
   * tests that adding Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void loggingVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.loggingVendor("RAM", "ram123");
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor vn = VendorFactory.loginVendor("RAM", "ram123");
    assertEquals(v1, vn);
  }
   /**
   * tests that adding Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void addVendor(@Mocked final VendorDAO dao) {
    final int av = 1;
    new Expectations() {
        {
          System.out.println("Mocked find a Vendor");
          dao.addingvendor(2, 12, "ASRITHA", 3500.0f, "DADDY123");
          result = av;
        }
      };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
          System.out.println("Mocked Vendor Dao");
          return dao;
        }
      };
    int av1 = VendorFactory.addVendor(2, 12, "ASRITHA", 3500.0f, "DADDY123");
    assertEquals(av, av1);
  }
 /**
   * tests that updating Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updateVendor(@Mocked final VendorDAO dao) {
    final int uv = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.updatingvendor(10, "VARUN");
        result = uv;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
       VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int uv1 = VendorFactory.updateVendor(10, "VARUN");
    assertEquals(uv, uv1);
  }
   /**
   * tests that updating Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void loginVendor(@Mocked final VendorDAO dao) {
    final Vendor sv = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.loggingVendor("RAM", "ram123");
        result = sv;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
        VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor sv1 = VendorFactory.loginVendor("RAM", "ram123");
    assertEquals(sv, sv1);
  }
   /**
   * tests that adding Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void signupVendor(@Mocked final VendorDAO dao) {
    final int sv = 1;
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.signingvendor(20, "ram123", "abc@5899");
        result = sv;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
       VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int sv1 = VendorFactory.signupVendor(20, "ram123", "abc@5899");
    assertEquals(sv, sv1);
  }
    /**
   * tests that ven bal Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void venBal(@Mocked final VendorDAO dao) {
    final Vendor vb = new Vendor(1, 11, "ASRI", 3500.0f, "DADDY");
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.getVenbalance(12);
        result = vb;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
       VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor vb1 = VendorFactory.getVenbalance(12);
    assertEquals(vb, vb1);
  }
    /**
   * tests that ven amt Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void upAmt(@Mocked final VendorDAO dao) {
    final int vb = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.updateamt(12, 4000.f);
        result = vb;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
       VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ua1 = VendorFactory.updateAmt(12, 4000.0f);
    assertEquals(vb, ua1);
  }
   /**
   * tests that updating Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void insertven(@Mocked final VendorDAO dao) {
    final Vendor sv = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.insertven(0, 10, "RAM", 4000.0f, "ram123");
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
        VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int sv1 = VendorFactory.insertVen(sv);
    assertEquals(1, sv1);
  }
  /**
   * tests that updating Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void updateven(@Mocked final VendorDAO dao) {
    final Vendor sv = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.updatevenPrice(4000.0f, 10);
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
        VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int sv1 = VendorFactory.updateVenPrice(sv);
    assertEquals(1, sv1);
  }
  /**
   * tests that updating Vendor is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void showvendor(@Mocked final VendorDAO dao) {
    final Vendor sv = new Vendor(0, 10, "RAM", 4000.0f, "ram123");
    new Expectations() {
      {
        System.out.println("mocked get Vendor login");
        dao.showVen("kags");
        result = sv;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
        VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor sv1 = VendorFactory.showVendor("kags");
    assertEquals(sv, sv1);
  }
}
