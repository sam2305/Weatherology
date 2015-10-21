package com.weatherology.helpers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.weatherology.services.weather.Weather;

public class JsonTransformerTest {
	private JsonTransformer jsonTransformer;
	
	@Before
	public void setUp() throws Exception {
		this.jsonTransformer = new JsonTransformer();
	}
	
	@After
	public void tearDown() throws Exception {
		this.jsonTransformer = null;
	}

	@Test
	public void renderTest() throws Exception {
		String actual = this.jsonTransformer.render(new Weather(33330));

		Gson gson = new Gson();
		gson.fromJson(actual, Weather.class);
		
		String expected = "{\"zip\":33330,\"forecasts\":[]}";
		
		assertEquals(expected, actual);
	}

}
