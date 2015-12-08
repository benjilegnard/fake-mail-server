package io.github.jibhaine.smtp.web;

import io.github.jibhaine.smtp.core.FMSMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.*;
import org.subethamail.smtp.server.SMTPServer;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by blegrand on 25/09/2015.
 */
@WebListener
public class FMSApplicationListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(FMSApplicationListener.class);

    private SMTPServer server;

    @Inject
    private FMSMessageHandler messageHandler;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("context initialized");
        server = new SMTPServer(new MessageHandlerFactory() {
            @Override
            public MessageHandler create(MessageContext ctx) {
                return new FMSMessageHandler();
            }
        });
        server.setHostName("localhost");
        server.setPort(25000);
        server.start();
        LOGGER.debug("SMTP Server started");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        server.stop();
        LOGGER.debug("SMTP Server stopped");
        server = null;
    }
}
