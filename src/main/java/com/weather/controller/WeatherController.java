package com.weather.controller;

import com.weather.domain.Weather;
import com.weather.exception.WeatherException;
import com.weather.external.response.WeatherSummary;
import com.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class WeatherController {

    @Resource
    WeatherService weatherService;


    @RequestMapping(value = "/show/{city}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Weather showMessage(@PathVariable( "city" ) String city) {
        return weatherService.getWeatherForCity(city);
    }

}