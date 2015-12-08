package io.github.jibhaine.smtp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by blegrand on 08/12/2015.
 */
//@ApplicationScoped
@Named
public class FMSMessageHandler implements MessageHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FMSMessageHandler.class);

    @Override
    public void from(String from) throws RejectException {
        LOGGER.trace("from {}",from);
    }

    @Override
    public void recipient(String recipient) throws RejectException {
        LOGGER.trace("recipient {}", recipient);
    }

    @Override
    public void data(InputStream data) throws RejectException, TooMuchDataException, IOException {
        LOGGER.trace("data {}", data);
    }

    @Override
    public void done() {
        LOGGER.trace("done");
    }
}
