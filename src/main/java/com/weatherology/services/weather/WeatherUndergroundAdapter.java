package com.weatherology.services.weather;

public class WeatherUndergroundAdapter extends WeatherProviderAdapter {
	private final static String name = "WeatherUnderground";
	private WeatherUnderground weatherUnderground;
	
	public WeatherUndergroundAdapter(WeatherUnderground wunderGround) {
		this.weatherUnderground = weatherUnderground;
	}
	
	public String getName() {
		return WeatherUndergroundAdapter.name;
	}
	
	@Override
	public double getHumidity() {
		return this.weatherUnderground.getHumidity();
	}

	@Override
	double getTemperatureFahrenheit() {
		return this.weatherUnderground.getTemperatureFahrenheit();
	}

	@Override
	double getTemperatureCelsius() {
		return this.weatherUnderground.getTemperatureCelsius();
	}
}
