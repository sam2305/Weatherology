package com.weatherology.services.weather;

public class Forecast {
	protected String name;
	protected double temperature;
	protected double humidity;

	public Forecast(String name, double temperature, double humidity) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getTemperature() {
		return this.temperature;
	}
	
	public double getHumidity() {
		return this.humidity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
}
