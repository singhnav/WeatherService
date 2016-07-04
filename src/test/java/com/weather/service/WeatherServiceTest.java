package com.weather.service;

import com.weather.exception.WeatherException;
import com.weather.external.response.Main;
import com.weather.external.response.Sys;
import com.weather.external.response.Weather;
import com.weather.external.response.WeatherSummary;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {

    private WeatherService weatherService = new WeatherService();
    private RestClientProvider restClientProvider = mock(RestClientProvider.class);
    private RestTemplate restTemplate = mock(RestTemplate.class);

    @Before
    public void setup() {
        weatherService.restClientProvider = restClientProvider;
        when(restClientProvider.provideARestClient()).thenReturn(restTemplate);
    }


    @Test
    public void validResponseFromWeatherServer() throws Exception {
        WeatherSummary valid = new WeatherSummary();
        valid.main = new Main();
        valid.main.temp = "21";
        valid.sys = new Sys();
        valid.sys.sunrise = "1467258452";
        valid.sys.sunset = "1467318054";
        Weather weather = new Weather();
        weather.description = "cloudy";
        valid.weather = new ArrayList<Weather>() {{
            add(weather);
        }};

        when(restTemplate.getForObject(anyString(), eq(WeatherSummary.class))).thenReturn(valid);

        com.weather.domain.Weather weatherForCity = weatherService.getWeatherForCity("London");

        assertThat(weatherForCity.city, Is.is("London"));
        assertThat(weatherForCity.weatherDescription, Is.is("cloudy"));
        assertThat(weatherForCity.getSunriseAsText(), Is.is("4:47 AM"));
        assertThat(weatherForCity.getSunsetAsText(), Is.is("9:20 PM"));
        assertThat(weatherForCity.temperatureCelsius, Is.is("21"));
        assertThat(weatherForCity.temperatureFahrenheit, Is.is("69.8"));

    }

    @Test(expected = WeatherException.class)
    public void invalidResponseFromWeatherServer() throws Exception {
        WeatherSummary invalid = new WeatherSummary();
        when(restTemplate.getForObject(anyString(), eq(WeatherSummary.class))).thenReturn(invalid);
        weatherService.getWeatherForCity("London");
    }

}