package weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class YahooRetriever {

    public InputStream retrieve(String zipcode) throws Exception {
    	
    	FileLogger fl = new FileLogger();
		fl.logFile("Retrieving Weather Data");
		
        String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode + "&u=f&d=7";
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
