package com.hexaware.MLP196.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP196.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CustomerMapper class used to fetch customer data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    return new Customer(rs.getInt("Cus_Id"), rs.getString("Cus_Name"), rs.getString("Cus_Password"), rs.getFloat("Cus_Wallet"),
     rs.getString("Cus_Email"));
  }
}
