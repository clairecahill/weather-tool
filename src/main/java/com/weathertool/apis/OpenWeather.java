package com.weathertool.apis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import com.weathertool.apis.data.WeatherData;

import com.weathertool.utils.FileUtils;
import com.weathertool.utils.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeather {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void getCurrentWeather(String zipcode) {
        String apiKey = FileUtils.getApiKey();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?" +
                        "zip=" + zipcode + ",us" +
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
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
