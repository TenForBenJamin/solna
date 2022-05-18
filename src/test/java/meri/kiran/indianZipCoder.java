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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectRepo.parama;
import objectRepo.reUsableMethods;

public class indianZipCoder extends parama  {
	
	
	@Test
	public void zipSeries_Kerala()
	{
		System.out.println("  Zip - India ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=603000;
		int endZip=startZip+100;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
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
//		
	}
	
	
	@Parameters({"siu"})
	@Test
	public void zipSeries_StateLevel(int siu)
	{
		System.out.println("  zipSeries_StateLevel ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=673001;
		// kadalundi 673302
		int endZip=startZip+siu;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given();

				// Make a GET request call directly by using RequestSpecification.get() method.
				// Make sure you specify the resource name.
				Response response = httpRequest
						.queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather");

				// Response.asString method will directly return the content of the body
				// as String.
				//system.out.println("Response Body is =>  " + response.asString());
				String getReqRes =response.asString();
				reUsableMethods sd = new reUsableMethods();
				//sd.simblePrint(getReqRes,zipLoop);
				sd.complexPrint(getReqRes,zipLoop,404);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}
	@Parameters({"siu"})
	@Test
	public void zipSeries_Berlin(int siu)
	{
		System.out.println("  Zip - India ");
		
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=10710;
		int endZip=startZip+siu;
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
//		
	}
	@Parameters({"siu"})
	@Test
	public void zipSeries_Chennai(int siu)
	{
		System.out.println("  zipSeries_Chennai " +siu);
		//int counter =Integer.getInteger(siu);
		RestAssured.baseURI =baseUrlopenWeather;
		String varan=marwahi;
		int startZip=603000;
		int endZip=startZip+siu;
		for(int i=startZip;i<endZip;i++)
		{
			
			try {
				String zipLoop=i+",IN";
				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given();

				// Make a GET request call directly by using RequestSpecification.get() method.
				// Make sure you specify the resource name.
				Response response = httpRequest
						.queryParam("zip", zipLoop).
						queryParam("appid", apiKey).
						queryParam("lang", OpCo).queryParam("units", "metric").
						when().get("data/2.5/weather");

				// Response.asString method will directly return the content of the body
				// as String.
				//system.out.println("Response Body is =>  " + response.asString());
				String getReqRes =response.asString();
				reUsableMethods sd = new reUsableMethods();
				//sd.simblePrint(getReqRes,zipLoop);
				sd.complexPrint(getReqRes,zipLoop,404);
			}
			catch(Exception e) 
			{
				System.out.println(" no postal code found ");
			}
		}
//		
	}

}
