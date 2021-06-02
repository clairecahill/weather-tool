# weather-tool

Design:
- Get zipcode (+ verify valid)
- Get API data
- Parse API data
- Display API data

Classes/methods:
- Main (Calls WeatherTool methods)
- WeatherTool (ShowWeather)
- UserData (GetData, ValidateData)
- APIData (GetData, ParseData)
- Constants
- ErrorMessage

Unit tests:
1. Valid data displays valid results
2. Invalid zip code inputs
3. Valid zip code input but invalid results shows API error