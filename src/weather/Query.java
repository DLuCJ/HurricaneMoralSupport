package weather;

public class Query {
	private String day;
	private String phone;
	private String hour;
	private String minute;
	private String daysBefore;
	
	
	public Query(String day, String phone, String hour, String minute, String daysBefore)
	{
		this.day = day;
		this.phone = phone;
		this.hour = hour;
		this.minute = minute;
		this.daysBefore = daysBefore;
	}
	
	public String getHour() {
		return hour;
	}
	
	public String getMinute() {
		return minute;
	}
	
	public String getDaysBefore() {
		return daysBefore;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String toString()
	{
		return "Day: "+getDay() + ", phone number: "+ getPhone() + ", hour: " + getHour() + ", minute: " + getMinute() + ", days before: " + getDaysBefore();
	}
}


