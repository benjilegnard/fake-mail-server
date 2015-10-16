package io.github.jibhaine.smtp.core;

import io.github.jibhaine.smtp.dto.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.server.SMTPServer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by blegrand on 08/09/2015.
 */
@ApplicationScoped
public class ServerService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerService.class);

    @Inject
    private WiserService wiserService;

    private SMTPServer server;

    @PostConstruct
    public void setUp(){
        SMTPServer server = wiserService.getSMTPServer();
    }

    public Server getServer(){
        LOGGER.debug("getServer");
        SMTPServer server = wiserService.getSMTPServer();
        if(server.isRunning()){
            LOGGER.debug("SMTP Server is running");
        };

        Server currentServerInstance = new Server.Builder()
                .withHost(server.getHostName())
                .withPort(server.getPort())
                .withStatus(server.isRunning() ? Server.Status.RUNNING : Server.Status.STOPPED )
                .build();

        return currentServerInstance;
    }

}
