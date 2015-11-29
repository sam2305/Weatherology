package com.weatherology.resources;

import com.weatherology.helpers.JsonTransformer;
import com.weatherology.services.users.UserService;

import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

/** Exposes REST endpoints for user services
 * @author Musa V. Ahmed
 */
public class UserResource {
	/** API context */
	private static final String API_CONTEXT = "/api/v1";
	/** UserService instance */
	private final UserService userService;
	
	/** Constructor for UserSerivce receives UserServicer and exposes endpoints
	 * @param userService
	 */
	public UserResource(UserService userService) {
		this.userService = userService;
		setupEndpoints();
	}
	
	/** Exposes REST endpoints, calls necessary service, serializes to Json
	 */
	private void setupEndpoints() {
		post(API_CONTEXT + "/users", "application/json", (request, response) -> {
			//response.status(201);
			return userService.createNewUser(request.body());
		}, new JsonTransformer());
		
		post(API_CONTEXT + "/login", "application/json", (request, response) -> {
			//response.status(201);
			return userService.find(request.body());
		}, new JsonTransformer());
		
		put(API_CONTEXT + "/users", "application/json", (request, response)
				-> userService.update(request.body()), new JsonTransformer());
		
		delete(API_CONTEXT + "/users/:email", "application/json",  (request, response)
				-> userService.deleteUser(request.params(":email")), new JsonTransformer());

	}
}
