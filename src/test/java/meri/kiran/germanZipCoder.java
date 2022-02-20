package meri.kiran;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

public class germanZipCoder extends parama {

	

	@Test
	public void zipSeries_Deutschland()
	{
		System.out.println("  Zip - NRW ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		int startZip=40200;
		int endZip=startZip+1300;
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
//		String getReqRes =
//		given().
//		queryParam("zip", KL56).
//		queryParam("appid", apiKey).
//		queryParam("lang", OpCo).queryParam("units", "metric").
//		when().get("data/2.5/weather").
//		then().assertThat().statusCode(200).extract().response().asString();
//		JsonPath js = new JsonPath(getReqRes);
//		reUsableMethods sd = new reUsableMethods();
//		sd.simblePrint(getReqRes);
//		//sd.coordsExtractor(getReqRes);
//		String  mainTemp = js.getString("main.temp");
	}

}
