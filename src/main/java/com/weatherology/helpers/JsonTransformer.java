package com.weatherology.helpers;

import com.google.gson.Gson;
import spark.Response;
import spark.ResponseTransformer;

import java.util.HashMap;

/** Json serializer
 * @author Musa V. Ahmed
 *
 */
public class JsonTransformer implements ResponseTransformer {

	/**
	 * Google gson instance
	 */
	private Gson gson = new Gson();
	
	/** Serializes Java object to Json
	 * @param Model Object to be serialized
	 * @return String of serialized object as Json
	 */
	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}
}
