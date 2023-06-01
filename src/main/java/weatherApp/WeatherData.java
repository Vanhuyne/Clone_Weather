package weatherApp;

public class WeatherData {
	private int humidity;
    private double temperature;
    private String description;
    private String LocationName;
    private String LocationRegion;
    private String LocationCountry;
    private double LocationLatitude;
    private double LocationLongitude;
    private String LocationTimezone;
    private String icon;
    public WeatherData() {
		super();
	}
	public WeatherData(int humidity, double temperature, String description, String locationName, String locationRegion,
			String locationCountry, double locationLatitude, double locationLongitude, String locationTimezone,
			String icon) {
		super();
		this.humidity = humidity;
		this.temperature = temperature;
		this.description = description;
		LocationName = locationName;
		LocationRegion = locationRegion;
		LocationCountry = locationCountry;
		LocationLatitude = locationLatitude;
		LocationLongitude = locationLongitude;
		LocationTimezone = locationTimezone;
		this.icon = icon;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocationName() {
		return LocationName;
	}
	public void setLocationName(String locationName) {
		LocationName = locationName;
	}
	public String getLocationRegion() {
		return LocationRegion;
	}
	public void setLocationRegion(String locationRegion) {
		LocationRegion = locationRegion;
	}
	public String getLocationCountry() {
		return LocationCountry;
	}
	public void setLocationCountry(String locationCountry) {
		LocationCountry = locationCountry;
	}
	public double getLocationLatitude() {
		return LocationLatitude;
	}
	public void setLocationLatitude(double locationLatitude) {
		LocationLatitude = locationLatitude;
	}
	public double getLocationLongitude() {
		return LocationLongitude;
	}
	public void setLocationLongitude(double locationLongitude) {
		LocationLongitude = locationLongitude;
	}
	public String getLocationTimezone() {
		return LocationTimezone;
	}
	public void setLocationTimezone(String locationTimezone) {
		LocationTimezone = locationTimezone;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "WeatherData [humidity=" + humidity + ", temperature=" + temperature + ", description=" + description
				+ ", LocationName=" + LocationName + ", LocationRegion=" + LocationRegion + ", LocationCountry="
				+ LocationCountry + ", LocationLatitude=" + LocationLatitude + ", LocationLongitude="
				+ LocationLongitude + ", LocationTimezone=" + LocationTimezone + ", icon=" + icon + "]";
	}
    
	

    
}
