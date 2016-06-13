package com.weatherology.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
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
		DBCollection collection = mock(DBCollection.class);
		
		when(db.getCollection("users")).thenReturn(collection);
		
		BasicDBObject object1 = new BasicDBObject("email", "sam_vincent@gmail.com");
		when(collection.findOne(object1)).thenReturn(object1);
		
		this.userService = this.serviceFacade.createUserService(db);
		
		assertNotNull(this.userService);
	}
	
	@Test
	public void testCreateWeatherService() {
		this.weatherService = this.serviceFacade.createWeatherService();
		
		assertNotNull(this.weatherService);
	}

}
