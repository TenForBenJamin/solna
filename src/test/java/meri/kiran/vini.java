package meri.kiran;

import static io.restassured.RestAssured.given;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class vini extends parama
{
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] data = new Object[6][2];
		
		data[0][0]="Fribourg";
		data[0][1]="EuropaLeague";
		
		data[1][0]="Eindhoven";
		data[1][1]="EuropaLeague";
		
		data[2][0]="Warsaw";
		data[2][1]="EuropaLeague";
		
		

		data[3][0]="seville";
		data[3][1]="UCL";
		
		data[4][0]="Porto";
		data[4][1]="UCL";
		
		data[5][0]="LeipZig";
		data[5][1]="UCL";
		
		return data;
		
		
	}

	@Test(dataProvider="ZweiteLiga")
	public void dataProbhiderAPI(String ort , String comp)
	{
		System.out.println(" place " +ort);
		
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
		sd.coordsExtractor(getReqRes);
		//sd.coordsExtractor(getReqRes);
		String  mainTemp = js.getString("main.temp");
	}
	
	
	public void e2e(String ort , String comp) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Mava\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();		// maximizing the window
		driver.get("https://tenforben.github.io");
//		String place = "potsdam";
		String place = ort;
		PageObjectFactory po = new PageObjectFactory(driver);
		po.NavigationToWeatherAPI().click();
		Thread.sleep(2000);
		po.NavigationToMetricPageButton().click();
		po.searchPlace().sendKeys(place);
		po.SubmitButtonOfMetric().click();
		Thread.sleep(12000);
		String x=po.temperatureElement().getText();
		double weatherCodeD = Double.parseDouble(x);
		int aarm =15;
		if (weatherCodeD>aarm)
		{
			System.out.println("     test case failed ");
			Assert.assertEquals(weatherCodeD,"above Limit set at - "+aarm +" degree");
		}
	 
		
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
	
}
