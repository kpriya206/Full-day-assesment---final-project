package com.hexaware.MLP196.util;

import javax.ws.rs.Consumes;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
// import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP196.model.Customer;
import com.hexaware.MLP196.factory.CustomerFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listCustomer() {
    final Customer[] cus = CustomerFactory.showCustomer();
    return cus;
  }
  /**
   * Returns Customer details.
   * @return the customer details
   * @param newCus new customer .
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addcustomer")
  public final String addCus(final Customer newCus)  {
    String comment = " ";
    final int cusIns = CustomerFactory.insertCus(newCus);
    if (cusIns > 0) {
      comment = "{\" value \" : \" Customer data added successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer data not added  \"}";
    }
    return comment;
  }
  /**
   * Returns Customer details.
   * @return the customer details
   * @param newCus new customer .
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatecustomer")
    public final String updateCus(final Customer newCus) {
    String comment = "";
        //final int carIns = CarFactory.insertCar(newCar);
    final int cusUpdate = CustomerFactory.updateCusPrice(newCus);
    if (cusUpdate > 0) {
      comment = "{\" value \" : \" Customer updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not updated  \"}";
    }
    return comment;
  }
    /**
   * Returns Customer details.
   * @param cusName customer name.
   * @return the customer details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showCustomer/{name}")
    public final Customer showCustomer(@PathParam("name") final String cusName) {
    final Customer cus = CustomerFactory.showCustomer(cusName);
    return cus;
  }
 /**
   * Returns Customer details.
   * @param cname customer name.
   * @param cpwd customer password
   * @return the customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/check/{cname}/{cpwd}")
  public final Customer login(@PathParam("cname")final String cname, @PathParam("cpwd")final String cpwd) {

    final Customer i = CustomerFactory.loginCustomer(cname, cpwd);
    return i;
  }
}
