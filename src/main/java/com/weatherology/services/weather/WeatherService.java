package com.weatherology.services.weather;

import java.util.ArrayList;

public class WeatherService {
	private ArrayList<WeatherProviderAdapter> weatherProviders;
	
	public WeatherService() {
		
	}
	
	public Weather createNewWeather(String zip) {
		Weather weather = new Weather(Integer.parseInt(zip));
		this.weatherProviders = new ArrayList<WeatherProviderAdapter>();

		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		//add second weather provider
		//add third weather provider
		
		for(WeatherProviderAdapter provider: this.weatherProviders) {
			String name = provider.getName();
			double temperature = provider.getTemperatureFahrenheit();
			double humidity = provider.getHumidity();
			
			weather.addForecast(new Forecast(name, temperature, humidity));
		}
		
		return weather;
	}
}
