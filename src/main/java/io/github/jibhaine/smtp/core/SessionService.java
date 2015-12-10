package io.github.jibhaine.smtp.core;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import java.util.Collections;
import java.util.Set;

/**
 * Keeps tracks of the currently opened sessions.
 * Created by blegrand on 12/11/2015.
 */
@ApplicationScoped
public class SessionService {

    private static Set<Session> userSessions = Collections.emptySet();

    public void add(Session session) {
        userSessions.add(session);
    }

    public void remove(Session session) {
        userSessions.remove(session);
    }

    public void broadcast(String message) {

        for (Session session : userSessions) {
            session.getAsyncRemote().sendText(message);
        }
    }


}
