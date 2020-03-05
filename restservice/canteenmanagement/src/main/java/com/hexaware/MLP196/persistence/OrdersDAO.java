package com.hexaware.MLP196.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.sql.Date;
import java.util.List;
import com.hexaware.MLP196.model.Orders;
/**
 * CustomerDAO class used to fetch data from data base.
 * @author Sowmya-hexware
 */
public interface OrdersDAO {
    /**
     * @return the all the orders record.
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> show();

   /**
    *@param  ordId order id
     *@param  cusId customer id
    *@param foodId food id
    *@param ordQty ord qty
    *@param ordTotalCost oredr total cost
    *@param ordStatus order status
    *@param d1 order date
    *@param couponCode coupon Code
    *@param venId vendor id
    *@param f token number
    * @return the all the orders record.
    */
  @SqlUpdate("Insert into Orders (ORD_ID,CUS_ID, FOOD_ID, ORD_QTY, ORD_TOTALCOST, ORD_DATE, OFF_ID, ORD_STATUS, VEN_ID)"
          + " values(:ordId,:cusId,:foodId,:ordQty,:ordTotalCost,:d,:offId, :ordStatus)")
    int addingorders(@Bind("ordId")int ordId, @Bind("cusId")int cusId, @Bind("foodId") String foodId, @Bind("ordQty")int ordQty,
        @Bind("ordTotalCost") float ordTotalCost, @Bind("d") java.util.Date d1,
        @Bind("ordStatus") String ordStatus, @Bind("venId") int venId, @Bind("couponCode") String couponCode, @Bind("tokenNo") float f);

  /**
    * @return the all the orders record.
    * @param ordqty orders quantity
    */
  @SqlUpdate("delete from Orders where ORD_QTY = :ordqty")
      int deletingOrders(@Bind("ordqty")int ordqty);

  /**
    * @param ordId orders id
    * @param ordTotalCost order Total Cost
    * @return the all the orders record.
    */
  @SqlUpdate("Update orders set ORD_TOTALCOST =:ordTotalCost where ORD_ID =:ordId")
      int updatingorders(@Bind("ordId") int ordId, @Bind("ordTotalCost") float ordTotalCost);

      /**
     * @return the order status based on id in the orders record.
     * @param ordId orders id
     */
  @SqlQuery("Select * from orders where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
    Orders disordstatus(@Bind("ordId") int ordId);

    /**
     * @return the order status from orders record.
     * @param ordId orders id
     * @param ordStatus order status
     */
  @SqlUpdate("Update ORDERS set ORD_STATUS = :ordStatus where ORD_ID = :ordId")
    int changestatus(@Bind("ordId") int ordId, @Bind("ordStatus") String ordStatus);
      /**
     * @return the order sttaus based on id in the orders record.
     * @param  cusId customer id
     */
  @SqlQuery("Select * from orders where CUS_ID = :cusId")
  @Mapper(OrdersMapper.class)
    Orders cusordhis(@Bind("cusId") int cusId);

/**
     * @return the order cost from orders record.
     * @param  cusId customer id
     * @param  foodId food id
     * @param ordTotalCost oredr total cost
     * @param ordStatus order status
     * @param d order date
     * @param ordQty orders quantity
     * @param tokenNo token number
     */
  @SqlUpdate("Insert into Orders (CUS_ID, FOOD_ID, ORD_QTY, ORD_TOTALCOST, ORD_DATE, ORD_STATUS,TOKEN_NO)"
      + " values(:cusId, :foodId, :ordQty, :ordTotalCost, :d, :ordStatus, :tokenNo)")
    int insertorders(@Bind("cusId") int cusId, @Bind("ordTotalCost") int ordTotalCost, @Bind("ordQty") int ordQty, @Bind("d") Date d,
        @Bind("ordStatus") String ordStatus,  @Bind("foodId") String foodId, @Bind("tokenNo") int tokenNo);
    /**
     * @return the order total cost based on id in the orders record.
     * @param  ordId order id
     */
  @SqlQuery("Select * from orders where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
    Orders getordcost(@Bind("ordId") int ordId);

    /**
     * @return the order cost from orders record.
     * @param  ordId order id
     * @param  ordStatus order status
     */
  @SqlUpdate("Update ORDERS set ORD_STATUS = :ordStatus where ORD_ID = :ordId")
    int updateorderstatus(@Bind("ordId") int ordId, @Bind("ordStatus") String ordStatus);

 /**
  * @return the coupon code from orders record.
  * @param  ordId order id
  * @param  couponCode couponv Code
  */
  @SqlUpdate("Update ORDERS set Coupon_Code = :couponCode where ORD_ID = :ordId")
    int updateCouponCode(@Bind("ordId") int ordId, @Bind("couponCode") String couponCode);
    /**
    *@param  ordId order id
     *@param  cusId customer id
    *@param foodId food id
    *@param ordQty ord qty
    *@param ordTotalCost oredr total cost
    *@param ordStatus order status
    *@param date order date
    *@param couponCode coupon Code
    *@param venId vendor id
    *@param tokenNo token number
    * @return the all the orders record.
    */
  @SqlUpdate("Insert into Orders (ORD_ID,CUS_ID, FOOD_ID, ORD_QTY, ORD_TOTALCOST, ORD_DATE, ORD_STATUS, VEN_ID, COUPON_CODE, TOKEN_NO)"
      + " values(:ordId,:cusId,:foodId,:ordQty,:ordTotalCost,:d, :ordStatus, :venId, :couponCode, :tokenNo)")
int insertord(@Bind("ordId")int ordId, @Bind("cusId")int cusId, @Bind("foodId") String foodId, @Bind("ordQty")int ordQty,
      @Bind("ordTotalCost") float ordTotalCost, @Bind("d") java.util.Date date,
      @Bind("ordStatus") String ordStatus, @Bind("venId") int venId, @Bind("couponCode") String couponCode, @Bind("tokenNo") int tokenNo);

/**
 * @return the order status from orders record.
 * @param cusId customer id
 * @param ordStatus order status
 */
  @SqlUpdate("Update ORDERS set ORD_STATUS = :ordStatus where CUS_ID = :cusId")
int updateordStatus(@Bind("cusId") int cusId, @Bind("ordStatus") String ordStatus);
 /**
 * @return the order total cost based on id in the orders record.
 * @param  ordId order id
 */
  @SqlQuery("Select * from ORDERS where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
Orders showOrd(@Bind("ordId") int ordId);

 /**
 * @return the order total cost based on id in the orders record.
 * @param  cusId order id
 */
  @SqlQuery("Select * from ORDERS where CUS_ID = :cusId")
  @Mapper(OrdersMapper.class)
Orders checkcoup(@Bind("cusId") int cusId);
 /**
 * @return the order total cost based on id in the orders record.
 * @param  cusId order id
 */
  @SqlQuery("Select * from ORDERS where CUS_ID = :cusId")
  @Mapper(OrdersMapper.class)
Orders checkdate(@Bind("cusId") int cusId);
/**
  * @return the coupon code from orders record.
  * @param  cusId customer id
  * @param  couponCode couponv Code
  */
  @SqlUpdate("Update ORDERS set Coupon_Code = :couponCode where CUS_ID = :cusId")
    int upCoupcode(@Bind("cusId") int cusId, @Bind("couponCode") String couponCode);
    /**
  * @param cusId customer name
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from orders where CUS_ID = :cusId")
  @Mapper(OrdersMapper.class)
Orders ordhis(@Bind("cusId") int cusId);
}
