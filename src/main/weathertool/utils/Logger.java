package com.weathertool.utils;

import com.weathertool.apis.data.WeatherData;

public class Logger {
    public static void printWeather(WeatherData data) {
        System.out.println("********************************************");
        System.out.println("Current weather for: " + data.cityName + ", " + data.sysObj.country);
        System.out.println(data.weatherObj.description);
        System.out.println("Current temp: " + data.mainObj.currTemp + "°F");
        System.out.println("Max: " + data.mainObj.maxTemp + "°F\tMin: " + data.mainObj.minTemp + "°F");
        System.out.println("********************************************");
    }

    public static void printZipCodeError(String error) {
        switch (error) {
            case "non-numeric":
                System.out.println("Zip code must contain numeric values only.");
                break;
            case "length":
                System.out.println("Zip code must be 5 digits.");
                break;
            default:
                System.out.println("Please enter a valid zip code.");
        }
    }

    public static void printNullApiResponse() {
        System.out.println("API returned a null response");
    }

    public static void printBadApiResponse(WeatherData weatherData) {
        System.out.println("API returned response code " + weatherData.responseCode + " with " +
                "error message: " + weatherData.message);
    }
}
