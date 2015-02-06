package weather;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Date;

import com.techventus.server.voice.Voice;

public class Texter extends TimerTask{
	private final static int DELAY = 5000;
	private static Voice voice = null;
	private static long lastSent = 0;
	private Query query;
	
	public Texter(Query q) {
		this.query = q;
	}
	
	public static Voice getLogin()
	{
		if(voice != null)
			return voice;
		try {

			Voice voice = new Voice("placeholder", "placeholder");
			return voice;
		}
		catch (IOException e) {
			System.out.println("Error logging into Google Voice. Exiting.");
			System.exit(1);
		}
		return null;
	}
	
	public void run() {

		WeatherService info = new WeatherService(query);
		String toSend = "";

		try {
			toSend = info.retrieveForecast("98663");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("\nWeather information for given day: \n" + toSend + "Sent to: " + query.getPhone() + "\n");
		Voice voice = getLogin();
		try {
			long now;
			while((now = new Date().getTime()) < lastSent + DELAY);
			lastSent = now;
			voice.sendSMS(query.getPhone(), toSend);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
