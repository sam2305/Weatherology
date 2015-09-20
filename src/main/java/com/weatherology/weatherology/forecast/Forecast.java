package com.weatherology.weatherology.forecast;

public class Forecast {
	protected String name;
	protected double temperature;
	protected double humidity;
	
	public Forecast(String name, double temperature, double humidity) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
	}
}
