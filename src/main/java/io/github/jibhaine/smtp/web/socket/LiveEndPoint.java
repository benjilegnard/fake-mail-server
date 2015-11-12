package io.github.jibhaine.smtp.web.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * WebSocket Endpoint,
 * Created by blegrand on 12/11/2015.
 */
@ServerEndpoint(value="/live")
public class LiveEndPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiveEndPoint.class);


    @OnOpen
    public void onOpen(Session session) {
        LOGGER.info("New connection with client: {}",
                session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        LOGGER.info("New message from Client [{}]: {}",
                new Object[] {session.getId(), message});
        return "Server received [" + message + "]";
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("Close connection for client: {}",
                session.getId());
    }

    @OnError
    public void onError(Throwable exception, Session session) {
        LOGGER.info("Error for client: {}", session.getId());
    }

}
