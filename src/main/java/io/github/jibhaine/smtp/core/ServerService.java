package io.github.jibhaine.smtp.core;

import io.github.jibhaine.smtp.beans.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;
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
    private FMSMessageHandler messageHandler;

    private SMTPServer server;

    @PostConstruct
    public void setUp(){
        server = new SMTPServer(new MessageHandlerFactory() {
            @Override
            public MessageHandler create(MessageContext ctx) {
                return messageHandler;
            }
        });
    }

    public Server getServer(){
        LOGGER.debug("getServer");
        //SMTPServer server = wiserService.getSMTPServer();
        if(server.isRunning()){
            LOGGER.debug("SMTP Server is running");
        };

        return new Server.Builder()
                .withHost(server.getHostName())
                .withPort(server.getPort())
                .withStatus(server.isRunning() ? Server.Status.RUNNING : Server.Status.STOPPED )
                .build();

    }

    public void start(){
        server.start();
    }

    public void stop(){
        server.stop();
    }
}
