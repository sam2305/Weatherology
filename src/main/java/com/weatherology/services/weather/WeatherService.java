package com.weatherology.services.weather;

import java.util.ArrayList;

/** Provides main functionality for weather forecasting
 * @author Musa V. Ahmed
 */
public class WeatherService {
	/** List of weather providers */
	private ArrayList<WeatherProviderAdapter> weatherProviders;
	
	/** Constructor for WeatherService
	 */
	public WeatherService() {}
	
	/** Creates new Weather object, initializes list of weather providers.
	 * @param zip Five digit zip code for weather forecast
	 * @return Weather object
	 */
	public Weather createNewWeather(String zip) {
		Weather weather = new Weather(Integer.parseInt(zip));
		this.weatherProviders = new ArrayList<WeatherProviderAdapter>();

		//first
		this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		//second
		//this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		this.weatherProviders.add(new WeatherUndergroundAdapter(new WeatherUnderground(weather.getZip())));
		//this.weatherProviders.add(new OpenWeatherMapAdapter(new OpenWeatherMap(weather.getZip())));
		this.weatherProviders.add(new WorldWeatherOnlineAdapter(new WorldWeatherOnline(weather.getZip())));
		
		for(WeatherProviderAdapter provider: this.weatherProviders) {
			String name = provider.getName();
			double temperature = provider.getTemperatureFahrenheit();
			double humidity = provider.getHumidity();
			
			weather.addForecast(new Forecast(name, temperature, humidity));
		}
		
		return weather;
	}
}
