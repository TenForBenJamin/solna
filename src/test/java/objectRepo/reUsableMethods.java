package objectRepo;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class reUsableMethods 
{
	public static String coordsExtractor(String s) 
	 {
		 
		 System.out.println(" inside ReusableBall method ");
		 JsonPath js = new JsonPath(s);
			String dt = js.getString("dt");
			int ddt=Integer.parseInt(dt);
			System.out.println("Raw date is   " + dt);
			//java.util.Date time = new java.util.Date(dt);
			java.util.Date time=new java.util.Date((long)ddt*1000);
			System.out.println(" beutified date is  " + time);
			
			String asliJagah=js.getString("name");
			System.out.println("extracted place for  ZipCode "+ dt +" is                  " +asliJagah);
			//double count = js.getInt("main.temp");
			System.out.println("in");
			System.out.println("\n");
			String coundry = js.getString("sys.country");
			String rlat = js.getString("coord.lat");
			String rlon = js.getString("coord.lon");
			String windSpeed =js.getString("wind.speed");
			String weatherDesc =js.getString("weather[0].description");
			String weatherCode = js.getString("weather[0].id");
			System.out.println("                      weatherCode n Desc are    " +weatherCode + " n " + weatherDesc  + "\n");
			System.out.println("                               Latitude is    " +rlat + "\r\n");
			System.out.println("                               Longitude  is    " +rlon + "\r\n");
			System.out.println("                                the  Nation of    " +coundry + "\r\n");
			double count = js.getDouble("main.temp");
			String mainTemp = js.getString("main.temp");
			System.out.println("\n");
			System.out.println("                                currentTemp   "+count +"	wind speed -   "+windSpeed + "\r\n");
			double weatherCodeD = Double.parseDouble(mainTemp);
			int aarm =25;
			if (weatherCodeD>aarm)
			{
				System.out.println("     test case failed  for "+asliJagah);
				Assert.assertEquals(weatherCodeD,"above Limit set at - "+aarm +" degree");
			}
		 
		 return null;
	 }
	
	public static void hotWeather() 
	{
		
		
	}
	
	public static String chur(String s , int schrute) 
	 {
		 
		 System.out.println(" inside ReusableBall method ");
		 JsonPath js = new JsonPath(s);
			String dt = js.getString("dt");
			int ddt=Integer.parseInt(dt);
			System.out.println("Raw date is   " + dt);
			//java.util.Date time = new java.util.Date(dt);
			java.util.Date time=new java.util.Date((long)ddt*1000);
			System.out.println(" beutified date is  " + time);
			
			String asliJagah=js.getString("name");
			System.out.println("extracted place for  ZipCode "+ dt +" is                  " +asliJagah);
			//double count = js.getInt("main.temp");
			System.out.println("in");
			System.out.println("\n");
			String coundry = js.getString("sys.country");
			String rlat = js.getString("coord.lat");
			String rlon = js.getString("coord.lon");
			String windSpeed =js.getString("wind.speed");
			String weatherDesc =js.getString("weather[0].description");
			String weatherCode = js.getString("weather[0].id");
			System.out.println("                      weatherCode n Desc are    " +weatherCode + " n " + weatherDesc  + "\n");
			System.out.println("                               Latitude is    " +rlat + "\r\n");
			System.out.println("                               Longitude  is    " +rlon + "\r\n");
			System.out.println("                                the  Nation of    " +coundry + "\r\n");
			double count = js.getDouble("main.temp");
			String mainTemp = js.getString("main.temp");
			System.out.println("\n");
			System.out.println("                                currentTemp   "+count +"	wind speed -   "+windSpeed + "\r\n");
			double weatherCodeD = Double.parseDouble(mainTemp);
			int aarm =schrute;
			if (weatherCodeD>aarm)
			{
				System.out.println("     test case failed  for "+asliJagah);
				Assert.assertEquals(weatherCodeD,"above Limit set for " +asliJagah +"," +coundry    +" at  "+aarm +" degree");
			}
		 
		 return null;
	 }
	
	
	
	public static String TwitterParsing(String s , int schrute) 
	 {
		 
		 System.out.println(" inside Twitter Parsing method ");
		 JsonPath js = new JsonPath(s);
			//String dt = js.getString("dt");
			int ddt=js.getInt("data.size()");
			System.out.println("data size is    " + ddt);
			for( int i=0;i<schrute;i++)
			{
				//String 
				System.out.println("Tweet " + i +" is \n" +js.get("data[ " + i + "].text"));
			}
				
			/*
			for
			//java.util.Date time = new java.util.Date(dt);
			java.util.Date time=new java.util.Date((long)ddt*1000);
			System.out.println(" beutified date is  " + time);
			
			String asliJagah=js.getString("name");
			System.out.println("extracted place for  ZipCode "+ dt +" is                  " +asliJagah);
			//double count = js.getInt("main.temp");
			System.out.println("in");
			System.out.println("\n");
			String coundry = js.getString("sys.country");
			String rlat = js.getString("coord.lat");
			String rlon = js.getString("coord.lon");
			String windSpeed =js.getString("wind.speed");
			String weatherDesc =js.getString("weather[0].description");
			String weatherCode = js.getString("weather[0].id");
			System.out.println("                      weatherCode n Desc are    " +weatherCode + " n " + weatherDesc  + "\n");
			System.out.println("                               Latitude is    " +rlat + "\r\n");
			System.out.println("                               Longitude  is    " +rlon + "\r\n");
			System.out.println("                                the  Nation of    " +coundry + "\r\n");
			double count = js.getDouble("main.temp");
			String mainTemp = js.getString("main.temp");
			System.out.println("\n");
			System.out.println("                                currentTemp   "+count +"	wind speed -   "+windSpeed + "\r\n");
			double weatherCodeD = Double.parseDouble(mainTemp);
			int aarm =schrute;
			if (weatherCodeD>aarm)
			{
				System.out.println("     test case failed  for "+asliJagah);
				Assert.assertEquals(weatherCodeD,"above Limit set for " +asliJagah +"," +coundry    +" at  "+aarm +" degree");
			}
		 */
		 return null;
	 }
	public static String simblePrint(String s , String z) 
	 {
		 
		
			try 
			{
				JsonPath js = new JsonPath(s);
				String dt = js.getString("dt");
				int ddt=Integer.parseInt(dt);
				//System.out.println("Raw date is   " + dt);
				//java.util.Date time = new java.util.Date(dt);
				java.util.Date time=new java.util.Date((long)ddt*1000);
				//System.out.println(" beutified date is  " + time);
				
				String asliJagah=js.getString("name");
				System.out.println("extracted place for  ZipCode "+ z +" is                  " +asliJagah);
				double count = js.getDouble("main.temp");
				String mainTemp = js.getString("main.temp");
	//			System.out.println("in");
	//			System.out.println("\n");
				String coundry = js.getString("sys.country");
				String rlat = js.getString("coord.lat");
				String rlon = js.getString("coord.lon");
				String windSpeed =js.getString("wind.speed");
				String weatherDesc =js.getString("weather[0].description");
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                      weatherCode -   " +weatherCode + " |  weather description -  " + weatherDesc + "  | temperature is " + mainTemp   );
			}
			catch(Exception e) {
				System.out.println("no pinCode found for "+ z);
			}
		 
		 return null;
	 }
	
	public static String complexPrint(String s , String z,int sc) 
	 {
		 
		
			try 
			{
				JsonPath js = new JsonPath(s);
				String dt = js.getString("dt");
				int ddt=Integer.parseInt(dt);
				//System.out.println("Raw date is   " + dt);
				//java.util.Date time = new java.util.Date(dt);
				java.util.Date time=new java.util.Date((long)ddt*1000);
				//System.out.println(" beutified date is  " + time);
				
				String asliJagah=js.getString("name");
				String coundry = js.getString("sys.country");
				String rlat = js.getString("coord.lat");
				String rlon = js.getString("coord.lon");
				String windSpeed =js.getString("wind.speed");
				String weatherDesc =js.getString("weather[0].description");
				String weatherCode = js.getString("weather[0].id");
				System.out.println("Extracted place for  ZipCode "+ z +" is          " +asliJagah+" is at                           					" +rlat+" , "+rlon );
				double count = js.getDouble("main.temp");
				String mainTemp = js.getString("main.temp");
	//			System.out.println("in");
	//			System.out.println("\n");
				
				System.out.println("                      weatherCode -   " +weatherCode + " |  weather description -  " + weatherDesc + "  | temperature is " + mainTemp   );
			}
			catch(Exception e) {
				System.out.println("no pinCode found for "+ z +"    and error code is " +sc);
			}
		 
		 return null;
	 }
}

