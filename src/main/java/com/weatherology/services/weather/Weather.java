package com.weatherology.services.weather;

import java.util.ArrayList;

import com.weatherology.helpers.Icon;

public class Weather {

	private int zip;
	private ArrayList<Forecast> forecasts;
	
	public Weather(int zip) {
		this.zip = zip;
		this.forecasts = new ArrayList<Forecast>();
	}	

	public int getZip() {
		return this.zip;
	}

	public void addForecast(Forecast forecast) {
		this.forecasts.add(forecast);
	}
	
	public ArrayList<Forecast> getForecasts() {
		return this.forecasts;
	}
}