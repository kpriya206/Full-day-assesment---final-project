package com.hexaware.MLP196.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP196.model.Offers;
import com.hexaware.MLP196.factory.OffersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/offers")
public class OffersRest {
  /**
   * Returns offers details.
   * @return the offers details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Offers[] listOffers() {
    final Offers[] offers = OffersFactory.showOffers();
    return offers;
  }
  /**
   * Returns Offers details.
   * @return the offers details
   * @param newOffers new offer.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addoffers")
  public final String addOffers(final Offers newOffers)  {
    String comment = " ";
    final int offIns = OffersFactory.insertOff(newOffers);
    if (offIns > 0) {
      comment = "{\" value \" : \" Offers data added successfully \"}";
    } else {
      comment = "{\" value \" : \" Offers data not added  \"}";
    }
    return comment;
  }
  /**
   * Returns Offers details.
   * @return the offers details
   * @param newOff new offers .
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateoffers")
    public final String updateCus(final Offers newOff) {
    String comment = "";
        //final int carIns = CarFactory.insertCar(newCar);
    final int offUpdate = OffersFactory.updateOffItem(newOff);
    if (offUpdate > 0) {
      comment = "{\" value \" : \" Offers updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Offers not updated  \"}";
    }
    return comment;
  }
    /**
   * Returns Offers details.
   * @param ordId coupon code.
   * @return the Offers details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showoffers/{id}")
    public final Offers showOffers(@PathParam("id") final int ordId) {
    final Offers off = OffersFactory.showOffers(ordId);
    return off;
  }
}
