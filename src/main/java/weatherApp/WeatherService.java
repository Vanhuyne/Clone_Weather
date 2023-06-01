package weatherApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "d36c6df51a5941f6b00133730232605";
    private static final String API_URL = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=";

    public static WeatherData getWeatherData(String city) {
        try {
            // Gửi yêu cầu tới API thời tiết
            URL url = new URL(API_URL + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Đọc phản hồi từ API thời tiết
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Xử lý phản hồi JSON và trả về đối tượng WeatherData
            return parseWeatherData(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static WeatherData parseWeatherData(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject locationObject = jsonObject.getJSONObject("location");
            // Phân tích và trích xuất thông tin thời tiết từ jsonObject
            String name = locationObject.getString("name");
            String region = locationObject.getString("region");
            String country = locationObject.getString("country");
            double latitude = locationObject.getDouble("lat");
            double logitude = locationObject.getDouble("lon");
            String localtime = locationObject.getString("localtime");
            

            // Tạo đối tượng WeatherData và đặt giá trị cho các thuộc tính
            WeatherData weatherData = new WeatherData();
            double temperature = jsonObject.getJSONObject("current").getDouble("temp_c");
            int humidity = jsonObject.getJSONObject("current").getInt("humidity");
            String description = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
            String icon = jsonObject.getJSONObject("current").getJSONObject("condition").getString("icon");
            // Tạo đối tượng WeatherData và đặt giá trị cho các thuộc tính
            weatherData.setTemperature(temperature);
            weatherData.setHumidity(humidity);
            weatherData.setDescription(description);
            weatherData.setLocationName(name);
            weatherData.setLocationRegion(region);
            weatherData.setLocationCountry(country);
            weatherData.setLocationLatitude(latitude);
            weatherData.setLocationLongitude(logitude);
            weatherData.setLocationTimezone(localtime);
            weatherData.setIcon(icon);
            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    public static void main(String[] args) {
//    	        String city = "hanoi"; // Thay đổi thành tên thành phố bạn muốn lấy thông tin
//
//    	        // Gọi phương thức getWeatherData từ class WeatherService để lấy dữ liệu thời tiết
//    	        WeatherData weatherData = WeatherService.getWeatherData(city);
//
//    	        if (weatherData != null) {
//    	            String name = weatherData.getLocationName();
//    	            String region = weatherData.getLocationRegion();
//    	            String country = weatherData.getLocationCountry();
//    	            double latitude = weatherData.getLocationLatitude();
//    	            double longitude = weatherData.getLocationLongitude();
//    	            String timezone = weatherData.getLocationTimezone();
//
//    	            // In thông tin lấy được
//    	            System.out.println("Name: " + name);
//    	            System.out.println("Region: " + region);
//    	            System.out.println("Country: " + country);
//    	            System.out.println("Latitude: " + latitude);
//    	            System.out.println("Longitude: " + longitude);
//    	            System.out.println("Timezone: " + timezone);
//    	        } else {
//    	            System.out.println("Không thể lấy thông tin thời tiết cho thành phố " + city);
//    	        }
//    	    }
  	}

