package com.weatherology.resources;

import com.mongodb.*;

import static spark.Spark.setIpAddress;
import static spark.Spark.setPort;
import static spark.SparkBase.staticFileLocation;

import com.weatherology.services.ServiceFacade;

/** Main class starts Jetty Server and starts resources
 * @author Musa V. Ahmed
 */
public class Bootstrap {

	/** ip address of web server */
	private static final String IP_ADDRESS = "localhost";

	/** port of web server */
	private static final int PORT = 8080;
	
	/** Main method starts web server and resources
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		setIpAddress(IP_ADDRESS);
		setPort(PORT);
		staticFileLocation("/public");
		
		new WeatherResource(new ServiceFacade().createWeatherService());
		new UserResource(new ServiceFacade().createUserService(mongo()));
	}
	
	/** Starts MongoDB connection
	 * @return MongoDB client instance
	 * @throws Exception
	 */
	private static DB mongo() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost");

		return mongoClient.getDB("weatherology");
	}
}
