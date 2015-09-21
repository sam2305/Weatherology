package com.weatherology.weatherology.forecast;

import com.weatherology.weatherology.Icon;

import java.util.ArrayList;

public class Weather {

	private int zip;
	private Icon icon;
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
	
	public void setIcon(String condition) {
		// Come up with logic for transforming condition into icon
		this.icon = Icon.CLEAR_DAY;
	}
}