package io.github.jibhaine.smtp.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Immutable Message DTO with its Builder.
 */
public class Message implements Serializable {

    private String id;

    private Date receptionDate;

    private String subject;

    private String sender;

    private String receiver;

    private byte[] body;

    private Message(Builder builder) {
        this.id = builder.id.toString();
        this.subject = builder.subject;
        this.receptionDate = builder.receptionDate;
        this.body = Arrays.copyOf(builder.body, builder.body.length);
    }

    public String getId() {
        return id;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public String getSubject() {
        return subject;
    }

    public byte[] getBody() {
        return body;
    }

    public static class Builder {

        private UUID id;

        private Date receptionDate;

        private String subject;

        private byte[] body;

        public Builder() {
            id = UUID.randomUUID();
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withBody(byte[] body) {
            this.body = Arrays.copyOf(body, body.length);
            return this;
        }

        public Builder withReceptionDate(Date receptionDate) {
            this.receptionDate = receptionDate;
            return this;
        }

        public Message build() {
            return new Message(this);
        }

    }
}
