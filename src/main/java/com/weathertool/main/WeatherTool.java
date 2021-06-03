package com.weathertool.main;

import com.weathertool.apis.OpenWeather;
import java.util.*;
import java.util.regex.Pattern;

public class WeatherTool {
    public static void showWeather() {
        String zipCode = getZipCode();
        OpenWeather.getCurrentWeather(zipCode);
    }

    private static String getZipCode() {
        Scanner scanner = new Scanner(System.in);
        String zipCode;
        do {
            System.out.println("Enter a zipcode: ");
            zipCode = scanner.nextLine();
        } while(!isZipCodeValid(zipCode));
        return zipCode;
    }

    private static boolean isZipCodeValid(String zipCode) {
        if (!zipCode.matches("[0-9]+")) {
            return false;
        } else if (zipCode.length() != 5) {
            return false;
        }
//        int numZipCode = Integer.parseInt(zipCode);

        return true;
    }
}
