package com.weatherology.services.weather;

import static org.junit.Assert.*;

import org.junit.Test;
import com.google.gson.Gson;
import com.weatherology.helpers.Icon;

public class OpenWeatherMapTest {

	@Test
	public void shouldPassConstructor1() {
		boolean expected = true;
		boolean actual = true;

		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldPassConstructor2() {
		int zip = 0;
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(zip);
		
		double expected = 0.0;
		double actual = openWeatherMap.temperature;
		
		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void getIcon101() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 101.0;
		
		Icon actual = openWeatherMap.getIcon();
		
		assertNull(actual);
	}
	
	@Test
	public void getIcon201() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 201.0;
		
		Icon expected = Icon.RAIN;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getIcon301() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 301.0;
		
		Icon expected = Icon.RAIN;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}

	@Test
	public void getIcon501() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 501.0;
		
		Icon expected = Icon.RAIN;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getIcon601() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 601.0;
		
		Icon expected = Icon.SNOW;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getIcon701() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 701.0;
		
		Icon expected = Icon.CLEAR_DAY;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getIcon801() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 801.0;
		
		Icon expected = Icon.CLOUDY;
		Icon actual = openWeatherMap.getIcon();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getIcon901() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 901.0;
		
		Icon actual = openWeatherMap.getIcon();
		
		assertNull(actual);
	}
	
	@Test
	public void getIcon951() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 951.0;
		
		Icon actual = openWeatherMap.getIcon();
		
		assertNull(actual);
	}
	
	@Test
	public void getIcon1000() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.icon = 1000.0;
		
		Icon actual = openWeatherMap.getIcon();
		
		assertNull(actual);
	}

	@Test
	public void getTemperatureFahrenheit(){
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.temperature = 255.372;
		
		double expected = 0.0;
		double actual = openWeatherMap.getTemperatureFahrenheit();
		
		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void getTemperatureCelsius() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.temperature = 273.15;
		
		double expected = 0.0;
		double actual = openWeatherMap.getTemperatureCelsius();
		
		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void getHumidity() {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		openWeatherMap.humidity = 90.0;
		
		double expected = 90.0;
		double actual = openWeatherMap.getHumidity();
		
		assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void realUrl1() throws Exception {
		String actual = "";
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		
		Gson gson = new Gson();

		actual = openWeatherMap.readUrl("http://api.openweathermap.org/data/2.5/forecast?zip=33330");
		gson.fromJson(actual, Object.class);
		
		assertTrue(true);
	}
	
	@Test
	public void realUrl2() throws Exception {
		String actual = "";
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(33330);
		
		Gson gson = new Gson();

		actual = openWeatherMap.readUrl("http://api.openweathermap.org/data/2.5/forecast?zip=3333");
		gson.fromJson(actual, Object.class);
	}
	// realUrl 3 (pass, if/else, null)
}
