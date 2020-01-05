package Weather.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataWeather {
	
	private static int count;
	private Document page;
	
	public DataWeather() throws MalformedURLException, IOException {
		page =	getPage(); 
		
	}

	public String[][] getData() {
		
		
		
		 Element tableWth = page.select("table[class=zebra fw tb-wt zebra va-m]").first();
	        
	        Elements citys = tableWth.select("a");
	     
	        Elements date = tableWth.select("td[class=r]");
	                          
	        Elements temperatura = tableWth.select("td[class=rbi]");
	        //count = 0;
	      //  System.out.println(date.get(count).text());
	       // System.out.println("City                  Temperatura");
	        
	        String[][] data = new String[citys.size()][2];
	        
	        for(int i = 0; i < citys.size();i++)
	        {
	        	
	        	data[i][0] = citys.get(i).text();
	        	data[i][1] = temperatura.get(i).text();
	          	//System.out.print(citys.get(count).text());
	           	//System.out.println("                    "+temperatura.get(count).text());
	          	//count++;
	        }	
	        return data;
	}

	
	private  Document getPage() throws MalformedURLException, IOException {
		
		String url = "https://www.timeanddate.com/weather/israel/";
		Document page = Jsoup.parse(new URL(url),3000);
		return page;
	}
}
