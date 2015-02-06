package weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {
	private Query q;
	private String day;
	private static String daysBefore;
	
	public YahooParser(Query q) {
		this.q = q;
		day = q.getDay();
		daysBefore = q.getDaysBefore();
	}

    public Weather parse(InputStream inputStream) throws Exception {
        Weather weather = new Weather();
        
        FileLogger fl = new FileLogger();
		fl.logFile("Creating XML Reader");
  
        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read( inputStream );

        fl.logFile("Parsing XML Response");
        
        weather.setCity( doc.valueOf("/rss/channel/y:location/@city") );
        weather.setRegion( doc.valueOf("/rss/channel/y:location/@region") );
        weather.setCountry( doc.valueOf("/rss/channel/y:location/@country") );
        weather.setCondition( doc.valueOf("/rss/channel/item/y:forecast["+ getTime() + "]/@text") );
        weather.setHighTemp( doc.valueOf("/rss/channel/item/y:forecast["+ getTime() + "]/@high") );
        weather.setLowTemp( doc.valueOf("/rss/channel/item/y:forecast["+ getTime() + "]/@low") );
        weather.setDay(day);

        return weather;
    }
    
    private static String getTime() {
		
		Integer upDayte = Integer.valueOf(daysBefore);
		upDayte++;
		
		String index = String.valueOf(upDayte);
		return index;
	}
    
    private SAXReader createXmlReader() {
        Map<String,String> uris = new HashMap<String,String>();
        uris.put( "y", "http://xml.weather.yahoo.com/ns/rss/1.0" );

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs( uris );

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory( factory );
        return xmlReader;
    }
}