package com.weatherology.services.weather;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherServiceTest {
	
	private WeatherService weatherService;
	
	@Before
	public void setUp() throws Exception {
		this.weatherService = new WeatherService();
	}
	
	@After
	public void tearDown() throws Exception {
		this.weatherService = null;
	}

	@Test
	public void createNewWeatherTest() {
		Weather weather = this.weatherService.createNewWeather("33330");
		
		int expected = 3;
		int actual = weather.getForecasts().size();
		
		assertEquals(expected, actual);
	}

}
