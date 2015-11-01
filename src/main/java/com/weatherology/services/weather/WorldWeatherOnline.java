
package com.weatherology.services.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/** Retrieves weather forecast from World Weather Online API
 * @author Musa V. Ahmed
 */
public class WorldWeatherOnline {
	/** User agent */
	private static final String USER_AGENT = "Mozilla/5.0";
	/** API key */
	private static final String API_KEY = "key=99334933f069590cf60b6ab16002d&";
	/** API URI */
	private static final String URI = "http://api.worldweatheronline.com/free/v2/weather.ashx?num_of_days=1&";
	/** API request format */
	private static final String FORMAT = "format=json&q=";
	/** Five digit zip code */
	private int zip;
	/** Floating point representation of temperature */
	protected double temperature;
	/** Floating point representation of humidity */
	protected double humidity;

	/** Constructor for WorldWeatherOnline pulls forecast data from API and instantiates class
	 * @param zip Five digit zip code
	 */
	public WorldWeatherOnline(int zip) {
		this.zip = zip;

		String urlString = URI + API_KEY + FORMAT + zip;
		JsonObject jsonObject = null;

		try {
			jsonObject = new JsonParser().parse(this.readUrl(urlString)).getAsJsonObject();

			temperature = jsonObject.get("data").getAsJsonObject()
					                .get("current_condition").getAsJsonArray()
					                .get(0).getAsJsonObject()
					                .get("temp_F").getAsDouble();

			humidity = jsonObject.get("data").getAsJsonObject()
					             .get("current_condition").getAsJsonArray()
					             .get(0).getAsJsonObject()
					             .get("humidity").getAsDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Return temperature in fahrenheit
	 * @return temperature in fahrenheit
	 */
	public double getTemperatureFahrenheit() {
		return this.temperature;
	}
	
	/** Return temperature in celsius
	 * @return temperature in celsius
	 */
	public double getTemperatureCelsius() {
		return (this.temperature - 32) * (5/9.0);
	}

	/** Return humidity as a percentage
	 * @return humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/** Fetches API data from the web
	 * @param urlString URL for API
	 * @return API data as a string
	 * @throws Exception
	 */
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
