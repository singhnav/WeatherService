package com.weather.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {

    public Date date;
    public String city;
    public String weatherDescription;
    public String temperatureFahrenheit;
    public String temperatureCelsius;
    public Date sunrise;
    public Date sunset;
    private SimpleDateFormat dateFormat12Hr = new SimpleDateFormat("h:mm a");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public Weather(Date date, String city, String weatherDescription, String temperatureFahrenheit, String temperatureCelsius, Date sunrise, Date sunset) {
        this.date = date;
        this.city = city;
        this.weatherDescription = weatherDescription;
        this.temperatureFahrenheit = temperatureFahrenheit;
        this.temperatureCelsius = temperatureCelsius;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getDateNow() {
        return dateFormat.format(date);
    }

    public String getSunriseAsText() {
        return dateFormat12Hr.format(sunrise);
    }

    public String getSunsetAsText() {
        return dateFormat12Hr.format(sunset);
    }
}
