package com.weathertool.apis.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    public String cityName;
    public weather weatherObj;
    public main mainObj;
    public sys sysObj;
    public String responseCode;
    public String message;

    public static class weather {
        public String description;
    }

    public static class main {
        @JsonProperty("temp")
        public int currTemp;
        @JsonProperty("temp_min")
        public int minTemp;
        @JsonProperty("temp_max")
        public int maxTemp;
    }

    public static class sys {
        public String country;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public WeatherData(@JsonProperty("name") String cityName,
                       @JsonProperty("weather") weather[] weatherArr,
                       @JsonProperty("main") main mainObj,
                       @JsonProperty("sys") sys sysObj,
                       @JsonProperty("cod") String responseCode,
                       @JsonProperty("message") String message) {
        this.cityName = cityName;
        this.weatherObj = (weatherArr == null ? null : weatherArr[0]);
        this.mainObj = mainObj;
        this.sysObj = sysObj;
        this.responseCode = responseCode;
        this.message = message;
    }
}
