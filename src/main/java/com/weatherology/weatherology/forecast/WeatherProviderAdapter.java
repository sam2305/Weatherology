package com.weatherology.weatherology.forecast;

public abstract class WeatherProviderAdapter {
	
	abstract String getName();
	
	abstract double getTemperature();
	
	abstract double getHumidity();
}
