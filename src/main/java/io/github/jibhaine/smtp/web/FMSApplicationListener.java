package io.github.jibhaine.smtp.web;

import io.github.jibhaine.smtp.core.FMSMessageHandler;
import io.github.jibhaine.smtp.core.ServerService;
import io.github.jibhaine.smtp.core.SessionService;
import io.github.jibhaine.smtp.web.socket.LiveEndPoint;
import io.github.jibhaine.smtp.web.socket.LiveEndPointConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.*;
import org.subethamail.smtp.server.SMTPServer;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;

/**
 * Created by blegrand on 25/09/2015.
 */
@WebListener
public class FMSApplicationListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(FMSApplicationListener.class);

    private static final String SERVER_CONTAINER_ATTRIBUTE = "javax.websocket.server.ServerContainer";

    @Inject
    private SessionService sessionService;

    @Inject
    private ServerService serverService;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("context initialized");
        assert serverService != null;

        ServletContext container = servletContextEvent.getServletContext();
        final ServerContainer serverContainer = (ServerContainer) container.getAttribute(SERVER_CONTAINER_ATTRIBUTE);
        try {
            serverContainer.addEndpoint(new LiveEndPointConfig(LiveEndPoint.class, "/live"));
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
        LOGGER.debug("SMTP Server started");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        serverService.stop();
        LOGGER.debug("SMTP Server stopped");
    }
}
