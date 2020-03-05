package com.hexaware.MLP196.util;

import java.text.ParseException;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP196.model.Orders;
import com.hexaware.MLP196.factory.OrdersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orders")
public class OrdersRest {
  /**
   * Returns orders details.
   * @return the orders details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] listOrders() {
    final Orders[] orders = OrdersFactory.showOrders();
    return orders;
  }
  /**
 * @param newOrders to post Orders .
 * @throws ParseException for ParseException.
 * @return to post to databse.
 * @throws ParseException
 */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/insertorders")
public final String insertOrders(final Orders newOrders) throws ParseException {
    String comment = "";
    final int carIns = OrdersFactory.insertOrders(newOrders);
    if (carIns > 0) {
      comment = "{\" value \" : \"  Orders  added successfully \"}";
    } else {
      comment = "{\" value \" : \"  Orders  not added  \"}";
    }
    return comment;
  }
/**
* @param cusId to modify  Orders  .
* @param ordStatus to modify  Orders  .
* @return to return values.
*/
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateorders/{id}/{status}")
public final String updateOrderStatus(@PathParam("id") final int cusId, @PathParam("status") final String ordStatus) {
    String comment = "";
    final int ordersUpdate = OrdersFactory.updateOrdStatus(cusId, ordStatus);
    if (ordersUpdate > 0) {
      comment = "{\" value \" : \"  Orders  updated successfully \"}";
    } else {
      comment = "{\" value \" : \"  Orders not updated  \"}";
    }
    return comment;
  }
 /**
   * Returns Customer details.
   * @param ordId customer id.
   * @return the customer details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showorders/{id}")
    public final Orders showOrders(@PathParam("id") final int ordId) {
    final Orders ord = OrdersFactory.showOrders(ordId);
    return ord;
  }
  /**
   * Returns Customer details.
   * @param cusId customer id.
   * @return the customer details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/orderHis/{id}")
    public final Orders pendinghis(@PathParam("id") final int cusId) {
    final Orders cus = OrdersFactory.ordhistory(cusId);
    return cus;
  }
  /**
   * Returns Customer details.
   * @param cusId customer id.
   * @param ordStatus order status
   * @return the customer details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ordercancel/{id}/{status}")
    public final String cancelCusOrder(@PathParam("id") final int cusId, @PathParam("status") final String ordStatus) {
    String comment = "";
    final int cus = OrdersFactory.updateOrdStatus(cusId, ordStatus);
    if (cus > 0) {
      comment = "{\" value \" : \"  Orders  updated successfully \"}";
    } else {
      comment = "{\" value \" : \"  Orders not updated  \"}";
    }
    return comment;
  }
}
