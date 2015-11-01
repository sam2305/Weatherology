package com.weatherology.services.users;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.ArrayList;

/** User class that holds all the user information
 * @author Musa V. Ahmed
 */
public class User {

	/** Unique ID */
	private String id;
	/** User email */
	private String email;
	/** Creation date */
	private Date createdOn = new Date();
	/** List of Favorite objects */
	private ArrayList<Favorite> favorites;
	
	/** Constructor for User
	 * @param dbObject Equivalent DB object
	 */
	public User(BasicDBObject dbObject) {
		this.id = ((ObjectId) dbObject.get("_id")).toString();
		this.email = dbObject.getString("email");
		this.createdOn = dbObject.getDate("createdOn");
		this.favorites = new ArrayList<Favorite>();
	}
	
	/** Returns user's email address
	 * @return email User's email address
	 */
	public String getEmail() {
		return email;
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
