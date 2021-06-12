# Movie by Weather
Just type in your zip code and country and the app will find the weather for your location and suggest you a suitable movie.
## Installation
1. $ git clone https://github.com/nick2202/movie-by-weather.git
2. create file "src/main/resources/api.properties" and put in your API keys for [OpenWeatherMap](https://openweathermap.org/) and [TheMovieDB](https://www.themoviedb.org/):
   OPEN_WEATHER_MAP_API_KEY = {your API key}
   THE_MOVIE_DB_API_KEY = {your API key}
3. $ mvn package
4. $ mvn spring-boot:run
5. http://localhost:8080