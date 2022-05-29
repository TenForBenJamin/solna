package objectRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PageObjectFactory {
	
	
	WebDriver driver ;
	
	public PageObjectFactory(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	String WAbuttonXpth ="//*[@id=\"Ramo\"]/a[2]";
	String MetricbuttonXpth ="//*[@id=\"MoviesB\"]";
	
	
	By HomePageWeatherAPIbutton = By.xpath(WAbuttonXpth);
	By SubmitButton = By.id("submit");
	By MetricPageButton = By.xpath(MetricbuttonXpth);
	By SearchBar = By.id("searchUser");
	
	public WebElement NavigationToWeatherAPI()
	{
		return driver.findElement(HomePageWeatherAPIbutton);
	}
	
	
	public WebElement NavigationToMetricPageButton()
	{
		return driver.findElement(MetricPageButton);
	}
	
	public WebElement searchPlace()
	{
		return driver.findElement(SearchBar);
	}
	
	
	public WebElement SubmitButtonOfMetric()
	{
		return driver.findElement(SubmitButton);
	}

}
