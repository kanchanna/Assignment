package com.cyberiq.weatherapp;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	private Logger logger = Logger.getLogger(WeatherController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String weatherForm(Model m) {
		m.addAttribute("weatherForm", new City());
	
		
		return "getWeather";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String weatherSubmit(@Valid @ModelAttribute("weatherForm") City city, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			logger.info("Not valid input, returning main page for valid input selection");
			
			return "getWeather";
		}

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://api.openweathermap.org/data/2.5/weather?q="
				.concat(city.getCityName()).concat(",")
				.concat(city.getCountryCode());
		logger.debug("Getting weather Report for city:"+city.getCityName());
		logger.debug("Access RESTful api:"+ url);
		String cityWeather = restTemplate.getForObject(url, String.class);
		try{
			JSONObject jsonObject = new JSONObject(cityWeather);
			JSONObject mainObj = jsonObject.getJSONObject("main");
			// logger.debug(mainObj.get("humidity"));
			// Convert Unix epoch time to java Date Object
			Date dd = new Date(
					Long.parseLong(String.valueOf(jsonObject.get("dt"))) * 1000);
			// logger.debug(dd);
			model.addAttribute("date", dd);
			model.addAttribute("name", jsonObject.get("name"));

			model.addAttribute("humidity", mainObj.get("humidity"));
			model.addAttribute("mintemp", mainObj.get("temp_min"));

			model.addAttribute("maxtemp", mainObj.get("temp_max"));

			model.addAttribute("pressure", mainObj.get("pressure"));
		}catch(JSONException e){
			logger.error(e.getMessage());
		}
		

		return "weatherResults";

	}
	
	@ModelAttribute("cityList")
	private List<String> initModel(Model m){
		List<String> citynames = new ArrayList<String>();
		citynames.add("Atlanta");
		citynames.add("Baltimore");
		citynames.add("Orlando");
		citynames.add("Seattle");
		citynames.add("Houston");
		return citynames;
	}

}
