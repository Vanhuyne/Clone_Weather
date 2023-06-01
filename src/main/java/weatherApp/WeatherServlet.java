package weatherApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");

        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.getWeatherData(city);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (weatherData != null) {
            // Truyền thông tin vị trí vào thuộc tính của đối tượng request
            request.setAttribute("name", weatherData.getLocationName());
            request.setAttribute("region", weatherData.getLocationRegion());
            request.setAttribute("country", weatherData.getLocationCountry());
            request.setAttribute("latitude", weatherData.getLocationLatitude());
            request.setAttribute("longitude", weatherData.getLocationLongitude());
            request.setAttribute("localtime", weatherData.getLocationTimezone());
            request.setAttribute("temperature", weatherData.getTemperature());
            request.setAttribute("description", weatherData.getDescription());
            request.setAttribute("icon", weatherData.getIcon());
            // Chuyển hướng đến trang weather.jsp để hiển thị thông tin
            RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("weather.jsp");
            dispatcher.forward(request, response);
        } else {
            out.print("<html><body>");
            out.print("<p>Failed to fetch weather data.</p>");
            out.print("</body></html>");
        }
        out.flush();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
