package apis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import apis.data.WeatherData;

import utils.FileUtils;
import utils.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeather {
    private static final ObjectMapper mapper = new ObjectMapper();

    /***********************************************************
     * Calls the OpenWeatherMap Current Weather API with the validated
     * zip code. Uses OkHTTP to make the API call and Jackson to
     * parse the data into a custom WeatherData object
     * TODO: expand API to work with zip codes outside the US
     * @param zipCode - 5 digit zip code from WeatherTool class
     * @return - WeatherData object with data from the API call
     ***********************************************************/
    public static WeatherData getCurrentWeather(String zipCode) {
        String apiKey = FileUtils.getApiKey();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?" +
                        "zip=" + zipCode + ",us" +
                        "&units=imperial&appid=" + apiKey)
                .build();
        try {
            Response response = client.newCall(request).execute();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

            if (response.body() == null) {
                Logger.printNullApiResponse();
            }
            else {
                WeatherData weatherData = mapper.readValue(response.body().byteStream(), WeatherData.class);
                if (weatherData.responseCode.equals("200")) {
                    Logger.printWeather(weatherData);
                } else {
                    Logger.printBadApiResponse(weatherData);
                }
                return weatherData;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
