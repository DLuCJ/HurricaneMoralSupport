package weather;

import java.io.InputStream;

public class WeatherService {
	private Query q;
	
    public WeatherService(Query q) {this.q = q;}

    public String retrieveForecast( String zip ) throws Exception {
        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve( zip );

        // Parse Data
        Weather weather = new YahooParser(q).parse( dataIn );

        // Format (Print) Data
        return new WeatherFormatter().format( weather );
    }
}

