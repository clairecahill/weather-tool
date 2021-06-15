package main;

import apis.OpenWeather;
import utils.Logger;

import java.util.*;

public class WeatherTool {

    /*********************************
     * Gets a valid zip code then
     * sends it to the method which
     * calls the API
     ********************************/
    public static void showWeather() {
        String zipCode = getZipCode();
        OpenWeather.getCurrentWeather(zipCode);
    }

    /**********************************
     * Takes in user input and loops
     * until a valid zip code is found
     * @return - zip code / string of 5 digits
     **********************************/
    public static String getZipCode() {
        Scanner scanner = new Scanner(System.in);
        String zipCode;
        do {
            System.out.println("Enter a zipcode:");
            zipCode = scanner.nextLine();
        } while(!isZipCodeValid(zipCode));
        return zipCode;
    }

    /*************************************
     * Validates that a given string is only
     * numeric digits and length of 5
     * (API will validate that a zip code belongs
     * to a city)
     * @param zipCode - string to validate
     * @return - true if zip code is valid
     *************************************/
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
