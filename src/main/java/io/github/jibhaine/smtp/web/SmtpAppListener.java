package io.github.jibhaine.smtp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.*;
import org.subethamail.smtp.server.SMTPServer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by blegrand on 25/09/2015.
 */
@WebListener
public class SmtpAppListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmtpAppListener.class);

    private SMTPServer server;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("context initialized");
        server = new SMTPServer(new MessageHandlerFactory() {
            public MessageHandler create(MessageContext messageContext) {
                return new MessageHandler() {
                    public void from(String s) throws RejectException {

                    }

                    public void recipient(String s) throws RejectException {

                    }

                    public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {

                    }

                    public void done() {

                    }
                };
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
