package com.cyberiq.weatherapp;

import org.hibernate.validator.constraints.NotEmpty;





public class City {
	@NotEmpty(message = "Please select a city name.")
	private String cityName;
	private String countryCode="US";


	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
