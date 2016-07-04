package com.weather.service;


import com.weather.domain.Weather;
import com.weather.exception.WeatherException;
import com.weather.external.request.RequestBuilder;
import com.weather.external.response.WeatherSummary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;

import static com.weather.external.request.Units.metric;

@Service
public class WeatherService {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Resource
    RestClientProvider restClientProvider;


    public Weather getWeatherForCity(String city)  {
        WeatherSummary weatherExternal = restClientProvider.provideARestClient().getForObject(new RequestBuilder().withQuery(city).withUnit(metric).build(), WeatherSummary.class);
        return convertToInternalWeatherDomain(city, weatherExternal);
    }

    private Weather convertToInternalWeatherDomain(String city, WeatherSummary weatherExternal) {
        if (weatherExternal == null || weatherExternal.weather == null || weatherExternal.weather.isEmpty()) {
            throw new WeatherException("Missing weather details");
        }
        return new Weather(new Date(), city, weatherExternal.weather.get(0).description,
                convertCelsiusToFahrenheit(weatherExternal),weatherExternal.main.temp, new Date(Long.valueOf(weatherExternal.sys.sunrise) * 1000),
                new Date(Long.valueOf(weatherExternal.sys.sunset) * 1000));
    }

    private String convertCelsiusToFahrenheit(WeatherSummary weatherExternal) {
        //It makes more performance sense to convert units internally rather than making  individual calls for Fahrenheit and Celsius
        double inFahrenheit = (Double.valueOf(weatherExternal.main.temp) * 9 / 5) + 32;
        return decimalFormat.format(inFahrenheit);
    }

}
