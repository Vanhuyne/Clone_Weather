function getWeather() {
  var city = document.getElementById("city").value;
  
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "WeatherServlet?city=" + encodeURIComponent(city), true);
  xhr.setRequestHeader("Content-Type", "application/json");
  
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var response = JSON.parse(xhr.responseText);
        if (response.error) {
          displayErrorMessage(response.error);
        } else {
          displayWeatherInfo(response);
        }
      } else {
        displayErrorMessage("Failed to fetch weather data.");
      }
    }
  };
  
  xhr.send();
}

function displayWeatherInfo(weatherData) {
  var temperatureElement = document.getElementById("temperature");
  var descriptionElement = document.getElementById("description");
  
  temperatureElement.textContent = weatherData.temperature + " °C";
  descriptionElement.textContent = weatherData.description;
}

function displayErrorMessage(message) {
  var errorMessageElement = document.getElementById("error-message");
  errorMessageElement.textContent = message;
}
