package com.github.anilbolat.ejbtest.controller;

import com.github.anilbolat.ejbtest.data.Coffee;
import com.github.anilbolat.ejbtest.ejb.local.CoffeeLocalEJB;

import javax.inject.Inject;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

    @GET
    @Path("{coffee}")
    public void sendNewCoffee(@PathParam("coffee") String coffee) {

        Context context = null;
        ConnectionFactory connectionFactory = null;
        Queue queue = null;
        String queueName = "java:/jms/queue/NewCoffeeArrivalQueue";
        try {
            context = new InitialContext();
            connectionFactory = (ConnectionFactory) context.lookup("/ConnectionFactory");
            queue = (Queue) context.lookup(queueName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            connection.start();

            TextMessage message = session.createTextMessage(coffee);
            publisher.send(message);

        } catch (JMSException e) {
            System.out.println(("Error while trying to send <" + coffee + "> message: " + e.getMessage()));
        }


    }
}
