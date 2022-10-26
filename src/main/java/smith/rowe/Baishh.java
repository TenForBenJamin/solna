package smith.rowe;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Baishh
{
	//Properties prop = new Properties();
	//FileInputStream fis = new FileInputStream("C:/home/datafile.properties");
	//prop.load(fis);
	//String browserName=prop.getProperty("apiSchussel");
	//return browserName;
	protected String Stimac = "1128405471960997889";
	protected String khatri = "28515858";
	protected String randomGuy1 ="1034698008993124352";
	protected String fabrizioRomano ="330262748";
	protected String ten4Ben="1421777718736297986";
	protected String randomTweet="1390266553686323203";
	
	protected String puchtualityFreak = "RoshniKuhuChak1";
	
	protected String randomTweet2 = "1538523689146232833";
	protected String randomTweet3 ="13538054841830109184";/*
	protected String fabrizioRomano ="330262748";
	protected String ten4Ben="1421777718736297986";
	protected String randomTweet="1534784959579561984";
	*/
	
	public  String initilizeBrowser() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/home/datafile.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		return browserName;
		
	}
	
	
	public WebDriver driver ;
	public  WebDriver initilizeDriver() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/home/datafile.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\home\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if(browserName.equalsIgnoreCase("chromeheadless"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver","C:\\home\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}

		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
			driver= new FirefoxDriver();
		}

		if(browserName.equalsIgnoreCase("firefoxheadless"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");

			FirefoxBinary firefoxBinary = new FirefoxBinary();
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(firefoxBinary);
			options.setHeadless(true);  // <-- headless set here
			driver= new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public  String schussel() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/home/datafile.properties");

		prop.load(fis);
		String browserName=prop.getProperty("apiSchussel");
		return browserName;
		
	}
	public  String tokenBearer() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/home/datafile.properties");

		prop.load(fis);
		String browserName=prop.getProperty("token");
		return browserName;
		
	}
	
	//protected String apiKey="2b1fd2d7f77ccf1b7de9b441571b39b8";
	public static String baseUrl="someBaseURL";
	public static String baseUrlopenWeather="https://api.openweathermap.org";
	public String geicoDriver="50676ABCD";
	public static String OpCo="en";
	
	
	public String getDayLength(String ort) throws IOException
	{
		String dl;
		
		//System.out.println(" inside getDayLength for  " +ort);
		String apiKey=schussel();
		RestAssured.baseURI =baseUrlopenWeather;
		String getReqRes =
		given().
		queryParam("q", ort).
		queryParam("appid", apiKey).
		queryParam("lang", OpCo).queryParam("units", "metric").
		when().get("data/2.5/weather").
		then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(getReqRes);
		//reUsableMethods sd = new reUsableMethods();
		//sd.chur(getReqRes,0);
		//sd.coordsExtractor(getReqRes);
		String  epTimeSR = js.getString("sys.sunrise");
		  
		int iSR=Integer.parseInt(epTimeSR); 
//		System.out.println(iSR);  
//		Durasion(iSR);
		String  epTimeSS = js.getString("sys.sunset");
		int iSS=Integer.parseInt(epTimeSS);  
		int daylength = iSS-iSR;
		dl=Duracion(daylength);
		
		return dl;
	}
	public String Duracion(int dl) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(dl * 1000L);
		cal.setTimeZone(TimeZone.getTimeZone("UTC+1"));
		int daylengthHours = cal.get(Calendar.HOUR_OF_DAY);
		daylengthHours = daylengthHours + 1;
		// System.out.println(cal.get(Calendar.HOUR_OF_DAY));//12 hour clock
		String miren="daylength is " + daylengthHours + " H " + cal.get(Calendar.MINUTE) + " M  ";// 24 hour
																											// clock
		// return dl;
		return miren;
	}
	
}
