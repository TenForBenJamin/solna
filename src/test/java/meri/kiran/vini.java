package meri.kiran;

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
public class vini 
{
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0]="Fribourg";
		data[0][1]="EuropaLeague";
		
		data[1][0]="Eindhoven";
		data[1][1]="EuropaLeague";
		
		data[2][0]="Warsaw";
		data[2][1]="EuropaLeague";
		
		return data;
		
		
	}

	@Test(dataProvider="getData")
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
		driver.quit();
		
		
		
		
		
	}
	
}
