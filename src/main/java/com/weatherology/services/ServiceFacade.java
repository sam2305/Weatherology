package com.weatherology.services;

import com.mongodb.DB;
import com.weatherology.services.users.UserService;
import com.weatherology.services.weather.WeatherService;

public class ServiceFacade {

	// UserService
	public UserService createUserService(DB db) {
		return new UserService(db);
	}

	// WeatherService
	public WeatherService createWeatherService() {
		return new WeatherService();
	}
}
