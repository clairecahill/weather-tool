package utils;

import apis.data.WeatherData;

public class Logger {

    /**************************************************
     * Prints to the console the weather data when there
     * is a valid API response
     * @param data - valid + parsed data in WeatherData object
     *************************************************/
    public static void printWeather(WeatherData data) {
        System.out.println("********************************************");
        System.out.println("Current weather for: " + data.cityName + ", " + data.sysObj.country);
        System.out.println(data.weatherObj.description);
        System.out.println("Current temp: " + data.mainObj.currTemp + "°F");
        System.out.println("Max: " + data.mainObj.maxTemp + "°F\tMin: " + data.mainObj.minTemp + "°F");
        System.out.println("********************************************");
    }

    /***************************************************
     * Prints to the console a specific error about the
     * invalid zip code user entry based on the type of error
     * @param error - type of error to specify which
     *              error message to display
     **************************************************/
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

    /*******************************************
     * Prints to the console when the API returns a
     * null response
     ******************************************/
    public static void printNullApiResponse() {
        System.out.println("API returned a null response");
    }

    /****************************************************************
     * Prints to the console the status code and error message returned
     * from the API when the API does not return with status 200
     * @param weatherData - WeatherData object to pull the code
     *                    and message from
     ***************************************************************/
    public static void printBadApiResponse(WeatherData weatherData) {
        System.out.println("API returned response code " + weatherData.responseCode +
                " with error message: " + weatherData.message);
    }
}
