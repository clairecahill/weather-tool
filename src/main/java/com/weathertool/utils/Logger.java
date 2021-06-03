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

    public static void printZipCodeError() {
        System.out.println("");
    }
}
