package main;

import apis.OpenWeather;
import utils.Logger;

import java.util.*;

public class WeatherTool {
    public static void showWeather() {
        String zipCode = getZipCode();
        OpenWeather.getCurrentWeather(zipCode);
    }

    public static String getZipCode() {
        Scanner scanner = new Scanner(System.in);
        String zipCode;
        do {
            System.out.println("Enter a zipcode:");
            zipCode = scanner.nextLine();
        } while(!isZipCodeValid(zipCode));
        return zipCode;
    }

    private static boolean isZipCodeValid(String zipCode) {
        if (!zipCode.matches("[0-9]+")) {
            Logger.printZipCodeError("non-numeric");
            return false;
        } else if (zipCode.length() != 5) {
            Logger.printZipCodeError("length");
            return false;
        }
        return true;
    }
}
