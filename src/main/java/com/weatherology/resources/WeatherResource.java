package com.weatherology.resources;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

import com.weatherology.helpers.JsonTransformer;
import com.weatherology.services.weather.WeatherService;

/** Exposes REST endpoints for weather services
 * @author Musa V. Ahmed
 */
public class WeatherResource {
	/** API context */
	private static final String API_CONTEXT = "/api/v1";

	/** WeatherService instance */
	private final WeatherService weatherService;

	/** Constructor for WeatherResource receives WeatherService and exposes endpoints
	 * @param weatherService
	 */
	public WeatherResource(WeatherService weatherService) {
		this.weatherService = weatherService;
		setupEndpoints();
	}

	/** Exposes REST endpoints, calls necessary service, serializes to Json
	 */
	private void setupEndpoints() {
		get(API_CONTEXT + "/weather/:zip", "application/json", (request, response)
				-> weatherService.createNewWeather(request.params(":zip")), new JsonTransformer());
	}
}
