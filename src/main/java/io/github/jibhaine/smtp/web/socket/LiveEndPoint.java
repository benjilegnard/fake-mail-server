package io.github.jibhaine.smtp.web.socket;

import io.github.jibhaine.smtp.core.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * WebSocket Endpoint,
 * Created by blegrand on 12/11/2015.
 */
@ApplicationScoped
@ServerEndpoint(value="/live")
public class LiveEndPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiveEndPoint.class);

    @Inject
    SessionService sessionService;

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.info("New connection with client: {}", session.getId());
        sessionService.add(session);
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        LOGGER.info("New message from Client [{}]: {}",  new Object[] {session.getId(), message});
        return "Server received [" + message + "]";
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("Close connection for client: {}", session.getId());
        sessionService.remove(session);
    }

    @OnError
    public void onError(Throwable exception, Session session) {

        LOGGER.info("Error for client: {}", session.getId());
    }

}
