package io.github.jibhaine.smtp.web;

import io.github.jibhaine.smtp.core.SessionService;
import io.github.jibhaine.smtp.web.socket.LiveEndPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by blegrand on 08/12/2015.
 */
@Named
public class FMSApplicationConfig implements ServerApplicationConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(FMSApplicationConfig.class);

    @Inject
    SessionService sessionService;

    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {
        LOGGER.debug("GET ENDPOINT CONFIGS");
        Set<ServerEndpointConfig> result = new HashSet<>();
        LOGGER.debug("{}",sessionService);
        if (scanned.contains(LiveEndPoint.class)){
                result.add(ServerEndpointConfig.Builder.create(LiveEndPoint.class,"/live").build()
            );

        }

        return result;
    }

    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        LOGGER.debug("GET ANNOTATED ENDPOINT CLASSES");
        Set<Class<?>> results = new HashSet<>();
        for (Class<?> clazz : scanned) {
            //if (clazz.getPackage().getName().startsWith("web.socket.")) {
                results.add(clazz);
            LOGGER.debug("classes scanned : {}", clazz.getCanonicalName());
            //}
        }
        return results;
    }
}
