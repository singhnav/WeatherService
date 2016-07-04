package com.weather.external.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    public final String description;

    @JsonCreator
    public Weather(@JsonProperty("description") String description) {
        this.description = description;
    }
}
