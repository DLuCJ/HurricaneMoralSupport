package weather;

import java.util.Map;
import java.util.TreeMap;

public class WeatherFormatter {

	public String format(Weather weather) throws Exception {
	
		FileLogger fl = new FileLogger();
		fl.logFile("Formatting Weather Data");
	
		StringBuilder builder = new StringBuilder();
		builder.append("*********************************\n")
				.append("Weather for class on: " + weather.getDay() + "\n")
				.append(weather.getCity() + " " + weather.getRegion() + " "
						+ weather.getCountry() + "\n\n")
				.append("High temperature: " + weather.getHighTemp() + "\n")
				.append("Low temperature: " + weather.getLowTemp() + "\n")
				.append("Condition: " + weather.getCondition() + "\n")
				.append("\n" + message(weather))
				.append("*********************************\n");

		return builder.toString();
	}
	
	private String message(Weather weather) {
		Map<String,String> message = new TreeMap<String,String>(); 
		message.put("Showers", "Hello friend, consider bringing an umbrella!\n");
		message.put("Snow", "Careful driving!\n");
		message.put("Heavy Snow", "Stay inside young man (woman)\n");
		message.put("Drizzle", "Bring an umbrella if you're not feeling brave today!\n");
		message.put("Windy", "Bring a scarf!\n");
		message.put("Foggy", "Careful driving!\n");
		message.put("Isolated Thunderstorms", "Hello friend, consider bringing an umbrella!\n");
		message.put("Scattered Thunderstorms", "Hello friend, consider bringing an umbrella!\n");
		message.put("Scattered Showers", "Hello friend, consider bringing an umbrella!\n");
		message.put("Hurricane", "Don't die!\n");
		message.put("Freezing Rain", "Hello friend, consider bringing an umbrella!\n");
		message.put("Thunderstorms", "Hello friend, consider bringing an umbrella!\n");
		message.put("Severe Thunderstorms", "Hello friend, consider bringing an umbrella!\n");
		message.put("Mixed Rain And Snow", "Hello friend, consider bringing an umbrella!\n");
		message.put("Mixed Rain And Sleet", "Hello friend, consider bringing an umbrella!\n");
		message.put("Rain", "Hello friend, consider bringing an umbrella!\n");
		message.put("Mixed Snow And Sleet", "Hello friend, consider bringing an umbrella!\n");
		String warning = message.get(weather.getCondition());
		
		String addendum = "\n";
		if(warning == null) {
			warning = "Have a nice day!  ";
		} 
		
		if(Integer.valueOf(weather.getHighTemp()) <= 50) {
			addendum = "Dress warmly! \n";
		} 
		return warning + addendum;
	}
}
