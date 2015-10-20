package com.weatherology.services.weather;

public class WeatherUndergroundAdapter extends WeatherProviderAdapter {
	private final static String name = "WunderGround";
	private WeatherUnderground wunderGround;
	
	public WeatherUndergroundAdapter(WeatherUnderground wunderGround) {
		this.wunderGround = wunderGround;
	}
	
	public String getName() {
		return WeatherUndergroundAdapter.name;
	}
	
	@Override
	public double getHumidity() {
		return this.wunderGround.getHumidity();
	}

	@Override
	double getTemperatureFahrenheit() {
		return 0;
	}

	@Override
	double getTemperatureCelsius() {
		return 0;
	}
}
