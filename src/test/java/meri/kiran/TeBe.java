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
public class TeBe extends Baishh
{
	//@Test
	public void twitterPost() {
        

    }
	
	//@Test
	public void LikedTweetsByUserId() throws IOException {
		String token=tokenBearer();
	    Response resp = given().header("Authorization", "Bearer "+token).
	            get("https://api.twitter.com/2/users/"+ ten4Ben +"/liked_tweets");
	    //System.out.println(resp.asString());
	    String getReqRes=resp.asString();
	    JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.TwitterParsing(getReqRes,10);
	}
	@Test
	public void likedUsers() throws IOException {
		String token=tokenBearer();
	    Response resp = given().header("Authorization", "Bearer "+token).
	            get("https://api.twitter.com/2/tweets/"+ randomTweet +"/liking_users");
	    //System.out.println(resp.asString());
	    String getReqRes=resp.asString();
	    JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.twitterLikesParsing(getReqRes,10);
	}
	
	public void likedUsersDetails() throws IOException {
		String token=tokenBearer();
	    Response resp = given().header("Authorization", "Bearer "+token).
	            get("https://api.twitter.com/2/tweets/"+ randomTweet +"/liking_users");
	    //System.out.println(resp.asString());
	    String getReqRes=resp.asString();
	    JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.twitterLikesParsing_adv(getReqRes,10);
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
	
	
	
}
