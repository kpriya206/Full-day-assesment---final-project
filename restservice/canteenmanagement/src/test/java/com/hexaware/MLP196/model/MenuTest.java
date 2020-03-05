package com.hexaware.MLP196.model;

import com.hexaware.MLP196.persistence.MenuDAO;
import com.hexaware.MLP196.factory.MenuFactory;


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
public class MenuTest {
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  private static final double DELTA = 1e-15;
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  private Menu m;
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    m = new Menu();
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    Menu m100 = new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH");
    Menu m101 = new Menu("F02", "ROSEMILK", 60.00f, "JUICES");
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    assertEquals(m100.getFoodId(),
        new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH").getFoodId());
    assertEquals(m100.getFoodName(),
        new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH").getFoodName());
    assertEquals(m100.getFoodPrice(),
        new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH").getFoodPrice());
    assertEquals(m100.getFoodCat(),
        new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH").getFoodCat());
    m101.setFoodId("F02");
    m101.setFoodName("ROSEMILK");
    m101.setFoodPrice(60.00f);
    m101.setFoodCat("JUICE");
    assertNotEquals(m101, new Menu("F03", "BADAMMILK", 50.00f, "SHAKES"));
    assertEquals(m100.hashCode(),
        new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH").hashCode());
    assertEquals(m100, new Menu("F01", "SAMBAR", 50.00f, "SIDEDISH"));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu("FID07", "VEG BIRIYANI", 90.00f, "MAINDISH");
    final Menu m101 = new Menu("FID10", "SOUP", 50.00f, "INITIATOR");
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu("FID07", "VEG BIRIYANI", 90.00f, "MAINDISH").getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu("FID10", "SOUP", 50.00f, "INITIATOR").getFoodId(),
        mn1[1].getFoodId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuDefaultConstructor() {
    Menu newMenu = new Menu();
    assertEquals(newMenu.hashCode(), new Menu().hashCode());
    newMenu.setFoodId("FID06");
    assertNotEquals(newMenu.getFoodId(), new Menu().getFoodId());
  }
/**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuParameterisedConstructor() {
    Menu newMenu = new Menu("FID06", "rasam", 50.0f, "MAIN_DISH");
    // testing customer variables are initialized through getters which in turn to know where its returning a correct values.
    assertEquals("FID06", newMenu.getFoodId());
    assertEquals("rasam", newMenu.getFoodName());
    assertEquals(50.0f, newMenu.getFoodPrice(), DELTA);
    assertEquals("MAIN_DISH", newMenu.getFoodCat());
  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuSetId() {
    Menu newMenu1 = new Menu("FID06", "rasam", 50.0f, "MAIN_DISH");
    newMenu1.setFoodId("FID06");
    assertEquals("FID06", newMenu1.getFoodId());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuSetName() {
    Menu newMenu1 = new Menu("FID06", "rasam", 50.0f, "MAIN_DISH");
    newMenu1.setFoodName("rasam");
    assertEquals("rasam", newMenu1.getFoodName());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuSetPrice() {
    Menu newMenu1 = new Menu("FID06", "rasam", 50.0f, "MAIN_DISH");
    newMenu1.setFoodPrice(50.0f);
    assertEquals(50.0f, newMenu1.getFoodPrice(), DELTA);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testMenuSetCat() {
    Menu newMenu1 = new Menu("FID06", "rasam", 50.0f, "MAIN_DISH");
    newMenu1.setFoodCat("MAIN_DISH");
    assertEquals("MAIN_DISH", newMenu1.getFoodCat());
  }
}
