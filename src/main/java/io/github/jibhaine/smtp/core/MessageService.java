package io.github.jibhaine.smtp.core;

import io.github.jibhaine.smtp.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.wiser.WiserMessage;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by blegrand on 08/09/2015.
 */
public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    @Inject
    private  SessionService sessionService;

    private Map<String, Message> storedMessages;

    @PostConstruct
    public void setUp() {
        storedMessages = new HashMap<String, Message>();
    }

    public Message getMessageById(String uuid) {
        return storedMessages.get(uuid);
    }

/*
    public synchronized void synchronizeMessage() {
        LOGGER.debug("Synchronizing Messages ...");
        for (WiserMessage wiserMessage : wiserService.getMessages()) {
            MimeMessage mimeMessage;
            Message message;
            try {
                mimeMessage = wiserMessage.getMimeMessage();

                message = new Message.Builder()
                        .withSubject(mimeMessage.getSubject())
                        .withBody(wiserMessage.getData())
                        .withReceptionDate(mimeMessage.getReceivedDate())
                        .build();
            } catch (MessagingException mex) {
                continue;
            }
            storedMessages.put(message.getId(), message);
            wiserService.getMessages().remove(wiserMessage);
        }
    }

*/
}
