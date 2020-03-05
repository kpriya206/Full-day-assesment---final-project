package com.hexaware.MLP196.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP196.model.Offers;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OffersMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OffersMapper implements ResultSetMapper<Offers> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Offers map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Offers
       */
    return new Offers(rs.getString("coupon_code"),  rs.getInt("cus_Id"), rs.getString("off_Item"), rs.getInt("ven_Id"),
    rs.getInt("ord_Id"), rs.getDate("date_Of_CouponCode"));
  }
}
