package com.hexaware.MLP196.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;
import com.hexaware.MLP196.model.Offers;
/**
 * OffersDAO class used to fetch data from data base.
 * @author vamsi-hexware
 */
public interface OffersDAO {
    /**
     * @return the all the Offers record.
     */
  @SqlQuery("Select * from Offers")
    @Mapper(OffersMapper.class)
    List<Offers> show();
    /**
  * @param couponCode coupon code
  * @param offItem off item
  * @param cusId customer id
  * @param ovenId ven id
  * @param ordId order id
  * @param dt date of coupon code
  * @return the all the Offers record.
  */

  @SqlUpdate("Insert into Offers(COUPON_CODE, OFF_ITEM, CUS_ID, VEN_ID, ORD_ID,Date_Of_CouponCode)"
        + " values(:couponCode,:offItem,:cusId,:venId,:ordId,:dateOfCouponCode)")
     int addingoffers(@Bind("couponCode")String couponCode, @Bind("offItem")String offItem, @Bind("cusId")int cusId,
        @Bind("venId")int ovenId, @Bind("ordId")int ordId, @Bind("dateOfCouponCode") Date dt);
//  /**
//   * @param offItem offers id
//    * @return the all the Offers record.
//   */
//   @SqlUpdate("delete from Offers where OFF_ITEM = :offItem")
//     int deletingOffers(@Bind("offItem")String offItem);
/**
  * @param offItem offers item
  * @param couponCode couponCode
  * @return the all the Offers record.
  */
  @SqlUpdate("Update Offers set OFF_ITEM =:offItem where COUPON_CODE = :couponCode")
    int updatingOffers(@Bind("couponCode") String couponCode, @Bind("offItem") String offItem);
    /**
  * @param couponCode coupon Code
    * @param d1 order id
   * @param dateOfCouponCode dateOfCouponCode
   * @return the all the Offers record.
  */
  @SqlUpdate("Update Offers set Coupon_Code = :couponCode,Date_Of_CouponCode = :dateOfCouponCode where ORD_ID = :ordId")
 int updating(@Bind("d1") Date d1, @Bind("couponCode") String couponCode, @Bind("dateOfCouponCode") int dateOfCouponCode);

/**
  * @param couponCode coupon Code
   * @param cusId customer id.
   * @return the all the Offers record.
  */
  @SqlUpdate("Update Offers set Coupon_Code = :couponCode where CUS_ID = :cusId")
  int  updatecoupon(@Bind("couponCode") String couponCode, @Bind("cusId") int cusId);
  /**
  * @param couponCode coupon code
  * @param offItem off item
  * @param cusId customer id
  * @param ovenId ven id
  * @param ordId order id
  * @param dt date of coupon code
  * @return the all the Offers record.
  */

  @SqlUpdate("Insert into Offers(COUPON_CODE, OFF_ITEM, CUS_ID, VEN_ID, ORD_ID,DATE_OF_COUPONCODE)"
        + " values(:couponCode,:offItem,:cusId,:venId,:ordId,:dateOfCouponCode)")
     int insertoff(@Bind("couponCode")String couponCode, @Bind("cusId")int cusId, @Bind("offItem")String offItem,
        @Bind("venId")int ovenId, @Bind("ordId")int ordId, @Bind("dateOfCouponCode") Date dt);
  /**
  * @param offItem offers item
  * @param ordId order id.
  * @return the all the Offers record.
  */
  @SqlUpdate("Update Offers set OFF_ITEM =:offItem where ORD_ID = :ordId")
  int updateoffitem(@Bind("offItem") String offItem, @Bind("ordId") int ordId);
  /**
  * @param ordId order id
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from Offers where ORD_ID = :ordId")
  @Mapper(OffersMapper.class)
Offers showOff(@Bind("ordId") int ordId);
/**
  * @param couponCode coupon Code
   * @param date customer id.
   * @param cusId date.
   * @return the all the Offers record.
  */
  @SqlUpdate("Insert into Offers(COUPON_CODE, CUS_ID, DATE_OF_COUPONCODE)" + " values(:couponCode, :cusId, :dateOfCouponCode)")
     int updatecoup(@Bind("couponCode")String couponCode, @Bind("dateOfCouponCode") Date date,  @Bind("cusId") int cusId);
 /**
  * @param cusId order id
  * @return the all the Offers record.
  */
  @SqlQuery("Select * from Offers where CUS_ID = :cusId")
  @Mapper(OffersMapper.class)
int checkcouponcus(@Bind("cusId") int cusId);

/**
  * @param cusId customer id
   * @return the all the Offers record.
  */
  @SqlUpdate("delete from Offers where CUS_ID = :cusId")
    int delCoupcode(@Bind("cusId")int cusId);

    /**
  * @param cusId order id
  * @return the all the Offers record.
  */
  @SqlQuery("Select * from Offers where CUS_ID = :cusId")
  @Mapper(OffersMapper.class)
Offers endCoupdate(@Bind("cusId") int cusId);


}
