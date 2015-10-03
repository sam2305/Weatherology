package com.weatherology.weatherology.forecast;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ForecastTest {
	private Forecast forecast;

	@Before
	public void setUp() throws Exception {
		forecast = new Forecast("WeatherProvider", 273.15, 90.0);
	}

	@After
	public void tearDown() throws Exception {
		forecast = null;
	}

	@Test
	public void testGetName() {
		assertEquals(forecast.getName(), "WeatherProvider");
	}

	@Test
	public void testGetTemperature() {
		assertEquals(forecast.getTemperature(), 273.15, 0.01);
	}

	@Test
	public void testGetHumidity() {
		assertEquals(forecast.getHumidity(), 90.0, 0.01);
	}
	
	@Test
	public void testSetName() {
		forecast.setName("TestName");
		assertEquals(forecast.getName(), "TestName");
	}
	
	@Test
	public void testSetTemperature() {
		forecast.setTemperature(270.0);
		assertEquals(forecast.getTemperature(), 270.0, 0.01);
	}
	
	@Test
	public void testSetHumidity() {
		forecast.setHumidity(95.0);
		assertEquals(forecast.getHumidity(), 95.0, 0.01);
	}
	
}
