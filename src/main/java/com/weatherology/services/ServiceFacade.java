package com.weatherology.services;

import com.mongodb.DB;
import com.weatherology.services.users.UserService;
import com.weatherology.services.weather.WeatherService;

/** Main entry point for services package
 * @author Musa V. Ahmed
 */
public class ServiceFacade {

    /** Instantiates and returns a new UserService object
     * @param db
     * @return a new UserService instance
     */
	public UserService createUserService(DB db) {
		return new UserService(db);
	}

    /** Instantiates and returns a new WeatherService object
     * @return a new WeatherService instance
     */
	public WeatherService createWeatherService() {
		return new WeatherService();
	}
}
