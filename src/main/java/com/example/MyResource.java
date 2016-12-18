package com.example;

import javax.ws.rs.*;

import com.example.brain.Brain;
import com.example.brain.BruteBrain;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {
	Brain brain = new BruteBrain();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("/next-move")
    @Produces("application/json")
    @Consumes("application/json")
    public Integer nextMove(final Integer[][] input) {
    	System.out.println("lol");
        return brain.computeNextMove(input);
    }
}