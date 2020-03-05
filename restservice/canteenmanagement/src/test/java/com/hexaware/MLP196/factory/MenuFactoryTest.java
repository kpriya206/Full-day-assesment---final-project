package com.hexaware.MLP196.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

//import com.hexaware.MLP196.factory.MenuFactory;
import com.hexaware.MLP196.model.Menu;
import com.hexaware.MLP196.persistence.MenuDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Vendor
/**
   * tests that adding menu is handled correctly.
   */
public class MenuFactoryTest {
/**
  * default constructor testing.
 */
  @Test
public final void testdefaultConstructor() {
    MenuFactory mf = new MenuFactory();
    MenuFactory mf1 = new MenuFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
  /**
   * tests that adding menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
    public final void testGetAllMenu(@Mocked final MenuDAO dao) {
    final Menu mn = new Menu("FID01", "BIRIYANI", 100, "MAIN-DISH");
    final ArrayList<Menu> menuList = new ArrayList<Menu>();
    new Expectations() {
      {
        menuList.add(mn);
        dao.show();
        result = menuList;
      }
    };

    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
          return dao;
      }
    };

    Menu[] menuList1 = MenuFactory.showMenu();
    assertEquals(mn, menuList1[0]);

  }
   /**
   * tests that adding menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void addMenu(@Mocked final MenuDAO dao) {
    final int am = 1;
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.addingmenu("FID01", "CHICKEN BIRIYANI", 100.00f, "MAIN-DISH");
        result = am;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
        MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    int am1 = MenuFactory.addmenu("FID01", "CHICKEN BIRIYANI", 100.00f, "MAIN-DISH");
    assertEquals(am, am1);
  }
 /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void upMenu(@Mocked final MenuDAO dao) {
    final int up = 1;
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.updatingmenu(400.00f, "PANI POORI");
        result = up;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    int up1 = MenuFactory.updatemenu(400.00f, "PANI POORI");
    assertEquals(up, up1);
  }
  /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void chooseMenu(@Mocked final MenuDAO dao) {
    final Menu ch = new Menu("FID01", "BIRIYANI", 100, "MAIN-DISH");
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.choosingmenu("FID001");
        result = ch;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    Menu ch1 = MenuFactory.choosemenu("FID001");
    assertEquals(ch, ch1);
  }
/**
   * tests that adding menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void insertMenu(@Mocked final MenuDAO dao) {
    final Menu ch = new Menu("FID01", "BIRIYANI", 100.00f, "MAIN-DISH");
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.insertMenu("FID01", "BIRIYANI", 100.00f, "MAIN-DISH");
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
        MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    int am1 = MenuFactory.insertMenu(ch);
    assertEquals(1, am1);
  }
  /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updatemenuprice(@Mocked final MenuDAO dao) {
    final Menu m = new Menu("FID01", "BIRIYANI", 100.00f, "MAIN-DISH");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.updatemenuPrice(100.0f, "FID01");
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    int ca = MenuFactory.updateMenuPrice(m);
    assertEquals(1, ca);
  }
 /**
   * tests that menu login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showMenu(@Mocked final MenuDAO dao) {
    final Menu c = new Menu("FID01", "BIRIYANI", 100.00f, "MAIN-DISH");
    new Expectations() {
      {
        System.out.println("mocked get Customer login");
        dao.showMenu("FID01");
        result = c;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Student Dao");
        return dao;
      }
    };
    Menu ca = MenuFactory.showMenu("FID01");
    assertEquals(c, ca);
  }
}
