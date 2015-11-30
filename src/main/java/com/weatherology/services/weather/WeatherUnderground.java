package com.weatherology.services.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/** Retrieves weather forecast from Weather Underground API
 * @author Musa V. Ahmed
 */
public class WeatherUnderground {
	/** User agent */
	private static final String USER_AGENT = "Mozilla/5.0";
	/** API key */
	private static final String API_KEY = "api/3550b87a0edf2033/conditions/q/";
	/** API URI */
	private static final String URI = "http://api.wunderground.com/";
	/** Five digit zip code */
	private int zip;
	/** Floating point representation of temperature */
	private double temperature;
	/** Floating point representation of humidity */
	private double humidity;

	/** Constructor for WeatherUndeground 
	 * pulls forecast data from API and instantiates class
	 * @param zip Five digit zip code
	 */
	public WeatherUnderground(int zip) {
		this.zip = zip;
		String urlString = URI + API_KEY + zip + ".json";
		try {
			JsonObject jsonObject = new JsonParser().parse(this.readUrl(urlString)).getAsJsonObject();
			
			this.temperature = jsonObject.get("current_observation").getAsJsonObject()
					                     .get("temp_f").getAsDouble();// + 273.15;
			String stringHumidity = jsonObject.get("current_observation").getAsJsonObject()
					                          .get("relative_humidity").getAsString();
			this.humidity = Double.parseDouble(stringHumidity.substring(0, stringHumidity.length()-1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Return temperature in fahrenheit
	 * @return temperature in fahrenheit
	 */
	public double getTemperatureFahrenheit() {
		//return (this.temperature * (9/5) - 459.67);
		return this.temperature;
	}
	
	/** Return temperature in celsius
	 * @return temperature in celsius
	 */
	public double getTemperatureCelsius() {
		return (this.temperature - 273.15);
	}

	/** Return humidity as a percentage
	 * @return humidity
	 */
	public double getHumidity() {
		return this.humidity;
	}

	/** Fetches API data from the web
	 * @param urlString URL for API
	 * @return API data as a string
	 * @throws Exception
	 */
	private static String readUrl(String urlString) throws Exception {
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
