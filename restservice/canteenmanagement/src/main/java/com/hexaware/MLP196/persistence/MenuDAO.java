package com.hexaware.MLP196.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP196.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author karpaga-hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
/**
  * @param mfoodId food id
  * @param foodName food name
  * @param foodPrice food price
  * @param foodCat food category
  * @return the all the Menu record.
  */
  @SqlUpdate("Insert into Menu (FOOD_ID, FOOD_NAME, FOOD_PRICE, FOOD_CAT)" + " values(:mfoodId,:foodName,:foodPrice,:foodCat)")
    int addingmenu(@Bind("mfoodId")String mfoodId, @Bind("foodName")String foodName, @Bind("foodPrice")float foodPrice,
      @Bind("foodCat")String foodCat);

    /**
  * @param foodName food name.
  * @return the all the Menu record.
  */
  @SqlUpdate("delete from Menu where FOOD_NAME = :foodName")
    int deletingmenu(@Bind("foodName")String foodName);
/**
  * @param foodPrice food price
  * @param foodName food name
  * @return the all the Menu record.
  */
  @SqlUpdate("Update Menu set FOOD_PRICE =:foodPrice where FOOD_NAME=:foodName")
     int updatingmenu(@Bind("foodPrice") Float foodPrice, @Bind("foodName") String foodName);
/**
* @param foodId food id
* @return the all the Menu record.
*/
  @SqlQuery("Select * from Menu where FOOD_ID =:foodId")
  @Mapper(MenuMapper.class)
    Menu choosingmenu(@Bind("foodId") String foodId);
    /**
  * @param foodId food id
  * @param foodName food name
  * @param foodPrice food price.
  * @param foodCat food category.
  * @return the all the Menu record.
  */
  @SqlUpdate("Insert into Menu (FOOD_ID,FOOD_NAME,FOOD_PRICE,FOOD_CAT) values (:foodId,:foodName,:foodPrice,:foodCat)")
  int insertMenu(@Bind("foodId") String foodId, @Bind("foodName") String foodName, @Bind("foodPrice") float foodPrice,
      @Bind("foodCat") String foodCat);
   /**
  * @param foodId food id
  * @param foodPrice food price.
  * @return the all the Menu record.
  */
  @SqlUpdate("Update Menu SET FOOD_PRICE = :foodPrice where FOOD_ID = :foodId")
  int updatemenuPrice(@Bind("foodPrice") float foodPrice, @Bind("foodId") String foodId);
  /**
  * @param foodId customer id
  * @return the all the Menu record.
  */
  @SqlQuery("Select * from Menu where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
Menu showMenu(@Bind("foodId") String foodId);
}
