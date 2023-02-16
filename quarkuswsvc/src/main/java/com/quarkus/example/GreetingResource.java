package com.quarkus.example;

import com.mycompany.loader.App;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        new App().count("We're the People of El Salvador!");
        return "Completed";
    }
}