package com.weatherology.resources;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

import com.weatherology.helpers.JsonTransformer;
import com.weatherology.services.weather.WeatherService;

public class WeatherResource {
	private static final String API_CONTEXT = "/api/v1";

	private final WeatherService weatherService;

	public WeatherResource(WeatherService weatherService) {
		this.weatherService = weatherService;
		setupEndpoints();
	}

	private void setupEndpoints() {
		get(API_CONTEXT + "/weather/:zip", "application/json", (request, response)
				-> weatherService.createNewWeather(request.params(":zip")), new JsonTransformer());
	}
}
