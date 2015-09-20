package com.weatherology.weatherology.forecast;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OpenWeatherMap {
	
	private static final String API_KEY = "&APPID=e318f5b8fe8a644524f903407e54141a";
	private static final String URI = "api.openweathermap.org/data/2.5/forecast?zip=";
	private int zip;
	
	public OpenWeatherMap(int zip) {
		this.zip = zip;
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
		BufferedReader bufferedReader = null;
		
		try {
			URL url = new URL(urlString);
			bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer stringBuffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = bufferedReader.read(chars)) != -1)
				stringBuffer.append(chars, 0, read);
			
			return stringBuffer.toString();
		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}
	}
}