<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String url = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
 <link rel="stylesheet" href="<%=url%>/styles.css">
 <style>
	.button{
	  padding : 8px
	}
	.button:hover{
	  cursor: pointer;
	  background-color: #008CBA;
	  color: white;
	  transition-duration: 0.4s;
	  border-color: #008CBA;
	}
	</style>
<title>Weather</title>
</head>
<body>

	<div class="container">
    <h1>Weather App</h1>
    
    <form class="search-form" action="<%=url%>/WeatherServlet" method="GET">
      <input type="text" name="city" class="search-input" placeholder="Enter a Country">
      <button class="button" type="submit">Search</button>
    </form>
    
    <div class="weather-info">
      <img id="weather-icon" class="weather-icon" src="${icon}" alt="Weather Icon">
      <div id="temperature" class="temperature">${temperature} °C</div>
      <div id="description" class="description">${description}</div>
      
      <div id="location" class="location">
        <h2>Location Information</h2>
        <p>Name: ${name}</p>
        <p>Region: ${region}</p>
        <p>Country: ${country}</p>
        <p>Latitude: ${latitude}</p>
        <p>Longitude: ${longitude}</p>
        <p>LocalTime: ${localtime}</p>
      </div>
    </div>
    
    <div id="error-message" class="error-message">${error}</div>
</div>
	
</body>
</html>