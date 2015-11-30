package com.weatherology.services.users;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class UserServiceTest {
	private UserService userService;
	private DB db;
	private DBCollection collection;
	private BasicDBObject findObject;
	private BasicDBObject returnObject;
	private String testJson;
	
	@Before 
	public void setUp() {
		this.db = mock(DB.class);
		this.collection = mock(DBCollection.class);

		this.findObject = new BasicDBObject("email", "jorge@gmail.com");
		this.returnObject = new BasicDBObject("email", "jorge@gmail.com").append("password", "123456")
																				  .append("createdOn", new Date(2015, 11, 30))
																				  .append("farenheit", true);

		when(this.db.getCollection("users")).thenReturn(this.collection);

		this.testJson = "{\"email\":\"jorge@gmail.com\",\"password\":\"123456\",\"createdOn\":\"Nov 30, 2015 1:52:17 PM\",\"farenheit\":true, \"favorites\":[]}";

		this.userService = new UserService(this.db);
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testCreateNewUser1() {
		when(this.collection.findOne(this.findObject)).thenReturn(this.returnObject);

		User user = this.userService.createNewUser(this.testJson);
		
		assertNotNull(user);
	}
	
	@Test
	public void testCreateNewUser2() {
		when(this.collection.findOne(this.findObject)).thenReturn(null);
		
		User user = this.userService.createNewUser(this.testJson);
		
		assertNotNull(user);
	}
	
	@Test
	public void testFind1() {
		when(this.collection.findOne(this.findObject)).thenReturn(this.returnObject);
		
		User user = this.userService.find(this.testJson);
		
		assertNotNull(user);
	}
	
	@Test
	public void testFind2() {
		when(this.collection.findOne(this.findObject)).thenReturn(null);
		
		User user = this.userService.find(this.testJson);
		
		assertNotNull(user);
	}

	@Test
	public void testFind3() {
		when(this.collection.findOne(this.findObject)).thenReturn(this.returnObject);
		
		this.testJson = "{\"email\":\"jorge@gmail.com\",\"password\":\"12345\",\"createdOn\":\"Nov 30, 2015 1:52:17 PM\",\"farenheit\":true}";
		
		User user = this.userService.find(this.testJson);
		
		assertNotNull(user);
	}
	
	@Test
	public void testDelete() {
		when(this.collection.remove(this.findObject)).thenReturn(null);
		
		User user = this.userService.deleteUser("jorge@gmail.com");
		
		assertNotNull(user);
	}
	
	@Test
	public void testUpdate1() {
		when(this.collection.findOne(this.findObject)).thenReturn(this.returnObject);
		
		User user = this.userService.update(this.testJson);
		
		assertNotNull(user);
	}
}
