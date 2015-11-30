package com.weatherology.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import com.mongodb.DB;
import com.weatherology.services.users.UserService;
import com.weatherology.services.weather.WeatherService;

public class ServiceFacadeTest {
	private ServiceFacade serviceFacade;
	private UserService userService;
	private WeatherService weatherService;

	@Before
	public void setUp() {
		this.serviceFacade = new ServiceFacade();
	}
	
	@After
	public void tearDown() {
		this.serviceFacade = null;
		this.userService = null;
		this.weatherService = null;
	}
	
	@Test
	public void testCreateUserService() {
		DB db = mock(DB.class);
		
		this.userService = this.serviceFacade.createUserService(db);
		
		assertNotNull(this.userService);
	}
	
	@Test
	public void testCreateWeatherService() {
		this.weatherService = this.serviceFacade.createWeatherService();
		
		assertNotNull(this.weatherService);
	}

}
