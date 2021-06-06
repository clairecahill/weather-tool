# weather-tool

## Description
<br/>
This is a simple tool that allows users to enter a valid zip code and returns information about the current weather conditions in that city. Upon entering a valid zip code (5 numeric digits in the US region), these results are displayed back to the user.
<br/> 
<br/>
This is a Java project using Maven. It utilizes OkHttp for REST API operations, Jackson for data parsing, and jUnit for testing. There are currently three sections for the source code (not including tests) - main, apis, and utils.
<br/>
--The main class within Main.java calls the method WeatherTool.showWeather(). This method is the driver of the application. This WeatherTool class is responsible for gathering a valid zip code (looping until a valid input is received), then sending that zip code to the OpenWeather class to call the API.
<br/>
--The apis package includes the OpenWeather class, which includes getCurrentWeather(), a method responsible for calling the Open Weather Map API and getting the current weather based on zip code. It reads an API key located in config.properties, then uses OkHttp to get the API results. Within apis, there is a sub-package called data, which stores data objects. Currently, it holds a single class called WeatherData, which holds the fields to be stored after calling the current weather API in Open Weather Map. getCurrentWeather() parses the results, stores them in a WeatherData object, then returns messages back to the user based on the response code.
<br/>
--The final package, utils, holds a class FileUtils, which has a method to return the API key in config.properties. Logger is a class to print messages to the console.
<br/>
<br/>

## How to run
<br/>

Clone the project with git clone https://github.com/clairecahill/weather-tool.git
<br/>

### Prerequisites 
* Install Java on your local machine [Windows download](https://java.com/en/download/)
* Install Maven on your local machine [Download](https://maven.apache.org/download.cgi)
  * Follow instructions on the README to complete the install
  * Run 'mvn -version' to confirm a successful install. The Maven version should print, in addition to the Java version

### IntelliJ
* Load the project in IntelliJ
* On the left hand project navigator, open src/main/weathertool/main, right click on Main.java, select "Run Main.main()"
* To run the unit tests, right click on the src/test folder and click "Run All Tests"

### Command line
* Navigate to the location of the project root directory (weather-tools)
* To run source code
  *  mvn compile
  * mvn exec:java -Dexec.mainClass=main.Main
* To run tests 
  * mvn clean test
