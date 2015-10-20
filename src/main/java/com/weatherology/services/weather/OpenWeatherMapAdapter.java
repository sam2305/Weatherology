package com.weatherology.services.weather;

public class OpenWeatherMapAdapter extends WeatherProviderAdapter {
	private final static String name = "OpenWeatherMap";
	private OpenWeatherMap openWeatherMap;
	
	public OpenWeatherMapAdapter(OpenWeatherMap openWeatherMap) {
		this.openWeatherMap = openWeatherMap;
	}
	
	public String getName() {
		return OpenWeatherMapAdapter.name;
	}
	
	@Override
	public double getTemperatureFahrenheit() {
		return this.openWeatherMap.getTemperatureFahrenheit();
	}
	
	@Override
	public double getTemperatureCelsius() {
		return this.openWeatherMap.getTemperatureCelsius();
	}
	
	@Override
	public double getHumidity() {
		return this.openWeatherMap.getHumidity();
	}
}
