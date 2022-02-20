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

public class indianZipCoder extends parama  {
	
	
	@Test
	public void zipSeries_Kerala()
	{
		System.out.println("  Zip - India ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String getReqRes =
		given().
		queryParam("zip", KL56).
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

}
