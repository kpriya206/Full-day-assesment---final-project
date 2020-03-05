package com.hexaware.MLP196.persistence;

import java.util.List;

import com.hexaware.MLP196.model.Vendor;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * VendorDAO class used to fetch data from data base.
 * @author Asritha-hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
 /**
 *@param cusId setvalue
 *@param venId setvalue
 *@param venName setvalue
 *@param venBal setvalue
 *@param venPassword setvalue
* @return the all the Menu record.
 */
  @SqlUpdate("Insert into vendor (CUS_ID, VEN_ID, VEN_NAME, VEN_BAL, VEN_PASSWORD)" + " values(:cusId,:venId,:venName,:venBal,:venPassword)")
   int addingvendor(@Bind("cusId")int cusId, @Bind("venId")int venId, @Bind("venName")String venName,
                     @Bind("venBal")float venBal, @Bind("venPassword") String venPassword);

/**
 *@param venName deletevendorname
  * @return the all the Menu record.
 */
  @SqlUpdate("Delete from vendor where VEN_NAME=:venName")
  int deletingvendor(@Bind("venName")String venName);
/**
 *@param venId update venid
 *@param venName update venname
  * @return the all the Menu record.
 */
  @SqlUpdate("Update vendor set VEN_NAME =:venName where VEN_ID=:venId")
    int updatingvendor(@Bind("venId")int venId, @Bind("venName")String venName);
    /**
 *@param venPassword vendor password
 *@param venName vendor name
  * @return the all the Menu record.
 */
  @SqlQuery("select * from vendor where VEN_NAME=:venName and VEN_PASSWORD=:venPassword")
  @Mapper(VendorMapper.class)
  Vendor loggingVendor(@Bind("venName")String venName, @Bind("venPassword")String venPassword);
/**
 *@param venId setvalue
 *@param venName setvalue
 *@param venPassword setvalue
  * @return the all the Menu record.
 */
  @SqlUpdate("Insert into vendor (VEN_ID, VEN_NAME, VEN_PASSWORD)" + " values(:venId,:venName,:venPassword)")
    int signingvendor(@Bind("venId")int venId, @Bind("venName")String venName, @Bind("venPassword") String venPassword);
/**
 *@param venName vendorname
  * @return the all the Menu record.
 */
  @SqlQuery("select * from vendor where VEN_NAME = :venName")
  @Mapper(VendorMapper.class)
  Vendor disvenbal(@Bind("venName") String venName);
/**
 *@param venBal update venbal
 *@param venName update venname
  * @return the all the Menu record.
 */
  @SqlUpdate("Update VENDOR set VEN_BAL =:venBal where VEN_NAME =:venName")
  int updatevenbal(@Bind("venName")String venName, @Bind("venBal")float venBal);

 /**
     * @return the all the Menu record.
     * @param venId setvalue
     */
  @SqlQuery("select * from vendor where VEN_ID = :venId")
  @Mapper(VendorMapper.class)
  Vendor getVenbalance(@Bind("venId") int venId);
 /**
 *@param venId update venid
 *@param venBal update venbal
  * @return the all the Menu record.
 */
  @SqlUpdate("Update VENDOR set VEN_BAL =:venBal where VEN_ID =:venId")
  int updateamt(@Bind("venId") int venId, @Bind("venBal")float venBal);
  /**
 *@param venId setvalue
 *@param venName setvalue
 *@param venPassword setvalue
 *@param venBal setvalue
 *@param cusId setvalue
  * @return the all the Menu record.
 */
  @SqlUpdate("Insert into vendor (CUS_ID,VEN_ID, VEN_NAME, VEN_BAL, VEN_PASSWORD)" + " values(:cusId,:venId,:venName,:venBal,:venPassword)")
int insertven(@Bind("cusId")int cusId, @Bind("venId")int venId, @Bind("venName") String venName,
      @Bind("venBal")float venBal, @Bind("venPassword") String venPassword);
  /**
 *@param venBal update venbal
 *@param venId update venid
  * @return the all the Menu record.
 */
  @SqlUpdate("Update VENDOR set VEN_BAL =:venBal where VEN_ID =:venId")
int updatevenPrice(@Bind("venBal")float venBal, @Bind("venId")int venId);
/**
   * @return the all the Menu record.
   * @param venName setvalue
   */
  @SqlQuery("select * from vendor where VEN_NAME = :venName")
  @Mapper(VendorMapper.class)
Vendor showVen(@Bind("venName") String venName);
}
