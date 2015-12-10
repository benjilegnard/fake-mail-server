package io.github.jibhaine.smtp.beans;

/**
 * Created by blegrand on 09/12/2015.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Options.Builder.class)
public class Options {

    @JsonPOJOBuilder
    public static class Builder {

    }
}
