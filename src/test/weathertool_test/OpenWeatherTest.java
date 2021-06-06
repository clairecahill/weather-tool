package weathertool_test;

import apis.OpenWeather;
import apis.data.WeatherData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenWeatherTest {

    @Test
    public void shouldReturnValidResults() {
        WeatherData weatherData = OpenWeather.getCurrentWeather("97330");
        assert weatherData != null;
        Assertions.assertEquals("200", weatherData.responseCode);
        Assertions.assertEquals("Corvallis", weatherData.cityName);
        Assertions.assertEquals("US", weatherData.sysObj.country);
        Assertions.assertEquals("java.lang.String", weatherData.weatherObj.description.getClass().getName());
        Assertions.assertEquals("java.lang.Integer", Integer.valueOf(weatherData.mainObj.currTemp).getClass().getName());
        Assertions.assertEquals("java.lang.Integer", Integer.valueOf(weatherData.mainObj.minTemp).getClass().getName());
        Assertions.assertEquals("java.lang.Integer", Integer.valueOf(weatherData.mainObj.maxTemp).getClass().getName());
        Assertions.assertNull(weatherData.message);
    }

    @Test
    public void shouldReturnCityNotFound() {
        WeatherData weatherData = OpenWeather.getCurrentWeather(null);
        assert weatherData != null;
        Assertions.assertEquals("404", weatherData.responseCode);
        Assertions.assertEquals("city not found", weatherData.message);
        Assertions.assertNull(weatherData.cityName);
        Assertions.assertNull(weatherData.sysObj);
        Assertions.assertNull(weatherData.weatherObj);
        Assertions.assertNull(weatherData.mainObj);

        weatherData = OpenWeather.getCurrentWeather("00000");
        assert weatherData != null;
        Assertions.assertEquals("404", weatherData.responseCode);
        Assertions.assertEquals("city not found", weatherData.message);
        Assertions.assertNull(weatherData.cityName);
        Assertions.assertNull(weatherData.sysObj);
        Assertions.assertNull(weatherData.weatherObj);
        Assertions.assertNull(weatherData.mainObj);

        weatherData = OpenWeather.getCurrentWeather("00");
        assert weatherData != null;
        Assertions.assertEquals("404", weatherData.responseCode);
        Assertions.assertEquals("city not found", weatherData.message);
        Assertions.assertNull(weatherData.cityName);
        Assertions.assertNull(weatherData.sysObj);
        Assertions.assertNull(weatherData.weatherObj);
        Assertions.assertNull(weatherData.mainObj);
    }

    @Test
    public void shouldReturnInvalidZipCode() {
        WeatherData weatherData = OpenWeather.getCurrentWeather("");
        assert weatherData != null;
        Assertions.assertEquals("400", weatherData.responseCode);
        Assertions.assertEquals("invalid zip code", weatherData.message);
        Assertions.assertNull(weatherData.cityName);
        Assertions.assertNull(weatherData.sysObj);
        Assertions.assertNull(weatherData.weatherObj);
        Assertions.assertNull(weatherData.mainObj);

        weatherData = OpenWeather.getCurrentWeather(" ");
        assert weatherData != null;
        Assertions.assertEquals("400", weatherData.responseCode);
        Assertions.assertEquals("invalid zip code", weatherData.message);
        Assertions.assertNull(weatherData.cityName);
        Assertions.assertNull(weatherData.sysObj);
        Assertions.assertNull(weatherData.weatherObj);
        Assertions.assertNull(weatherData.mainObj);
    }
}
