package smith.rowe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baishh
{
	public  String initilizeBrowser() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/home/datafile.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		return browserName;
		
	}
	
	protected String apiKey="2b1fd2d7f77ccf1b7de9b441571b39b8";
	public static String baseUrl="someBaseURL";
	public static String baseUrlopenWeather="https://api.openweathermap.org";
	public String sID_1="50676ABCD";
	public static String OpCo="en";
	
}
