package com.weatherology.services.weather;

/** Abstract class providing interface for various 
 * weather provider adapters
 * @author Musa V. Ahmed
 */
public abstract class WeatherProviderAdapter {
	
	/** Name getter
	 * @return name of weather provider
	 */
	abstract String getName();
	
	/** Temperature getter
	 * @return temperature value in Fahrenheit
	 */
	abstract double getTemperatureFahrenheit();

	/** Temperature getter
	 * @return temperature value in Celsius
	 */
	abstract double getTemperatureCelsius();
	
	/** Humidity getter
	 * @return humidity value as a percentage
	 */
	abstract double getHumidity();
}
