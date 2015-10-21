package com.weatherology.services.weather;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherTest {
	private Weather weather;

	@Before
	public void setUp() throws Exception {
		weather = new Weather(33330);
	}
	
	@After
	public void tearDown() throws Exception {
		weather = null;
	}
	
	@Test
	public void testGetZip() {
		int expected = 33330;
		int actual = this.weather.getZip();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetForecasts() {
		ArrayList<Forecast> expected = new ArrayList<Forecast>();
		expected.add(new Forecast("WeatherProvider", 273.15, 90.0));

		this.weather.addForecast(new Forecast("WeatherProvider", 273.15, 90.0));
		ArrayList<Forecast> actual = this.weather.getForecasts();

		for (int i = 0; i < expected.size() && i < actual.size(); i++) {
			assertTrue(expected.get(i).equals(actual.get(i)));
		}
	}
	
	@Test
	public void testAddForecast() {
		ArrayList<Forecast> expected = new ArrayList<Forecast>();
		expected.add(new Forecast("WeatherProvider", 273.15, 90.0));

		this.weather.addForecast(new Forecast("WeatherProvider", 273.15, 90.0));
		ArrayList<Forecast> actual = this.weather.getForecasts();
		
		assertEquals(expected, actual);
	}
}
