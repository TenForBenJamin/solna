package meri.kiran;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;
import smith.rowe.App;



public class UEL_2022_23 extends parama  {
	
	
		
		//Hertha Berlin weather
		
		public void stadion_HBC()
		{
			System.out.println("  Hertha berlin ");
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", HBC).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			//sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
	
	
		
		public void stadion_UNI()
		{
			System.out.println("  UNION BERLIN");
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", UNI).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			//sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
	
		
		public void AustrianGraz() throws InterruptedException 
		{
			System.out.println("-------------Test1-----------------------------------------------");
			//frameworktest fwt = new frameworktest();
//			System.setProperty("webdriver.chrome.driver","C:\\Mava\\chromedriver.exe"); // declaring the chrome driver locatoion
//			WebDriver driver= new ChromeDriver();// initializing chrome driver
			//driver.manage().deleteAllCookies(); // deleting all cookies
			System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			driver.manage().window().maximize();		// maximizing the window
//			String place = "potsdam";
			String place = Graz;
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
		
		@Test
		public void E2E() throws InterruptedException 
		{
			System.out.println("-------------Test1-----------------------------------------------");
			//frameworktest fwt = new frameworktest();
//			System.setProperty("webdriver.chrome.driver","C:\\Mava\\chromedriver.exe"); // declaring the chrome driver locatoion
//			WebDriver driver= new ChromeDriver();// initializing chrome driver
			//driver.manage().deleteAllCookies(); // deleting all cookies
			System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			driver.manage().window().maximize();		// maximizing the window
//			String place = "potsdam";
			String place = genRandomStadt();
			
			//     xpath for WeatherAPI button        //*[@id="MoviesB"]
			String uri= "https://tenforben.github.io";
			System.out.println("URL formed -" +uri);
			driver.get(uri);
			String brooks =place;
			String WAbuttonXpth ="//*[@id=\"Ramo\"]/a[2]";
			String MetricbuttonXpth ="//*[@id=\"MoviesB\"]";
			String searchReq =brooks;
			System.out.println("Place is  " + brooks);
			WebElement WAbutton = driver.findElement(By.xpath(WAbuttonXpth));
			WAbutton.click();
			WebElement MetricButton = driver.findElement(By.xpath(MetricbuttonXpth));
			MetricButton.click();
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
		
		public static String genRandomStadt() {
	    	Faker faker = new Faker();
	    	return faker.address().country();
	    	
	    }
		
}
