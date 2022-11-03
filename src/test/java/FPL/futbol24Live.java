package FPL;

import io.cucumber.java.hu.Ha;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;
import static smith.rowe.randomData.genRandomCapitalName;
import static smith.rowe.randomData.genRandomMgrId;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class futbol24Live extends parama{

    @Test
    public void f24AllGames() throws IOException {
        driver=initilizeDriver();
        int failureCount=0;
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        System.out.println("total matches = " +count);
        for(int i=1;i<=100;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            String[] result = homeTeam.split(" ");
            if(result.length<2)
                homeTeam=result[0];
            else
                homeTeam=result[1];

            //String temp= f24Weather(homeTeam).trim();
            String temp= f24Weather(homeTeam).trim();
            temp=temp.trim();
            if(temp.equalsIgnoreCase("400 error"))
                failureCount=failureCount+1;
            else
            {
                String[] lowe = temp.split(",");
                nat.add(lowe[1]);

            }

            System.out.println("Home Team # " +i +" is " +homeTeam +" and weather is "+temp);
        }

        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();
        while(e.hasNext())
            System.out.println(e.next());
        System.out.println("Total Failure/Success is " +failureCount +" / " +count +" total Nations involved  " +nat.size());
        driver.quit();
    }

    @Test
    public void f24AllGamesV2() throws IOException {
        driver=initilizeDriver();
        int failureCount=0;
        int statCount=0;
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        System.out.println("total matches = " +count);
        for(int i=1;i<=100;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            homeTeam=wordProcesser(homeTeam);
            //String temp= f24Weather(homeTeam).trim();
            String temp= f24Weather(homeTeam).trim();
            temp=temp.trim();
            if(temp.equalsIgnoreCase("400 error"))
                failureCount=failureCount+1;
            else
            {
                String[] lowe = temp.split(",");
                nat.add(lowe[1]);

            }
            statCount=statCount+1;
            System.out.println("Home Team # " +i +" is " +homeTeam +" and weather is "+temp);
        }

        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();
        while(e.hasNext())
            System.out.println(e.next());
        System.out.println("Total Failure/Success is " +failureCount +" / " +statCount +" total Nations involved  " +nat.size());
        driver.quit();
    }
    public String f24Weather(String place)
    {

        RestAssured.baseURI =baseUrlopenWeather;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.queryParam("q", place).queryParam("appid", apiKey).queryParam("units", "metric");
        Response response = httpRequest.request(Method.GET,"data/2.5/weather");
        if(response.statusCode()==200){
            String getReqRes =
                    given().
                            queryParam("q", place).
                            queryParam("appid", apiKey).
                            queryParam("lang", OpCo).queryParam("units", "metric").
                            when().get("data/2.5/weather").
                            then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = new JsonPath(getReqRes);
            reUsableMethods sd = new reUsableMethods();
            //sd.coordsExtractor(getReqRes);
            //sd.simbleDaylengthPrint(getReqRes," Capital details ");
            String  mainTemp = js.getString("main.temp");
            String coundry = js.getString("sys.country");
            mainTemp= mainTemp +"," +coundry;
            return mainTemp;
        }else
            return "400 error ";

    }

    public String wordProcesser(String homeTeam)
    {
        /*HashMap<Integer,String> hm= new HashMap<Integer,String>();
        hm.put(1,"United");
        hm.put(2,"City");
        hm.put(3,"FC");
        hm.put(4,"FK");
        hm.put(2,"de");
        hm.put(3,"FC");
         Set sn = hm.entrySet();
        Iterator it =sn.iterator();
        while(it.hasNext())
        {
            Map.Entry mp=(Map.Entry)it.next();

        }
*/
        HashSet<String> hs = new HashSet<String>();
        hs.add("United");
        hs.add("City");
        hs.add("FC");
        hs.add("FK");
        hs.add("U20");
        hs.add("U19");
        hs.add("U16");
        hs.add("U17");
        hs.add("U23");
        hs.add("U21");
        hs.add("(R)");
        hs.add("FA");
        hs.add("Fotbol");
        hs.add("FC/SC");
        hs.add("Youth");
        hs.add("CF");
        hs.add("FA");
        hs.add("(W)");
        hs.add("SC");
        hs.add("SPb");

        Iterator<String> i=hs.iterator();

        Boolean flag = false;
        String[] result = homeTeam.split(" ");
        if(result.length<2)
            homeTeam=result[0];
        else {
            homeTeam = result[1];
            while(i.hasNext())
            {
                //System.out.println(i.next());
                String macher = i.next();
                if(homeTeam.equalsIgnoreCase(macher))
                    flag=true;
            }
            if(flag)
                homeTeam=result[0];

        }




        return homeTeam;
    }

}
