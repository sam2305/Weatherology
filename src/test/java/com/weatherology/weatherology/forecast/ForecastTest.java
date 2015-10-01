import com.weatherology.weatherology.forecast.Forecast;

import static org.junit.Assert.*;
import org.junit.Test;

public class ForecastTest {

    @Test
    public void forecastTest() {
        Forecast forecast = new Forecast("WeatherProvider", 273.15, 90.0);

        assertTrue(true);
    }
}
