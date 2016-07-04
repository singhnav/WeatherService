package com.weather.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientProvider {

    private static RestTemplate restTemplate = new RestTemplate();

    public RestTemplate provideARestClient() {
        return restTemplate;
    }

}
