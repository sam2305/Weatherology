package com.weatherology.services.users;

//import com.google.gson.Gson;
import com.mongodb.*;

import com.google.gson.*;
import java.util.ArrayList;
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
	public User createNewUser(String body) {		
		String userBody[] = body.split(",");
		String username = userBody[0].split(":")[1].replace("\"", "");
		
		if(userEmailExists(body) != null)
			return new User();
		
		String password = userBody[1].split(":")[1].replace("\"", "").replace("}", "");		

		User user = new User(new BasicDBObject("email",username).append("password", password).append("createdOn", new Date()));
		
		collection.insert(new BasicDBObject("email", user.getEmail()).append("password", user.getPassword())
				.append("createdOn", user.getCreatedOn()).append("farenheit", true)
				.append("favorites", user.getFavorites()));
		
		return user;
	}
	
	public User userEmailExists(String body) {
		String userBody[] = body.split(",");
		String username = userBody[0].split(":")[1].replace("\"", "");

		BasicDBObject object = (BasicDBObject) collection.findOne(new BasicDBObject("email", username));
		
		if(object != null)
			return new User(object);
		else
			return null;
	}
	
	/** Finds and returns user object from db
	 * @param id User id
	 * @return user User object
	 */
	public User find(String body) {

		User user = userEmailExists(body);
		if(user != null) {
			String userBody[] = body.split(",");
			String password = userBody[1].split(":")[1].replace("\"", "").replace("}", "");

			String passDB = user.getPassword();
			if(passDB.equals(password)) {
				return user;
			}
		}
		return new User();
	}
		
	public User deleteUser(String email) {
		collection.remove(new BasicDBObject("email", email));
		
		return new User();
	}
	
	/** Updates user information in db
	 * @param userId User id
	 * @param body serialized user object
	 * @return user User object
	 */
	public User update(String body) {
		UserResponse user = new Gson().fromJson(body, UserResponse.class);
	    		
		BasicDBObject object = (BasicDBObject) collection.findOne(new BasicDBObject("email", user.email));
			
		if(object != null) {
			object.put("farenheit", user.tempUnit);
			
			BasicDBList favDBList = new BasicDBList();
		
			while(!user.favorites.isEmpty()) {
				Favorite temp = user.favorites.remove(0);
				favDBList.add(new BasicDBObject("name",temp.getName()).append("zip", temp.getZip()));
			}
			
			object.put("favorites", favDBList);

			collection.update(new BasicDBObject("email", user.email), object) ;
			return new User(object);
		}
		else {
			System.out.println("Oops, updating user that does not exist");
			return new User();
		}
	}
	
	class UserResponse {
		String email;
		boolean tempUnit;
		ArrayList<Favorite> favorites;
	}
}
