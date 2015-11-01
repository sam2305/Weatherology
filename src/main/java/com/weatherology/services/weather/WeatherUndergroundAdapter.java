package com.weatherology.services.weather;

/** Wrapper class for WeatherUnderground
 * @author Musa V. Ahmed
 */
public class WeatherUndergroundAdapter extends WeatherProviderAdapter {
	/** String representation of API name */
	private final static String name = "WeatherUnderground";
	/** WeatherUnderground object */
	private WeatherUnderground weatherUnderground;
	
	/** Constructor for WeatherUndergroundAdapter
	 * @param weatherUnderground Instance of WeatherUnderground
	 */
	public WeatherUndergroundAdapter(WeatherUnderground weatherUnderground) {
		this.weatherUnderground = weatherUnderground;
	}
	
	@Override
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
