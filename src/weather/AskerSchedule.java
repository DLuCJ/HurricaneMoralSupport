package weather;

import java.util.Calendar;
import java.util.Timer;

public class AskerSchedule implements Runnable {
	private Query q;

	public AskerSchedule(Query q) {
		this.q = q;
	}
	
	public void run() {
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(
			Calendar.DAY_OF_WEEK,
			getTime(q.getDay(), q.getDaysBefore())
			);
		date.set(Calendar.HOUR, Integer.parseInt(q.getHour()));
	    date.set(Calendar.MINUTE, Integer.parseInt(q.getMinute()));
	    date.set(Calendar.SECOND, 0);
	    timer.schedule(
	    	new Texter(q),
	    	date.getTime(),
	    	1000 * 60 * 60 * 24 * 7
	    	);
	}
	
	private static int getTime(String day, String daysBefore) {
		String cal[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		Integer upDayte = Integer.valueOf(daysBefore);
		
		int pos = 0;
		for(int i = 0; i < cal.length; i++) {
			if(day.equals(cal[i])) {
				
				pos = i - upDayte;
				if(pos < 0) {
					pos += 7;
				}
			}
		}
		
		pos++;
		return pos;
	}
	
}
