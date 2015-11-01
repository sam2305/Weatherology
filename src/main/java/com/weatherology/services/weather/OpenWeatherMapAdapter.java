package com.weatherology.services.weather;

/** Wrapper class for OpenWeatherMap
 * @author Musa V. Ahmed
 */
public class OpenWeatherMapAdapter extends WeatherProviderAdapter {
	/** String representation of API name */
	private final static String name = "OpenWeatherMap";
	/** OpenWeatherMap object */
	private OpenWeatherMap openWeatherMap;
	
	/** Constructor for OpenWeatherMapAdapter 
	 * @param openWeatherMap Instance of OpenWeatherMap
	 */
	public OpenWeatherMapAdapter(OpenWeatherMap openWeatherMap) {
		this.openWeatherMap = openWeatherMap;
	}

	@Override
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
