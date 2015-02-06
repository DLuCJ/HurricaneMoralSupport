package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ClarkWeather {
	public static void main(String[] args) throws Exception {
        
        Query[] qlist = init();
        		
        System.out.println("Queries found:");
        
        for(Query q:qlist) {
        	System.out.println("\t" +q);
        	new Thread(new AskerSchedule(q)).start();
        	
        }
    }
	
public static Query[] init() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("Please enter your phone number without spaces or dashes: ");
        String num = reader.readLine();
        System.out.println();
        
        System.out.println("Please enter your class days this week, each separated by a space.");
        System.out.println("Format example: Mon Tue Wed Thu Fri Sat Sun");
        System.out.printf("Enter: ");
        String data = reader.readLine();
        data = data.replaceAll("[^A-Za-z]", " ");
        System.out.println();
        
        System.out.println("Please enter the number of days in advance you'd like to be notified of the weather.");
        System.out.println("For example, if you'd like to be notified about Tuesday's weather on Monday, enter in:  1  ");
        System.out.printf("Enter: ");
        String daysBefore = reader.readLine();
        System.out.println();
       
        System.out.println("Please enter what time you want to be notified, separating hours and minutes with a comma");
        System.out.println("Format example:  4,30  for 4:30 am or  4,0  for 4:00 am ");
        System.out.printf("Enter: ");
        String time = reader.readLine();
        System.out.println();
        
        Scanner dataScan = new Scanner(data);
        String[] times = time.split(",");
        
        LinkedList<Query> queries = new LinkedList<Query>();
        
        while(dataScan.hasNext()) {
        	String day = dataScan.next();
       
        	Query newQuery = new Query(day, num, times[0], times[1], daysBefore);
        	queries.add(newQuery);
        }
      
        scan.close();
        dataScan.close();
        
        return (Query[]) queries.toArray(new Query[queries.size()]);
	}
}
