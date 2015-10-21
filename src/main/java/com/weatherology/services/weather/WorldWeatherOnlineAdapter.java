package com.weatherology.services.weather;

public class WorldWeatherOnlineAdapter extends WeatherProviderAdapter {

	private final static String name = "WorldWeatherOnline";
	private WorldWeatherOnline worldWeatherOnline;
	
	public WorldWeatherOnlineAdapter(WorldWeatherOnline worldWeatherOnline) {
		this.worldWeatherOnline = worldWeatherOnline;
	}
	
	public String getName() {
		return WorldWeatherOnlineAdapter.name;
	}
	
	public String getForecast() {
		return this.worldWeatherOnline.forecast();
	}
	
	public double getTemperature() {
		return this.worldWeatherOnline.getTemperature();
	}
	
	public double getHumidity() {
		return this.worldWeatherOnline.getHumidity();
	}

	@Override
	double getTemperatureFahrenheit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getTemperatureCelsius() {
		// TODO Auto-generated method stub
		return 0;
	}
}
