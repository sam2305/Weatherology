package com.weatherology.weatherology.forecast;

public class OpenWeatherMapAdapter extends WeatherProviderAdapter {
	private final static String name = "OpenWeatherMap";
	private OpenWeatherMap openWeatherMap;
	
	public OpenWeatherMapAdapter(OpenWeatherMap openWeatherMap) {
		this.openWeatherMap = openWeatherMap;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getForecast() {
		return this.openWeatherMap.forecast();
	}
	
	public double getTemperature() {
		return this.openWeatherMap.getTemperature();
	}
	
	public double getHumidity() {
		return this.openWeatherMap.getHumidity();
	}
}
