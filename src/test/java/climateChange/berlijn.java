package climateChange;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;
import smith.rowe.App;

public class berlijn extends parama
{
   // @Test
    public void randomCapitalWeatherCheck()
    {
        String aarari =genRandomMaageHithe();
        System.out.println(" Testing Faker item   " + aarari);
        RestAssured.baseURI =baseUrlopenWeather;
        String getReqRes =
                given().
                        queryParam("q", aarari).
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

    public static String genRandomMaageHithe() {
        Faker faker = new Faker();
        String soorarai=faker.country().capital();
        return soorarai;

    }
    @Test
    public void lon77change()
    {
        System.out.println("  longitude 77 line ");

        RestAssured.baseURI =baseUrlopenWeather;
        String varan=marwahi;
        int siu=50;
        int startlat=8;
        int endZip=startlat+siu;
        for(int i=startlat;i<endZip;i++)
        {

            try {

                RestAssured.baseURI =baseUrlopenWeather;
                String getReqRes =
                        given().
                                queryParam("lat", i).queryParam("lon", "77").
                                queryParam("appid", apiKey).
                                queryParam("lang", OpCo).queryParam("units", "metric").
                                when().get("data/2.5/weather").
                                then().assertThat().statusCode(200).extract().response().asString();
                JsonPath js = new JsonPath(getReqRes);
                reUsableMethods sd = new reUsableMethods();
                //sd.coordsExtractor(getReqRes);
                sd.simbleDaylengthPrint(getReqRes,i +" lat and  77 lon  ");
            }
            catch(Exception e)
            {
                System.out.println(" no postal code found ");
            }
        }
    }


}
