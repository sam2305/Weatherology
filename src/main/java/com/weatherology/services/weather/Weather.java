package com.weatherology.services.weather;

import java.util.ArrayList;

import com.weatherology.helpers.Icon;

/** Weather class that holds all the forecast information
 * @author Musa V. Ahmed
 */
public class Weather {

	/** Five digit zip code for forecast */
	private int zip;
	/** List of Forecast objects */
	private ArrayList<Forecast> forecasts;
	
	/** Constructor for Weather assigns the zip and initializes forecast list
	 * @param zip Integer five digit zip code for forecast
	 */
	public Weather(int zip) {
		this.zip = zip;
		this.forecasts = new ArrayList<Forecast>();
	}	

	/** Returns the five digit zip code
	 * @return zip Integer five digit zip code
	 */
	public int getZip() {
		return this.zip;
	}

	/** Adds Forecast object to list of Forecasts
	 * @param forecast Forecast object from specific provider
	 */
	public void addForecast(Forecast forecast) {
		this.forecasts.add(forecast);
	}
	
	/** Returns list of Forecast objects
	 * @return forecasts List of Forecast objects
	 */
	public ArrayList<Forecast> getForecasts() {
		return this.forecasts;
	}
}