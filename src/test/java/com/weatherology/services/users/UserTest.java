package com.weatherology.services.users;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() {
		BasicDBObject dbObject = mock(BasicDBObject.class);
		
		when(dbObject.getBoolean("farenheit")).thenReturn(true);
		when(dbObject.getString("email")).thenReturn("mahme012@fiu.edu");
		when(dbObject.getString("password")).thenReturn("12345");
		when(dbObject.getDate("createdOn")).thenReturn(new Date(2015, 1, 1));
		
		ArrayList<Object> tempFavorites = new ArrayList<Object>();
		Favorite favorite = mock(Favorite.class);
		when(favorite.getName()).thenReturn("MyFav");
		when(favorite.getZip()).thenReturn(33330);
		tempFavorites.add(favorite);
		
		when(dbObject.get("favorites")).thenReturn(tempFavorites);
		
		this.user = new User(dbObject);
	}

	@Test
	public void testDummyConstructor() {
		User user = new User();
		
		String expected = "exists";
		String actual = user.getEmail();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFarenheit() {
		Boolean expected = true;
		Boolean actual = this.user.getFarenheit();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetEmail() {
		String expected = "mahme012@fiu.edu";
		String actual = this.user.getEmail();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetPassword() {
		String expected = "12345";
		String actual = this.user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetCreatedOn() {
		Date expected = new Date(2015, 1, 1);
		Date actual = this.user.getCreatedOn();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFavorites() {
		assertNotNull(this.user.getFavorites());
	}
	
	@Test
	public void testSetFarenheit() {
		User temp = new User();
		temp.setFarenheit(false);

		Boolean expected = false;
		Boolean actual = temp.getFarenheit();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetPassword() {
		User temp = new User();
		temp.setPassword("12345");
		
		String expected = "12345";
		String actual = temp.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetEmail() {
		User temp = new User();
		temp.setEmail("mahme012@fiu.edu");
		
		String expected = "mahme012@fiu.edu";
		String actual = temp.getEmail();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetCreatedOn() {
		User temp = new User();
		temp.setCreatedOn(new Date(2015, 1, 1));
		
		Date expected = new Date(2015, 1, 1);
		Date actual = temp.getCreatedOn();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetFavorites() {
		ArrayList<Favorite> favorites = new ArrayList<Favorite>();
		favorites.add(new Favorite("MyFav", 33330));
		
		User temp = new User();
		temp.setFavorites(favorites);
		
		assertNotNull(temp.getFavorites());
	}
}
