package io.github.jibhaine.smtp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.TooMuchDataException;
import org.subethamail.smtp.helper.SimpleMessageListener;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

/**
 * Service given to SubethaSMTP to retrieve mails.
 * Created by blegrand on 12/11/2015.
 */
public class MailListener implements SimpleMessageListener
{

    private static final Logger LOGGER = LoggerFactory.getLogger(MailListener.class);

    @Inject
    private MessageService messageService;

    /**
     * Called once for every RCPT TO during a SMTP exchange.  Each accepted recipient
     * will result in a separate deliver() call later.
     */
    public boolean accept(String from, String recipient)
    {
        LOGGER.debug("accept request from : {} to : {}",from,recipient);
        return true;
    }

    /**
     * When message data arrives, this method will be called for every recipient
     * this listener accepted.
     */
    public void deliver(String from, String recipient, InputStream data) throws TooMuchDataException, IOException
    {

        LOGGER.debug("deliver request from : {} to : {} with data : {}",from, recipient, data);
    }
}
