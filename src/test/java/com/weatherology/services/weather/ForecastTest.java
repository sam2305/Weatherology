package com.weatherology.services.weather;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weatherology.services.weather.Forecast;

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
        String expected = "WeatherProvider";
        String actual = this.forecast.getName();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetTemperature() {
        double expected = 273.15;
        double actual = this.forecast.getTemperature();

		assertEquals(expected, actual, 0.01);
	}

	@Test
	public void testGetHumidity() {
        double expected = 90.0;
        double actual = this.forecast.getHumidity();

		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void testSetName() {
        String expected = "TestName";

		forecast.setName("TestName");
        String actual = this.forecast.getName();

		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetTemperature() {
        double expected = 270.0;

		forecast.setTemperature(270.0);
        double actual = this.forecast.getTemperature();

		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void testSetHumidity() {
        double expected = 95.0;

		forecast.setHumidity(95.0);
        double actual = this.forecast.getHumidity();

		assertEquals(expected, actual, 0.01);
	}

    @Test
    public void testEqualsIsTrue() {
        boolean expected = true;

        Forecast temp = new Forecast("WeatherProvider", 273.15, 90.0);
        boolean actual = this.forecast.equals(temp);

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsIsFalseObject() {
        boolean expected = false;

        String temp = "WeatherProvider";
        boolean actual = this.forecast.equals(temp);

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsIsFalseName() {
        boolean expected = false;

        Forecast temp = new Forecast("ProviderWeather", 273.15, 90.0);
        boolean actual = this.forecast.equals(temp);

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsIsFalseTemperature() {
        boolean expected = false;

        Forecast temp = new Forecast("WeatherProvider", 272.15, 90.0);
        boolean actual = this.forecast.equals(temp);

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsIsFalseHumidity() {
        boolean expected = false;

        Forecast temp = new Forecast("WeatherProvider", 273.15, 91.0);
        boolean actual = this.forecast.equals(temp);

        assertEquals(expected, actual);
    }
}
