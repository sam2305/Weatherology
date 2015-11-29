package com.weatherology.services.users;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
//import org.bson.types.ObjectId;

import java.util.Date;
import java.util.ArrayList;

/** User class that holds all the user information
 * @author Musa V. Ahmed
 */
public class User {

	/** Unique ID */
	//private String id;
	/** User email */
	private String email;
	/** User password */
	private String password;
	/** Creation date */
	private Date createdOn = new Date();
	/** User temp unit*/
	private boolean farenheit;
	/** List of Favorite objects */
	private ArrayList<Favorite> favorites;
	
	/** Constructor for User
	 * @param dbObject Equivalent DB object
	 */
	public User(){this.email = "exists";}
	
	@SuppressWarnings("unchecked")
	public User(BasicDBObject dbObject) {
		this.farenheit = dbObject.getBoolean("farenheit");
		this.email = dbObject.getString("email");
		this.password = dbObject.getString("password");
		this.createdOn = dbObject.getDate("createdOn");
		this.favorites = (ArrayList<Favorite>) dbObject.get("favorites");
	}
	
	public boolean getFarenheit() {
		return farenheit;
	}

	public void setFarenheit(boolean farenheit) {
		this.farenheit = farenheit;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFavorites(ArrayList<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/** Returns user's email address
	 * @return email User's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/** Returns user's password
	 * @return password User's password
	 */
	public String getPassword() {
		return password;
	}

	/** Returns creation date
	 * @return createdOn User creation date
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	
	/** Returns list of Favorite objects
	 * @return favorites List of Favorite objects
	 */
	public ArrayList<Favorite> getFavorites() {
		return this.favorites;
	}
}
