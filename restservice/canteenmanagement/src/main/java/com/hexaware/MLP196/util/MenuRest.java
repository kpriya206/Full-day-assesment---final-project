package com.hexaware.MLP196.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP196.model.Menu;
import com.hexaware.MLP196.factory.MenuFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }
  /**
   * Returns Menu details.
   * @return the menu details
   * @param newMenu new menu .
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addmenu")
  public final String addMenu(final Menu newMenu)  {
    String comment = " ";
    final int menuIns = MenuFactory.insertMenu(newMenu);
    if (menuIns > 0) {
      comment = "{\" value \" : \" Menu data added successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu data not added  \"}";
    }
    return comment;
  }
  /**
   * Returns Menu details.
   * @return the menu details
   * @param newMenu new menu .
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatemenu")
    public final String updateMenu(final Menu newMenu) {
    String comment = "";
        //final int carIns = CarFactory.insertCar(newCar);
    final int menuUpdate = MenuFactory.updateMenuPrice(newMenu);
    if (menuUpdate > 0) {
      comment = "{\" value \" : \" Menu updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu not updated  \"}";
    }
    return comment;
  }
    /**
   * Returns Menu details.
   * @param foodId food id.
   * @return the menu details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showmenu/{id}")
    public final Menu showMenu(@PathParam("id") final String foodId) {
    final Menu menu = MenuFactory.showMenu(foodId);
    return menu;
  }
}
