package com.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewResolverController {

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	protected String weather() {
		return "weather-results";
	}

}