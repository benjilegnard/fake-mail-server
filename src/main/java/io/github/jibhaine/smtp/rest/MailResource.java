package io.github.jibhaine.smtp.rest;

import io.github.jibhaine.smtp.core.MessageService;
import io.github.jibhaine.smtp.beans.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blegrand on 08/09/2015.
 */
@Path("/message")
public class MailResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailResource.class);

    @Inject
    private MessageService messageService;

    /**
     * Gets a list of message
     * @return
     */
    @Path("s")
    @GET
    @Produces("application/json")
    public List<Message> retrieve() {
        return new ArrayList<Message>();
    }

    @GET @Path("/{id}")
    @Produces({"application/json", "application/xml"})
    public Message retrieveMessage(@QueryParam("id") String id) {
        return messageService.getMessageById(id);
    }

}
