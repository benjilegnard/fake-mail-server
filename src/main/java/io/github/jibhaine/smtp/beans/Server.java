package io.github.jibhaine.smtp.beans;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Created by blegrand on 08/09/2015.
 */
public final class Server {

    private final String host;

    private final Integer port;

    private final Status status;

    private Server(Builder builder){
        this.host = builder.host;
        this.port = builder.port;
        this.status = builder.status;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public Status getStatus() {
        return status;
    }


    public enum Status{
        RUNNING,
        STOPPED
    }

    @JsonPOJOBuilder
    public static class Builder{

        private String host;

        private Integer port;

        private Status status;

        public Builder(){

        }

        public Builder withHost(String host){
            this.host = host;
            return this;
        }

        public Builder withPort(Integer port){
            this.port = port;
            return this;
        }

        public Builder withStatus(Status status){
            this.status = status;
            return this;
        }

        public Server build(){
            return new Server(this);
        }
    }
}
