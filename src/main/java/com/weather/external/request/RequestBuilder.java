package com.weather.external.request;

public class RequestBuilder {

    private static final String QUERY_PARAMS = "?";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String APP_ID = "eca06055c2ed6135d0cb3759da99e1d3";
    private static final String AMPERSAND = "&";
    private static final String APPID_TEXT = "appid=";
    private static final String UNITS_TEXT = "units=";
    private static final String Q_TEXT = "q=";
    private String query;
    private Units units;

    public RequestBuilder withQuery(String query) {
        this.query = query;
        return this;
    }

    public RequestBuilder withUnit(Units units) {
        this.units = units;
        return this;
    }

    public String build() {
        return BASE_URL + QUERY_PARAMS + Q_TEXT + query + AMPERSAND + APPID_TEXT + APP_ID + AMPERSAND + UNITS_TEXT + units;
    }

}
