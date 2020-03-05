package com.hexaware.MLP196.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP196.model.Vendor;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * VendorMapper class used to fetch vendor data from database.
 * @author  asritha-hexware
 */
public class VendorMapper implements ResultSetMapper<Vendor> {

     /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */

  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {

              /**
       * @return Vendor
       */
    return new Vendor(rs.getInt("cus_Id"), rs.getInt("ven_Id"), rs.getString("ven_Name"), rs.getFloat("ven_Bal"), rs.getString("ven_Password"));
  }
}
