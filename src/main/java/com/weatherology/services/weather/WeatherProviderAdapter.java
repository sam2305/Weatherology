package com.weatherology.services.weather;

public abstract class WeatherProviderAdapter {
	
	abstract String getName();
	
	abstract double getTemperatureFahrenheit();

	abstract double getTemperatureCelsius();
	
	abstract double getHumidity();
}
