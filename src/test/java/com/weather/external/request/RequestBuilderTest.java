package com.weather.external.request;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestBuilderTest {

    @Test
    public void buildWeatherRequestFromParams() throws Exception {
        String requestUri = new RequestBuilder().withUnit(Units.metric).withQuery("London").build();
        assertThat(requestUri, Is.is("http://api.openweathermap.org/data/2.5/weather?q=London&appid=eca06055c2ed6135d0cb3759da99e1d3&units=metric"));

    }
}