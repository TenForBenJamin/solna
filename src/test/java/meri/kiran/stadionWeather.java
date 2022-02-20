package meri.kiran;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;


public class stadionWeather extends parama  {
	
	
		
		//Hertha Berlin weather
		@Test
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
	
	
		@Test
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
	
	
		public void stadion_bvb_assert() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", bvb).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			//sd.coordsExtractor(getReqRes);
			String weatherCode = js.getString("weather[0].id");
			System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
			int weatherCodeInt = Integer.parseInt(weatherCode);
			if (weatherCodeInt>805)
			{
				System.out.println("     test case failed ");
				Assert.assertEquals("fail", "pass");
			}
		}
		
		
		@Test
		public void stadion_bvb() {
				
				RestAssured.baseURI =baseUrlopenWeather;
				String getReqRes =
				given().
				queryParam("zip", bvb).
				queryParam("appid", apiKey).
				queryParam("lang", OpCo).queryParam("units", "metric").
				when().get("data/2.5/weather").
				then().assertThat().statusCode(200).extract().response().asString();
				JsonPath js = new JsonPath(getReqRes);
				reUsableMethods sd = new reUsableMethods();
				//sd.coordsExtractor(getReqRes);
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
				int weatherCodeInt = Integer.parseInt(weatherCode);
				sd.coordsExtractor(getReqRes);
				String  mainTemp = js.getString("main.temp");
			}
		
		@Test
		public void stadion_sgf() {
				
				RestAssured.baseURI =baseUrlopenWeather;
				String getReqRes =
				given().
				queryParam("zip", sgf).
				queryParam("appid", apiKey).
				queryParam("lang", OpCo).queryParam("units", "metric").
				when().get("data/2.5/weather").
				then().assertThat().statusCode(200).extract().response().asString();
				JsonPath js = new JsonPath(getReqRes);
				reUsableMethods sd = new reUsableMethods();
				//sd.coordsExtractor(getReqRes);
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
				int weatherCodeInt = Integer.parseInt(weatherCode);
				sd.coordsExtractor(getReqRes);
				String  mainTemp = js.getString("main.temp");
			}
		
		
		@Test
		public void stadion_HOF() {
				
				RestAssured.baseURI =baseUrlopenWeather;
				String getReqRes =
				given().
				queryParam("zip", HOF).
				queryParam("appid", apiKey).
				queryParam("lang", OpCo).queryParam("units", "metric").
				when().get("data/2.5/weather").
				then().assertThat().statusCode(200).extract().response().asString();
				JsonPath js = new JsonPath(getReqRes);
				reUsableMethods sd = new reUsableMethods();
				//sd.coordsExtractor(getReqRes);
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
				int weatherCodeInt = Integer.parseInt(weatherCode);
				sd.coordsExtractor(getReqRes);
				String  mainTemp = js.getString("main.temp");
			}
		
		@Test
		public void stadion_ROS() {
				
				RestAssured.baseURI =baseUrlopenWeather;
				String getReqRes =
				given().
				queryParam("zip", ROS).
				queryParam("appid", apiKey).
				queryParam("lang", OpCo).queryParam("units", "metric").
				when().get("data/2.5/weather").
				then().assertThat().statusCode(200).extract().response().asString();
				JsonPath js = new JsonPath(getReqRes);
				reUsableMethods sd = new reUsableMethods();
				//sd.coordsExtractor(getReqRes);
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
				int weatherCodeInt = Integer.parseInt(weatherCode);
				sd.coordsExtractor(getReqRes);
				String  mainTemp = js.getString("main.temp");
			}
		
		@Test
		public void stadion_f95() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", f95).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
		@Test
		public void stadion_FCA() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", FCA).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
		@Test
		public void stadion_KAI() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", KAI).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
		@Test
		public void stadion_S04() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", S04).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
		
		@Test
		public void stadion_b04() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", b04).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			//System.out.println("            inside 3rd  "+mainTemp + "\r\n");
		}
		
		@Test
		public void stadion_FCB() {
			
			RestAssured.baseURI =baseUrlopenWeather;
			String getReqRes =
			given().
			queryParam("zip", FCB).
			queryParam("appid", apiKey).
			queryParam("lang", OpCo).queryParam("units", "metric").
			when().get("data/2.5/weather").
			then().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(getReqRes);
			reUsableMethods sd = new reUsableMethods();
			sd.coordsExtractor(getReqRes);
			String  mainTemp = js.getString("main.temp");
		}
		
		@Test
		public void stadion_HSV() {
				
				RestAssured.baseURI =baseUrlopenWeather;
				String getReqRes =
				given().
				queryParam("zip", Hamburg).
				queryParam("appid", apiKey).
				queryParam("lang", OpCo).queryParam("units", "metric").
				when().get("data/2.5/weather").
				then().assertThat().statusCode(200).extract().response().asString();
				JsonPath js = new JsonPath(getReqRes);
				reUsableMethods sd = new reUsableMethods();
				//sd.coordsExtractor(getReqRes);
				String weatherCode = js.getString("weather[0].id");
				System.out.println("                               weatherCode is    " +weatherCode + "\r\n");
				int weatherCodeInt = Integer.parseInt(weatherCode);
				sd.coordsExtractor(getReqRes);
				String  mainTemp = js.getString("main.temp");
			}
		
		
}
