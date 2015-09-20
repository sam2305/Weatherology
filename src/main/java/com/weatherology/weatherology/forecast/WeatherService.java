package com.weatherology.weatherology.forecast;

import java.util.ArrayList;

public class WeatherService {
	private ArrayList<WeatherProviderAdapter> weatherProviders;
	
	public WeatherService() {}
	
	public Weather createNewWeather(String zip) {
		System.out.println(zip);
		Weather weather = new Weather(Integer.getInteger(zip));
		
		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		//add second weather provider
		//add third weather provider
		
		for(WeatherProviderAdapter provider: this.weatherProviders) {
			String name = provider.getName();
			double temperature = provider.getTemperature();
			double humidity = provider.getHumidity();
			
			weather.addForecast(new Forecast(name, temperature, humidity));
		}
		
		return weather;
	}
}
