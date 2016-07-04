package com.weather.controller;

import com.weather.domain.Weather;
import com.weather.service.WeatherService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WeatherControllerTest {

    private WeatherService weatherService = mock(WeatherService.class);

    @Test
    public void delegateToService() throws Exception {
        WeatherController weatherController = new WeatherController();
        weatherController.weatherService = weatherService;
        weatherController.showMessage("London");
        verify(weatherService).getWeatherForCity("London");
    }

}