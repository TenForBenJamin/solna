package meri.kiran;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

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

public class TeBe extends Baishh {
	// @Test
	public void twitterPost() {

	}

	 @Test
	public void LikedTweetsByUserId() throws IOException {
		String token = tokenBearer();
		Response resp = given().header("Authorization", "Bearer " + token)
				.get("https://api.twitter.com/2/users/" + khatri + "/liked_tweets");
		// System.out.println(resp.asString());
		String getReqRes = resp.asString();
		JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.TwitterParsing(getReqRes, 10);
	}

	// @Test
	public void likedUsers() throws IOException {
		String token = tokenBearer();
		Response resp = given().header("Authorization", "Bearer " + token)
				.get("https://api.twitter.com/2/tweets/" + randomTweet + "/liking_users");
		// System.out.println(resp.asString());
		String getReqRes = resp.asString();
		JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.twitterLikesParsing(getReqRes, 10);
	}

	 @Test
	public void likedUsersDetails() throws IOException {
		String token = tokenBearer();
		Response resp = given().header("Authorization", "Bearer " + token)
				.get("https://api.twitter.com/2/tweets/" + "1552318089282330624" + "/liking_users");
		// System.out.println(resp.asString());
		// .queryParam("q", ort)
		String getReqRes = resp.asString();
		JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		sd.twitterLikesParsing_adv(getReqRes, token);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[6][2];

		data[0][0] = "Kuwait City";
		data[0][1] = "Group A";

		data[1][0] = "Ulaanbaatar";
		data[1][1] = "Group B";

		data[2][0] = "Namangan";
		data[2][1] = "Group C";

		data[3][0] = "Kolkata";
		data[3][1] = "Group D";

		data[4][0] = "kuala lumpur";
		data[4][1] = "Group E";

		data[5][0] = "Bishkek";
		data[5][1] = "Group F";

		return data;

	}

	@DataProvider
	public Object[][] singleData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Vadakara";
		data[0][1] = "Group A";

		data[1][0] = "Aizwal";
		data[1][1] = "Group B";

		return data;

	}
	
	@DataProvider
	public Object[][] hurope() {
		Object[][] data = new Object[6][2];

		data[0][0] = "Dusseldorf";
		data[0][1] = "Group A";

		data[1][0] = "Amsterdam";
		data[1][1] = "Group B";
		
		data[2][0] = "Paris";
		data[2][1] = "Group A";

		data[3][0] = "London";
		data[3][1] = "Group B";
		
		data[4][0] = "interlaken";
		data[4][1] = "Group A";

		data[5][0] = "chamonix";
		data[5][1] = "Group B";

		return data;

	}

	@DataProvider
	public Object[][] sibin() {
		Object[][] data = new Object[20][2];

		data[0][0] = "Vadakara";
		data[0][1] = "Group A";

		data[1][0] = "Aizwal";
		data[1][1] = "Group B";

		data[2][0] = "Delhi";
		data[2][1] = "Group A";

		data[3][0] = "Kolkata";
		data[3][1] = "Group B";

		data[4][0] = "Mumbai";
		data[4][1] = "Group A";

		data[5][0] = "Nagpur";
		data[5][1] = "Group B";

		data[6][0] = "Chennai";
		data[6][1] = "Group A";

		data[7][0] = "Hyderabad";
		data[7][1] = "Group B";
		
		data[8][0] = "Bangalore";
		data[8][1] = "Group B";
		
		data[9][0] = "shirdi";
		data[9][1] = "Group B";
		
		data[10][0] = "kalpatta";
		data[10][1] = "Group B";
		
		data[11][0] = "karaikudi";
		data[11][1] = "Group B";
		
		data[13][0] = "bokaro";
		data[13][1] = "Group B";
		
		data[12][0] = "silchar";
		data[12][1] = "Group B";
		
		data[14][0] = "guwahati";
		data[14][1] = "Group B";
		
		data[15][0] = "gangtok";
		data[15][1] = "Group B";
		
		data[16][0] = "digha";
		data[16][1] = "Group B";
		
		data[17][0] = "trichy";
		data[17][1] = "Group B";
		
		data[18][0] = "kochi";
		data[18][1] = "Group B";
		
		data[19][0] = "munnar";
		data[19][1] = "Group B";
		
		
		
		
		

		return data;

	}

	@Test(dataProvider="sibin")
	public void dataProbhiderAPI(String ort , String comp) throws IOException
	{
		System.out.println(" For --- " +ort +" --- " +getDayLength(ort));
	}
	
	
	

	
	public void lkatKong(String ort, String comp) throws IOException {
		System.out.println(" place " + ort);
		String apiKey = schussel();
		RestAssured.baseURI = baseUrlopenWeather;
		String getReqRes = given().queryParam("lat", 52).queryParam("appid", apiKey).queryParam("lon", 3)
				.queryParam("units", "metric").when().get("data/2.5/weather").then().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath js = new JsonPath(getReqRes);
		reUsableMethods sd = new reUsableMethods();
		// sd.chur(getReqRes,0);
		// sd.coordsExtractor(getReqRes);
		String epTimeSR = js.getString("sys.sunrise");

		int iSR = Integer.parseInt(epTimeSR);
//		System.out.println(iSR);  
//		Durasion(iSR);
		String epTimeSS = js.getString("sys.sunset");
		int iSS = Integer.parseInt(epTimeSS);
		int daylength = iSS - iSR;
		Duracion(daylength);

	}

	public void Durasion(int dl) {
		Date date = new Date(dl);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = format.format(date);
		System.out.println(formatted);
		format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		formatted = format.format(date);
		System.out.println(formatted);
		// return dl;
	}

	
}
