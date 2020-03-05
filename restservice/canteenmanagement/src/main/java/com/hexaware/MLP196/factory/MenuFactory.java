package com.hexaware.MLP196.factory;

import com.hexaware.MLP196.persistence.MenuDAO;
import com.hexaware.MLP196.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP196.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
  /**
   * Call the data base connection.
 * @param mfoodId menu food id
 * @param foodName food name
 * @param foodPrice food price
 * @param foodCat food category
   * @return the array of customer object.
   */
  public static int addmenu(final String mfoodId, final String foodName, final float foodPrice, final String foodCat) {
    int a =  dao().addingmenu(mfoodId, foodName, foodPrice, foodCat);
    return a;
  }
  // /**
  //    * Call the data base connection.
  //    * @return the array of customer object.
  //    *  @param foodName food name
  //    */
  // public static int deletemenu(final String foodName) {
  //   int b = dao().deletingmenu(foodName);
  //   return b;
  // }
/**
  * Call the data base connection.
  * @return the array of customer object.
  * @param foodPrice food price
  * @param foodName food name
  */
  public static int updatemenu(final Float foodPrice, final String foodName) {
    int c = dao().updatingmenu(foodPrice, foodName);
    return c;
  }
      /**
  * Call the data base connection.
  * @return the array of customer object.
  * @param foodId food price
  */
  public static Menu choosemenu(final String foodId) {
    Menu c = dao().choosingmenu(foodId);
    return c;
  }
/**
  * Call the data base connection.
  * @param newMenu new Menu.
  * @return the array of customer object.
  */
  public static int insertMenu(final Menu newMenu) {
    final int insertResult = dao().insertMenu(newMenu.getFoodId(), newMenu.getFoodName(), newMenu.getFoodPrice(), newMenu.getFoodCat());
    return insertResult;
  }
/**
  * Call the data base connection.
  * @param newMenu new menu.
  * @return the array of menu object.
  */
  public static int updateMenuPrice(final Menu newMenu) {
    //final java.sql.Date scpdate = new java.sql.Date(date.getTime());
    int i = dao().updatemenuPrice(newMenu.getFoodPrice(), newMenu.getFoodId());
    return i;
  }
   /**
  * Call the data base connection.
  * @param foodId food id.
  * @return the array of menu object.
  */
  public static Menu showMenu(final String foodId) {
    MenuDAO mDao = dao();
    Menu menu = mDao.showMenu(foodId);
    return menu;
  }
}
