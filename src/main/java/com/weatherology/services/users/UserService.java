package com.weatherology.services.users;

import com.google.gson.Gson;
import com.mongodb.*;

import org.bson.types.ObjectId;

import java.util.Date;

/** Provides main functionality for user
 * @author Musa V. Ahmed
 */
public class UserService {
	/** DB instance */
	private final DB db;
	/** DB collection */
	private final DBCollection collection;
	
	/** Constructor for UserService
	 * @param db
	 */
	public UserService(DB db) {
		this.db = db;
		this.collection = db.getCollection("users");
	}
	
	/** Creates a new user object and stores it
	 * @param body serialized user object
	 */
	public void createNewUser(String body) {
		User user = new Gson().fromJson(body, User.class);
		
		collection.insert(new BasicDBObject("email", user.getEmail()).append("createdOn", new Date()));
	}
	
	/** Finds and returns user object from db
	 * @param id User id
	 * @return user User object
	 */
	public User find(String id) {
		return new User((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
	}
	
	/** Updates user information in db
	 * @param userId User id
	 * @param body serialized user object
	 * @return user User object
	 */
	public User update(String userId, String body) {
		User user = new Gson().fromJson(body, User.class);
		
		//fix update e.g., update respect fields
		//collection.update(new BasicDBObject("_id", new ObjectId(userId)), new BasicDBObject("$set", new BasicDBObject("done", user.isDone())));
		
		return this.find(userId);
	}
}
