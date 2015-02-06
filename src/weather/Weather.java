package weather;

public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String highTemp;
    private String lowTemp;
    private String day;

    public Weather() {}

    public String getCity() { return city; } 
    public void setCity(String city) { this.city = city; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getHighTemp() { return highTemp; }
    public void setHighTemp(String highTemp) { this.highTemp = highTemp; }
    
    public String getLowTemp() { return lowTemp; }
    public void setLowTemp(String lowTemp) { this.lowTemp = lowTemp; }
    
    public String getDay() {return day; }
    public void setDay(String day) {this.day = day; }

}
