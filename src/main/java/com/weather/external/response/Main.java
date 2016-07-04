package com.weather.external.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    public final String temp;


    @JsonCreator
    public Main(@JsonProperty("temp") String temp) {
        this.temp = temp;
    }
}
