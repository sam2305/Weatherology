package com.weatherology.integrations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.weatherology.services.users.User;
import com.weatherology.services.users.UserService;

public class UsersIntegrationTest {
	private User user;
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

	@Test
	public void testUserServiceAndUser1() {
		when(this.collection.findOne(this.findObject)).thenReturn(this.returnObject);

		User user = this.userService.createNewUser(this.testJson);
		
		String expected = "exists";
		String actual = user.getEmail();
		
		assertEquals(expected, actual);
		
		user = this.userService.find(this.testJson);
		
		String expectedEmail = "jorge@gmail.com";
		String actualEmail = user.getEmail();
		assertEquals(expectedEmail, actualEmail);
		
		String expectedPassword = "123456";
		String actualPassword = user.getPassword();
		assertEquals(expectedPassword, actualPassword);
		
		Boolean expectedFarenheit = true;
		Boolean actualFarenheit = user.getFarenheit();
		assertEquals(expectedFarenheit, actualFarenheit);
		
		this.testJson = "{\"email\":\"jorge@gmail.com\",\"password\":\"12345\",\"createdOn\":\"Nov 30, 2015 1:52:17 PM\",\"farenheit\":true, \"favorites\":[]}";

		assertNotNull(this.userService.find(this.testJson));
	}

	@Test
	public void testUserServiceAndUser2() {
		when(this.collection.findOne(this.findObject)).thenReturn(null);

		User user = this.userService.createNewUser(this.testJson);
		
		String expectedEmail = "jorge@gmail.com";
		String actualEmail = user.getEmail();
		assertEquals(expectedEmail, actualEmail);

		String expectedPassword = "123456";
		String actualPassword = user.getPassword();
		assertEquals(expectedPassword, actualPassword);
		
		Boolean expectedFarenheit = false;
		Boolean actualFarenheit = user.getFarenheit();
		assertEquals(expectedFarenheit, actualFarenheit);
		
		user = this.userService.find(this.testJson);
		assertNotNull(user);
		
		when(this.collection.remove(this.findObject)).thenReturn(null);
		
		user = this.userService.deleteUser("jorge@gmail.com");
		assertNotNull(user);
	}
}
