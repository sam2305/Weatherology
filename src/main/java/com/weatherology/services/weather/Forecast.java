package com.weatherology.services.weather;

/** Forecast class contains all forecast information
 * @author Musa V. Ahmed
 */
public class Forecast {
	/** Name of weather provider forecast data came from */
	protected String name;
	/** Temperature from weather provider */
	protected double temperature;
	/** Humidity from weather provider */
	protected double humidity;

	/** Constructor for Forecast initializes name, temperature, humidity
	 * @param name Name of weather provider
	 * @param temperature Temperature from weather provider
	 * @param humidity Humidity from weather provider
	 */
	public Forecast(String name, double temperature, double humidity) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	/** Returns name of weather provider
	 * @return name String of weather provider name
	 */
	public String getName() {
		return this.name;
	}
	
	/** Returns temperature from weather provider
	 * @return temperature Double of temperature
	 */
	public double getTemperature() {
		return this.temperature;
	}
	
	/** Return humidity from weather provider
	 * @return humidity Double of humidity
	 */
	public double getHumidity() {
		return this.humidity;
	}
	
	/** Sets weather provider name
	 * @param name String of weather provider name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Sets temperature from weather provider
	 * @param temperature Double of temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	/** Sets humidity from weather provider
	 * @param humidity Double of humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	public boolean equals(Object obj) {
        if (! (obj instanceof Forecast))
            return false;

        Forecast forecast = (Forecast) obj;
        if (this.name.equals(forecast.name) &&
            this.temperature == forecast.temperature &&
            this.humidity == forecast.humidity)
            return true;

		return false;
	}
}
