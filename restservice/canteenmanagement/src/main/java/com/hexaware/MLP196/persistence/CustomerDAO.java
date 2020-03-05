package com.hexaware.MLP196.persistence;

import java.util.List;

import com.hexaware.MLP196.model.Customer;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * CustomerDAO class used to fetch data from data base.
 * @author karpagapriya-hexware
 */
public interface CustomerDAO {
 /**
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from Customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();

/**
  * @param cusId customer id
  * @param cusName customer name
  * @param cusPassword customer password
  * @param cusWallet customer wallet details
  * @param cusEmail customer email
  * @return the all the Customer record.
  */
  @SqlUpdate("Insert into Customer (CUS_ID, CUS_NAME, CUS_PASSWORD, CUS_WALLET, CUS_EMAIL)"
      + "values(:cusId, :cusName, :cusPassword, :cusWallet, :cusEmail)")
    int signingupcustomer(@Bind("cusId")int cusId, @Bind("cusName")String cusName, @Bind("cusPassword")String cusPassword,
      @Bind("cusWallet")Float cusWallet, @Bind("cusEmail")String cusEmail);

    /**
  * @param cusName customer name
  * @return the all the Customer record.
  */
  @SqlUpdate("delete from Customer where CUS_NAME =:cusName")
    int removingCustomer(@Bind("cusName") String cusName);
/**
  * @param cusId customer id
  * @param cusName customer name
  * @return the all the Customer record.
  */
  @SqlUpdate("Update Customer set CUS_NAME = :cusName where CUS_ID = :cusId")
     int editCustomer(@Bind("cusId") int cusId, @Bind("cusName") String cusName);
/**
  * @param cusName customer name
  * @param cusPassword customer password
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from Customer where CUS_NAME = :cusName and CUS_PASSWORD = :cusPassword")
    @Mapper(CustomerMapper.class)
    Customer checkCustomer(@Bind("cusName") String cusName, @Bind("cusPassword") String cusPassword);

/**
  * @param cusId customer id.
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from CUSTOMER where CUS_ID = :cusId")
  @Mapper(CustomerMapper.class)
  Customer cusbal(@Bind("cusId") int cusId);

 /**
  * @param cusId customer id
  * @param cusName customer name
  * @param cusPassword customer password
  * @param cusEmail customer email
  * @return the all the Customer record.
  */
  @SqlUpdate("Insert into CUSTOMER (CUS_ID, CUS_NAME, CUS_PASSWORD, CUS_EMAIL)" + " values(:cusId,:cusName,:cusPassword, :cusEmail)")
    int signingupcustomer(@Bind("cusId")int cusId, @Bind("cusName")String cusName, @Bind("cusPassword")String cusPassword,
      @Bind("cusEmail")String cusEmail);
  /**
  * @param cusId customer id
  * @param cusEmail customer email
  * @return the all the Customer record.
  */
  @SqlUpdate("Update CUSTOMER set CUS_EMAIL =:cusEmail where CUS_ID = :cusId")
    int editcus(@Bind("cusId") int cusId, @Bind("cusEmail") String cusEmail);
     /**
  * @param cusId customer id
  * @param cusWallet customer email
  * @return the all the Customer record.
  */
  @SqlUpdate("Update CUSTOMER set CUS_WALLET =:cusWallet where CUS_ID = :cusId")
    int updatecusbal(@Bind("cusId") int cusId, @Bind("cusWallet") float cusWallet);
    /**
  * @param cusId customer id
  * @param cusWallet customer email
  * @param cusName customer name.
  * @param cusPassword customer password.
  * @param cusEmail customer email id.
  * @return the all the Customer record.
  */
  @SqlUpdate("Insert into Customer (CUS_ID,CUS_NAME,CUS_PASSWORD,CUS_WALLET,CUS_EMAIL) values (:cusId,:cusName,:cusPassword,:cusWallet,:cusEmail)")
  int insertCus(@Bind("cusId") int cusId, @Bind("cusName") String cusName, @Bind("cusPassword") String cusPassword,
      @Bind("cusWallet") float cusWallet, @Bind("cusEmail") String cusEmail);
   /**
  * @param cusId customer id
  * @param cusWallet customer wallet.
  * @return the all the Customer record.
  */
  @SqlUpdate("Update Customer SET CUS_WALLET = :cusWallet where CUS_ID = :cusId")
  int updateCusPrice(@Bind("cusWallet") float cusWallet, @Bind("cusId") int cusId);
  /**
  * @param cusName customer name
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from Customer where CUS_Name = :cusName")
  @Mapper(CustomerMapper.class)
Customer showCus(@Bind("cusName") String cusName);

}

