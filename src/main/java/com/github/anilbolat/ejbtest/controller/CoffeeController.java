package com.github.anilbolat.ejbtest.controller;

import com.github.anilbolat.ejbtest.data.Coffee;
import com.github.anilbolat.ejbtest.ejb.local.CoffeeLocalEJB;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/coffee")
// /api/coffee
public class CoffeeController {

    @Inject
    CoffeeLocalEJB coffeeLocalEJB;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coffee> getAll() {
        return coffeeLocalEJB.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Coffee newCoffee) {
        coffeeLocalEJB.create(newCoffee);
    }

    @PUT
    @Path("{id}")
    // /api/coffee/123
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Coffee coffee) {
        coffeeLocalEJB.update(id, coffee);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        coffeeLocalEJB.remote(id);
    }
}
