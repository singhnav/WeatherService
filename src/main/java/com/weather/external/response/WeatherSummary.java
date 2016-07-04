package com.weather.external.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherSummary {
    public final List<Weather> weather;
    public final Main main;
    public final Sys sys;

    @JsonCreator
    public WeatherSummary(@JsonProperty("weather") List<Weather> weather, @JsonProperty("main") Main main, @JsonProperty("sys") Sys sys) {
        this.weather = weather;
        this.main = main;
        this.sys = sys;
    }
}
