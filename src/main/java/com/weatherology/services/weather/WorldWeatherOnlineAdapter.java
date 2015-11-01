package com.weatherology.services.weather;

/** Wrapper class for WorldWeatherOnline
 * @author Musa V. Ahmed
 */
public class WorldWeatherOnlineAdapter extends WeatherProviderAdapter {

	/**  */
	private final static String name = "WorldWeatherOnline";
	/**  */
	private WorldWeatherOnline worldWeatherOnline;
	
	/** Constructor for WorldWeatherOnlineAdapter
	 * @param worldWeatherOnline Instance of WorldWeatherOnline
	 */
	public WorldWeatherOnlineAdapter(WorldWeatherOnline worldWeatherOnline) {
		this.worldWeatherOnline = worldWeatherOnline;
	}
	
	@Override
	public String getName() {
		return WorldWeatherOnlineAdapter.name;
	}

	@Override
	double getTemperatureFahrenheit() {
		return this.worldWeatherOnline.getTemperatureFahrenheit();
	}

	@Override
	double getTemperatureCelsius() {
		return this.worldWeatherOnline.getTemperatureCelsius();
	}

	@Override
	public double getHumidity() {
		return this.worldWeatherOnline.getHumidity();
	}
}
