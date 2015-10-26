package com.weatherology.services.weather;

import java.util.ArrayList;

/** 
 * @author Musa V. Ahmed
 */
public class WeatherService {
	/**
	 * 
	 */
	private ArrayList<WeatherProviderAdapter> weatherProviders;
	
	/**
	 * 
	 */
	public WeatherService() {}
	
	/**
	 * @param zip
	 * @return
	 */
	public Weather createNewWeather(String zip) {
		Weather weather = new Weather(Integer.parseInt(zip));
		this.weatherProviders = new ArrayList<WeatherProviderAdapter>();

		//first
		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		//second
		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		//third
		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		
		for(WeatherProviderAdapter provider: this.weatherProviders) {
			String name = provider.getName();
			double temperature = provider.getTemperatureFahrenheit();
			double humidity = provider.getHumidity();
			
			weather.addForecast(new Forecast(name, temperature, humidity));
		}
		
		return weather;
	}
}
