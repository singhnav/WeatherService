package com.weather.external.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {
    public final String sunrise;
    public final String sunset;

    @JsonCreator
    public Sys(@JsonProperty("sunrise") String sunrise, @JsonProperty("sunset") String sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
