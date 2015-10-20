package com.weatherology.resources;

import com.mongodb.*;

import static spark.Spark.setIpAddress;
import static spark.Spark.setPort;
import static spark.SparkBase.staticFileLocation;

import com.weatherology.services.ServiceFacade;

public class Bootstrap {

	private static final String IP_ADDRESS = "localhost";
	private static final int PORT = 8080;
	
	public static void main(String[] args) throws Exception {
		setIpAddress(IP_ADDRESS);
		setPort(PORT);
		staticFileLocation("/public");
		
		new WeatherResource(new ServiceFacade().createWeatherService());
		new UserResource(new ServiceFacade().createUserService(mongo()));
	}
	
	private static DB mongo() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost");

		return mongoClient.getDB("weatherology");
	}
}
