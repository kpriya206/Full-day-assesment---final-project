package com.hexaware.MLP196.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP196.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrdersMapper class used to fetch menu data from database.
 * @author sowmya-hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped orders object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return orders
       */
    return new Orders(rs.getInt("ord_Id"), rs.getInt("cus_Id"), rs.getString("food_Id"), rs.getInt("ord_Qty"), rs.getInt("ord_TotalCost"),
     rs.getDate("ord_Date"), rs.getString("ord_Status"), rs.getInt("ven_Id"), rs.getString("coupon_Code"), rs.getInt("token_No"));

  }
}
