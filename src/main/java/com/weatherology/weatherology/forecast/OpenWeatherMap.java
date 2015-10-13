package com.weatherology.weatherology.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class OpenWeatherMap {

    private static final String USER_AGENT = "Mozilla/5.0";
	private static final String API_KEY = "&APPID=e318f5b8fe8a644524f903407e54141a";
	private static final String URI = "http://api.openweathermap.org/data/2.5/forecast?zip=";
	private int zip;

	public OpenWeatherMap(int zip) {
		this.zip = zip;
		try {
			System.out.println(this.readUrl(URI+"33330"+API_KEY));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getTemperature() {
		return 0.0;
	}

	public double getHumidity() {
		return 0.0;
	}

	public String forecast() {
		String urlString = URI + zip + API_KEY;
		JsonObject jsonObject = null;

		try {
			jsonObject = new JsonParser().parse(this.readUrl(urlString)).getAsJsonObject();

			// Leave parse and strip to someone else lolololololol!
			// Parse and construct new JSON with city name, and temp, humidity, and icon for each day
			// Most likely have to compare with today's date
			// Todays forecast doesnt always the same entries as time has already elapsed

		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

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
