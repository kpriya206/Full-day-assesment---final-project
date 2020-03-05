package com.hexaware.MLP196.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP196.model.Vendor;
import com.hexaware.MLP196.factory.VendorFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns vendor details.
   * @return the vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }
  /**
   * Returns Vendor details.
   * @return the vendor details
   * @param newVen new vendor.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addvendor")
  public final String addVen(final Vendor newVen)  {
    String comment = " ";
    final int venIns = VendorFactory.insertVen(newVen);
    if (venIns > 0) {
      comment = "{\" value \" : \" Vendor data added successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor data not added  \"}";
    }
    return comment;
  }
  /**
   * Returns Vendor details.
   * @return the vendor details
   * @param newVen new vendor.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatevendor")
    public final String updateVen(final Vendor newVen) {
    String comment = "";
        //final int carIns = CarFactory.insertCar(newCar);
    final int venUpdate = VendorFactory.updateVenPrice(newVen);
    if (venUpdate > 0) {
      comment = "{\" value \" : \" Vendor updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not updated  \"}";
    }
    return comment;
  }
    /**
   * Returns Vendor details.
   * @param venName vendor id.
   * @return the vendor details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showvendor/{name}")
    public final Vendor showVendor(@PathParam("name")final String venName) {
    final Vendor ven = VendorFactory.showVendor(venName);
    return ven;
  }
   /**
   * Returns Vendor details.
   * @param vname vendor name.
   * @param vpwd vendor password.
   * @return the vendor details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginven/{vname}/{vpwd}")
    public final Vendor loginven(@PathParam("vname")final String vname, @PathParam("vpwd")final String vpwd) {
    final Vendor ven = VendorFactory.loginVendor(vname, vpwd);
    return ven;
  }
}
