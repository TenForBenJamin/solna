package meri.kiran;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.PageObjectFactory;
import objectRepo.parama;
import objectRepo.reUsableMethods;
import smith.rowe.Baishh;
public class vini extends Baishh
{
	//@Test
	public void twitterPost() {
        

    }
	
	@Test
	public void LikedTweetsByUserId() throws IOException {
		String token=tokenBearer();
	    Response resp = given().header("Authorization", "Bearer "+token).
	            get("https://api.twitter.com/2/users/"+ fabrizioRomano +"/liked_tweets");
	    //System.out.println(resp.asString());
	    String getReqRes=resp.asString();
	    JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.TwitterParsing(getReqRes,10);
	}

	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[6][2];
		
		data[0][0]="Kuwait City";
		data[0][1]="Group A";
		
		data[1][0]="Ulaanbaatar";
		data[1][1]="Group B";
		
		data[2][0]="Namangan";
		data[2][1]="Group C";
		
		

		data[3][0]="Kolkata";
		data[3][1]="Group D";
		
		data[4][0]="kuala lumpur";
		data[4][1]="Group E";
		
		data[5][0]="Bishkek";
		data[5][1]="Group F";
		
		return data;
		
		
	}
	
	@DataProvider
	public Object[][] singleData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0]="Interlaken,CH";
		data[0][1]="Group A";
		
		data[1][0]="Interlaken";
		data[1][1]="Group B";
		
		
		
		return data;
		
		
	}
	
	

	//@Test(dataProvider="ZweiteLiga")
	public void dataProbhiderAPI(String ort , String comp) throws IOException
	{
		System.out.println(" place " +ort);
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
		reUsableMethods sd = new reUsableMethods();
		sd.chur(getReqRes,0);
		//sd.coordsExtractor(getReqRes);
		String  mainTemp = js.getString("main.temp");
	}
	
	//@Test(dataProvider="getData")
	public void ASIAN_2023_Qualifier(String ort , String comp) throws IOException
	{
		System.out.println(" place " +ort);
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
		reUsableMethods sd = new reUsableMethods();
		sd.chur(getReqRes,0);
		//sd.coordsExtractor(getReqRes);
		String  mainTemp = js.getString("main.temp");
	}
	
	//@Test(dataProvider="ErsteLiga")
	public void Bundesliga(String ort , String comp) throws IOException
	{
		System.out.println(" place " +ort);
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
		reUsableMethods sd = new reUsableMethods();
		sd.chur(getReqRes,0);
		//sd.coordsExtractor(getReqRes);
		String  mainTemp = js.getString("main.temp");
	}
	
	@Test(dataProvider="daley")
	public void e2e(String ort , String comp) throws InterruptedException, IOException 
	{
		//System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		driver=initilizeDriver();
		driver.manage().window().maximize();		// maximizing the window
		driver.get("https://tenforben.github.io");
		String kanda = initilizeBrowser();
		System.out.println("browser is   "+kanda);
		String place = ort;
		PageObjectFactory po = new PageObjectFactory(driver);
		po.NavigationToWeatherAPI().click();
		Thread.sleep(2000);
		po.NavigationToMetricPageButton().click();
		po.searchPlace().sendKeys(place);
		po.SubmitButtonOfMetric().click();
		Thread.sleep(12000);
//		String x=po.temperatureElement().getText();
//		double weatherCodeD = Double.parseDouble(x);
//		int aarm =15;
//		if (weatherCodeD>aarm)
//		{
//			System.out.println("     test case failed ");
//			//Assert.assertEquals(weatherCodeD,"above Limit set at - "+aarm +" degree");
//		}
	 
		driver.close();
		driver.quit();
	}
	
@DataProvider
	
	public Object[][] ZweiteLiga()
	{
		Object[][] data = new Object[18][2];
		
		data[0][0]="Kiel";
		data[0][1]="EuropaLeague";
		
		data[1][0]="Rostock";
		data[1][1]="EuropaLeague";
		
		data[2][0]="Hamburg";
		data[2][1]="EuropaLeague";
		
		

		data[3][0]="St. Pauli";
		data[3][1]="UCL";
		
		data[4][0]="Magdeburg";
		data[4][1]="UCL";
		
		data[5][0]="Furth";
		data[5][1]="UCL";
		
		data[6][0]="Nuremberg";
		data[6][1]="EuropaLeague";
		
		data[7][0]="Regensburg";
		data[7][1]="EuropaLeague";
		
		data[8][0]="Heidenheim";
		data[8][1]="EuropaLeague";
		
		

		data[9][0]="Sandhausen";
		data[9][1]="UCL";
		
		data[10][0]="Karlsruhe";
		data[10][1]="UCL";
		
		data[11][0]="kaiserslautern";
		data[11][1]="UCL";
		
		data[12][0]="Darmstadt";
		data[12][1]="UCL";
		
		data[13][0]="Dusseldorf";
		data[13][1]="UCL";
		
		data[14][0]="Paderborn";
		data[14][1]="EuropaLeague";
		
		data[15][0]="Bielefeld";
		data[15][1]="EuropaLeague";
		
		data[16][0]="Hannover";
		data[16][1]="EuropaLeague";
		
		

		data[17][0]="Braunschweig";
		data[17][1]="UCL";
		
		
		
		return data;
		
		
	}

@DataProvider

public Object[][] ErsteLiga()
{
	Object[][] data = new Object[18][2];
	
	data[0][0]="Spandau";
	data[0][1]="Berlin";
	
	data[1][0]="treptow";
	data[1][1]="Berlin";
	
	data[2][0]="Bremen";
	data[2][1]="Nord";
	
	

	data[3][0]="Wolfsburg";
	data[3][1]="NordZentral";
	
	data[4][0]="Leipzig";
	data[4][1]="East";
	
	data[5][0]="Munich";
	data[5][1]="bayern";
	
	data[6][0]="Augsburg";
	data[6][1]="bayern";
	
	data[7][0]="stuttgart";
	data[7][1]="SouthWest";
	
	data[8][0]="Freiburg im Breisgau";
	data[8][1]="EuropaLeague";
	
	

	data[9][0]="Hoffenheim";
	data[9][1]="Sinsheim";
	
	data[10][0]="cologne";
	data[10][1]="UCL";
	
	data[11][0]="dortmund";
	data[11][1]="UCL";
	
	data[12][0]="Frankfurt";
	data[12][1]="UCL";
	
	data[13][0]="Mainz";
	data[13][1]="UCL";
	
	data[14][0]="Gelsenkirchen";
	data[14][1]="NRW";
	
	data[15][0]="Monchengladbach";
	data[15][1]="NRW";
	
	data[16][0]="bochum";
	data[16][1]="NRW";
	
	

	data[17][0]="Leverkusen";
	data[17][1]="NRW";
	
	
	
	return data;
	
	
}

@DataProvider

public Object[][] daley()
{
	Object[][] data = new Object[18][2];
	
	data[0][0]="Webb City";
	data[0][1]="Berlin";
	
	data[1][0]="belton";
	data[1][1]="Berlin";
	
	data[2][0]="kansas city";
	data[2][1]="Nord";
	
	

	data[3][0]="Guadalcanal";
	data[3][1]="NordZentral";
	
	data[4][0]="paterson";
	data[4][1]="East";
	
	data[5][0]="tuscon";
	data[5][1]="bayern";
	
	data[6][0]="twin valley";
	data[6][1]="bayern";
	
	data[7][0]="Sioux falls";
	data[7][1]="SouthsiouWest";
	
	data[8][0]="Mount Airy";
	data[8][1]="EuropaLeague";
	
	

	data[9][0]="Chicago";
	data[9][1]="Sinsheim";
	
	data[10][0]="cologne";
	data[10][1]="UCL";
	
	data[11][0]="mojave desert";
	data[11][1]="UCL";
	
	data[12][0]="Rattlesnake";
	data[12][1]="UCL";
	
	data[13][0]="seattle";
	data[13][1]="UCL";
	
	data[14][0]="atlanta";
	data[14][1]="NRW";
	
	data[15][0]="newYork";
	data[15][1]="NRW";
	
	data[16][0]="scranton";
	data[16][1]="NRW";
	
	

	data[17][0]="stamford";
	data[17][1]="NRW";
	
	
	
	return data;
	
	
}
	
}
