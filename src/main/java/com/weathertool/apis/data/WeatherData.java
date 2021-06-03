package com.weathertool.apis.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    public String cityName;
    public weather weatherObj;
    public main mainObj;
    public sys sysObj;

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

    public WeatherData(@JsonProperty("name") String cityName,
                       @JsonProperty("weather") weather[] weatherArr,
                       @JsonProperty("main") main mainObj,
                       @JsonProperty("sys") sys sysObj) {
        this.cityName = cityName;
        this.weatherObj = weatherArr[0];
        this.mainObj = mainObj;
        this.sysObj = sysObj;
    }
}
