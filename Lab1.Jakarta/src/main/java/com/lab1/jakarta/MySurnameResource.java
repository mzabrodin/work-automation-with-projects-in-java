package com.lab1.jakarta;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/my-surname")
public class MySurnameResource {
    @GET
    @Produces("text/plain")
    public String surname() {
        return "Zabrodin";
    }
}