package com.weatherology.services.users;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weatherology.services.users.Favorite;

public class FavoriteTest {
	private Favorite favorite;

	@Before
	public void setUp() throws Exception {
		favorite = new Favorite("MyFav", 33330);
	}

	@Test
	public void testGetName() {
		String expected = "MyFav";
		String actual = this.favorite.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetZip() {
		int expected = 33330;
		int actual = this.favorite.getZip();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetName() {
		this.favorite.setName("MyNewFav");

		String expected = "MyNewFav";
		String actual = this.favorite.getName();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetZip() {
		this.favorite.setZip(12345);
		
		int expected = 12345;
		int actual = this.favorite.getZip();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEquals1() {
		Favorite temp = new Favorite("MyFav", 33330);

		assertTrue(this.favorite.equals(temp));
	}
	
	@Test
	public void testEquals2() {
		Object obj = new Object();
		
		assertFalse(this.favorite.equals(obj));
	}
	
	@Test
	public void testEquals3() {
		Favorite temp = new Favorite("NotMyFav", 33330);
		
		assertFalse(this.favorite.equals(temp));
	}
	
	@Test
	public void testEquals4() {
		Favorite temp = new Favorite("MyFav", 12345);
		
		assertFalse(this.favorite.equals(temp));
	}
}
