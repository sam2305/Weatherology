
package com.weatherology.services.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

//http://api.worldweatheronline.com/free/v2/weather.ashx?num_of_days=1&key=99334933f069590cf60b6ab16002d&format=json&q=33147

public class WorldWeatherOnline {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String API_KEY = "key=99334933f069590cf60b6ab16002d&";
	private static final String URI = "http://api.worldweatheronline.com/free/v2/weather.ashx?num_of_days=1&";
	private static final String FORMAT = "format=json&q=";
	private int zip;
	private double temperature;
	private double humidity;

	public WorldWeatherOnline(int zip) {
		this.zip = zip;
		try {
			forecast();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getTemperature() {
		return temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public String forecast() {
		String urlString = URI + API_KEY + FORMAT + zip;
		JsonObject jsonObject = null;

		try {
			jsonObject = new JsonParser().parse(this.readUrl(urlString)).getAsJsonObject();
			temperature = jsonObject.get("data").getAsJsonObject().get("current_condition").getAsJsonArray().get(0).getAsJsonObject().get("temp_F").getAsDouble();
			humidity = jsonObject.get("data").getAsJsonObject().get("current_condition").getAsJsonArray().get(0).getAsJsonObject().get("humidity").getAsDouble();
			
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
}

	private String readUrl(String urlString) throws Exception {
        URL obj = new URL(urlString);
        HttpURLConnection httpConn = (HttpURLConnection) obj.openConnection();

        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = httpConn.getResponseCode();
        if (responseCode == 200) {
             BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

             String responseLine;
             StringBuffer response = new StringBuffer();

             while ((responseLine = responseReader.readLine()) != null) {
                 response.append(responseLine + "\n");
             }

             responseReader.close();

             return response.toString();
        }
        return null;
	}
}
