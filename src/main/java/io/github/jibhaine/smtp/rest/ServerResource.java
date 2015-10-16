package io.github.jibhaine.smtp.rest;

import io.github.jibhaine.smtp.core.ServerService;
import io.github.jibhaine.smtp.dto.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;

/**
 * Created by blegrand on 08/09/2015.
 */
@Path("/server")
public class ServerResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerResource.class);

    private ServerService serverService;

    @GET
    @Produces("application/json")
    public Object retrieve(){
        LOGGER.debug("retrieve server");
        return null;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Server update(){
        return null;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Server create(){
        return null;
    }

    @Path("/start")
    public void start(){

    }

    @Path("/stop")
    public void stop(){

    }
}
