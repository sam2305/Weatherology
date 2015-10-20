package com.weatherology.services.users;

import com.google.gson.Gson;
import com.mongodb.*;

import org.bson.types.ObjectId;

import java.util.Date;

public class UserService {
	private final DB db;
	private final DBCollection collection;
	
	public UserService(DB db) {
		this.db = db;
		this.collection = db.getCollection("users");
	}
	
	public void createNewUser(String body) {
		User user = new Gson().fromJson(body, User.class);
		
		collection.insert(new BasicDBObject("email", user.getEmail()).append("done", user.isDone()).append("createdOn", new Date()));
	}
	
	public User find(String id) {
		return new User((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
	}
	
	public User update(String userId, String body) {
		User user = new Gson().fromJson(body, User.class);
		
		collection.update(new BasicDBObject("_id", new ObjectId(userId)), new BasicDBObject("$set", new BasicDBObject("done", user.isDone())));
		
		return this.find(userId);
	}
}
