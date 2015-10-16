package io.github.jibhaine.smtp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.server.SMTPServer;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Wrapper around Wiser
 * //TODO as Wiser is not thread-safe it might be a good thing to use a thread local.
 * Created by blegrand on 08/09/2015.
 */
@ApplicationScoped
public class WiserService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(WiserService.class);

    private Wiser wiserInstance;

    @PostConstruct
    public void setUp(){
        wiserInstance = new Wiser();
        wiserInstance.setHostname("127.0.0.1");
        wiserInstance.setPort(25000);
        wiserInstance.start();

        LOGGER.debug("Starting a new Wiser instance {}",wiserInstance);
    }

    public SMTPServer getSMTPServer(){
        return wiserInstance.getServer();
    }

    public List<WiserMessage> getMessages(){
        return wiserInstance.getMessages();
    }

    @PreDestroy
    public void tearDown(){
        wiserInstance.stop();
    }
}
