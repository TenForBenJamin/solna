package meri.kiran;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectRepo.parama;
import objectRepo.reUsableMethods;

public class indianZipCoder extends parama  {
	
	
	@Test
	public void zipSeries_Kerala()
	{
		System.out.println("  Zip - Kerala ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=673500;
		int endZip=startZip+100;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
				String getReqRes =
						given().
						queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather").
						then().extract().response().asString();
						JsonPath js = new JsonPath(getReqRes);
						reUsableMethods sd = new reUsableMethods();
						sd.simblePrint(getReqRes,zipLoop);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}
	
	
	@Parameters({"siu"})
	@Test
	public void zipSeries_StateLevel(int siu)
	{
		System.out.println("  zipSeries_StateLevel ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=673001;
		// kadalundi 673302
		int endZip=startZip+siu;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given();

				// Make a GET request call directly by using RequestSpecification.get() method.
				// Make sure you specify the resource name.
				Response response = httpRequest
						.queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather");

				// Response.asString method will directly return the content of the body
				// as String.
				//system.out.println("Response Body is =>  " + response.asString());
				String getReqRes =response.asString();
				reUsableMethods sd = new reUsableMethods();
				//sd.simblePrint(getReqRes,zipLoop);
				sd.complexPrint(getReqRes,zipLoop,404);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}
	@Parameters({"siu"})
	@Test
	public void zipSeries_Berlin(int siu)
	{
		System.out.println("  Zip - India ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=10710;
		int endZip=startZip+siu;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",DE";
				String getReqRes =
						given().
						queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather").
						then().extract().response().asString();
						JsonPath js = new JsonPath(getReqRes);
						reUsableMethods sd = new reUsableMethods();
						sd.simblePrint(getReqRes,zipLoop);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}
	
	@Test
	public void SeBasicWeatherApp() throws InterruptedException 
	{
		System.out.println("-------------Test1-----------------------------------------------");
		//frameworktest fwt = new frameworktest();
//		System.setProperty("webdriver.chrome.driver","C:\\Mava\\chromedriver.exe"); // declaring the chrome driver locatoion
//		WebDriver driver= new ChromeDriver();// initializing chrome driver
		//driver.manage().deleteAllCookies(); // deleting all cookies
		System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();		// maximizing the window
//		String place = "potsdam";
		String place = glascow;
		String searchParam=place +" coordinates";		// earlier param
		String uri= "https://tenforben.github.io/FPL/vannilaWeatherApp/index.html";
		System.out.println("URL formed -" +uri);
		driver.get(uri);
		String brooks =place;
		String searchReq =brooks;
		System.out.println("Place is  " + brooks);
		WebElement searchBarr=driver.findElement(By.id("searchUser"));
		searchBarr.sendKeys(searchReq);		
		WebElement sambi = driver.findElement(By.id("submit"));
		 sambi.click();
		 Thread.sleep(2000);
		 
		 
		 try {
			 WebElement  coords= driver.findElement(By.id("xPat"));
			 //document.getElementById("cuwt").innerText
			 WebElement  searchResonse= driver.findElement(By.id("cuwt"));
			 WebElement  CountryC= driver.findElement(By.id("landen"));
			 String string_CC = CountryC.getText(); 
			 String searchRes = searchResonse.getText(); 		
			 String loc = coords.getText(); 	
			String searchResult= searchRes +" " + loc +" " + string_CC;
			System.out.println("CUrrent temperature  updated in excel  ");		
			String receivedValue=searchResult;

			String[] result = receivedValue.split(" ");
			String SR =result[0];
			System.out.println("weather "+" is " + SR +" degrees ");
			String Coords =result[1];//location
			String nation =result[2]; // country codeq
			System.out.println("location is " + Coords +" Lat/Longitude ");
			//fwt.quitbrowser(driver);
			driver.quit();
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("exceptions are available");
		 }
		//String searchR= driver.findElement(By.xpath("/html/body/div[3]/div/div/p[1]")).getText() ;
		
	}
	@Parameters({"siu"})
	@Test
	public void zipSeries_Chennai(int siu)
	{
		System.out.println("  zipSeries_Chennai " +siu);
		//int counter =Integer.getInteger(siu);
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=603000;
		int endZip=startZip+siu;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given();

				// Make a GET request call directly by using RequestSpecification.get() method.
				// Make sure you specify the resource name.
				Response response = httpRequest
						.queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather");

				// Response.asString method will directly return the content of the body
				// as String.
				//system.out.println("Response Body is =>  " + response.asString());
				String getReqRes =response.asString();
				reUsableMethods sd = new reUsableMethods();
				//sd.simblePrint(getReqRes,zipLoop);
				sd.complexPrint(getReqRes,zipLoop,404);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}

}
