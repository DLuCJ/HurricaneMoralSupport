package weather;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
	
	private static Logger log = Logger.getLogger("clarkWeather");
	private static FileHandler fh;
	
	public void logFile(String message) {
		log.setUseParentHandlers(false);
		try {
			fh = new FileHandler(
					"C:\\Users\\daniel.lu\\Desktop\\CSE\\Clark\\ClarkWeather\\logs\\LogFile.log");
			log.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info(message);
	}
}
