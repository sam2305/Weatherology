package com.weatherology.weatherology;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class User {

	private String id;
	private String email;
	private boolean done;
	private Date createdOn = new Date();
	
	public User(BasicDBObject dbObject) {
		this.id = ((ObjectId) dbObject.get("_id")).toString();
		this.email = dbObject.getString("email");
		this.done = dbObject.getBoolean("done");
		this.createdOn = dbObject.getDate("createdOn");
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
}
