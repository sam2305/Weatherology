package com.weatherology.services.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherMapAdapterTest {
	
	@Mock
	OpenWeatherMap openWeatherMap;
	
	@InjectMocks
	OpenWeatherMapAdapter openWeatherMapAdapter;
	
	@Test
	public void testGetName() {
		String expected = "OpenWeatherMap";
		
		String actual = openWeatherMapAdapter.getName();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTemperatureFahrenheit() {
		openWeatherMapAdapter.getTemperatureFahrenheit();
		
		verify(openWeatherMap).getTemperatureFahrenheit();
	}

	@Test
	public void testGetTemperatureCelsius() {
		openWeatherMapAdapter.getTemperatureCelsius();
		
		verify(openWeatherMap).getTemperatureCelsius();
	}

	@Test
	public void testGetHumidity() {
		openWeatherMapAdapter.getHumidity();
		
		verify(openWeatherMap).getHumidity();
	}
}
