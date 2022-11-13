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

import static FPL.wordProx.wordProcesserV2;
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
import java.text.SimpleDateFormat;
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
        HashSet<String> team = new HashSet<String>();
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        System.out.println("total matches = " +count);
        for(int i=0;i<count;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            team.add(homeTeam);
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
            Calendar cal= Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            String tim =sdf.format(cal.getTime());
            System.out.println("Home Team # " + i +" is " + homeTeam +" and weather is    ->   "+ temp +"    at " +tim);
        }

        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();/*
        while(e.hasNext())
            System.out.println(e.next());*/
        System.out.println("Total Failure/Success is " + failureCount + " / " + statCount +" total Nations involved  " +nat.size());
        driver.quit();
    }
      @Test
    public void f24AllGamesV3() throws IOException {
        driver=initilizeDriver();
        int failureCount=0;
        int statCount=0;
        float idealWeather=95;
          float lastColdest =idealWeather;
          String coldestPlace = "your mind";
        HashSet<String> team = new HashSet<String>();
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        System.out.println("total matches = " +count);
        for(int i=0;i<count;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            team.add(homeTeam);
        }
          driver.quit();
        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();/*
        while(e.hasNext())
            System.out.println(e.next());*/

         Iterator<String > ht = team.iterator();
         while (ht.hasNext())
         {
             String wc=ht.next();
             wc=wordProcesserV2(wc);
             //String temp= f24Weather(homeTeam).trim();
             String temp= f24Weather(wc).trim();
             temp=temp.trim();
             if(temp.equalsIgnoreCase("400 error"))
                 failureCount=failureCount+1;
             else
             {
                 String[] lowe = temp.split(",");
                 nat.add(lowe[1]);
                 String exTemp= lowe[0];
                 float cityTemp = Float.parseFloat(exTemp);
                 if(cityTemp<lastColdest)
                 {
                      coldestPlace = wc +" " +temp;
                       lastColdest = cityTemp;
                 }
             }
             statCount=statCount+1;
             Calendar cal= Calendar.getInstance();
             SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
             String tim =sdf.format(cal.getTime());
             System.out.println("Home Team v3 # " + statCount +" is " + wc +" and weather is    ->   "+ temp +"    at " +tim);
         }
          System.out.println("Total Failure/Success is " + failureCount + " / " + statCount +" = " +(double)failureCount/(double)statCount +" total Nations involved  " +nat.size());
          System.out.println("coldest place amongst the places is "+coldestPlace);

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
            //coundry=restCOuntries(coundry);
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
        hs.add("Morton");
        hs.add("Fotbol");
        hs.add("FC/SC");
        hs.add("Youth");
        hs.add("CF");
        hs.add("FA");
        hs.add("(W)");
        hs.add("SC");
        hs.add("SPb");
        hs.add("Three");
        hs.add("Utd");
        hs.add("University");
        hs.add("SK");
        hs.add("JK");
        hs.add("EAC");
        hs.add("SE");
        hs.add("1.");
        hs.add("Valley");
        hs.add("TC");
        hs.add("St");
        hs.add("BK");
        hs.add("Club");
        hs.add("GP");
        hs.add("SV");
        hs.add("Duchère");
        hs.add("Vary");

//Giresunspor
       //
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

    public String restCOuntries(String coutryCode){

        RestAssured.baseURI ="https://restcountries.com/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/v3.1/alpha/" +coutryCode);
        if(response.statusCode()==200){
            String getReqRes =
                    given().
                            when().get("/v3.1/alpha/" +coutryCode).
                            then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = new JsonPath(getReqRes);
            reUsableMethods sd = new reUsableMethods();
            String  countryName = js.getString("[0].name.common");
            String  deutschName = js.getString("[0].translations.deu.official");
            String  capital = js.getString("[0].capital[0]");
            String  fifaCode = js.getString("[0].fifa");
            int count=js.getInt("timezones.size()");

            return countryName;
        }else
            return "400 error ";

    }
    public String restCOuntriesTimeZone(String coutryCode){

        RestAssured.baseURI ="https://restcountries.com/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/v3.1/alpha/" +coutryCode);
        if(response.statusCode()==200){
            String getReqRes =
                    given().
                            when().get("/v3.1/alpha/" +coutryCode).
                            then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = new JsonPath(getReqRes);
            reUsableMethods sd = new reUsableMethods();
            String  countryName = js.getString("[0].name.common");
            String  deutschName = js.getString("[0].translations.deu.official");
            String  capital = js.getString("[0].capital[0]");
            String  fifaCode = js.getString("[0].fifa");
            int count=js.getInt("timezones.size()");
            String timeZones="Total timeZones for " + countryName +" = " ;
            for(int i=0;i<count;i++){
                String currentTMZ=js.getString("timezones[ " +i +"]");
                timeZones=timeZones +" " +(i+1) +" " +currentTMZ;
            }

            return timeZones;
        }else
            return "400 error ";

    }
@Test
    public void trueCaller()
    {
       // String fullCountryName =restCOuntries("dz");
        String fullCountryName =restCOuntriesTimeZone("gb");
        System.out.println(fullCountryName);
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        String value = Integer.toBinaryString(N);
        int counter = 0;
        System.out.println("binary value is " +value);
        List<Integer> counters = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current == '0') {
                counter += 1;
            } else {
                counters.add(counter);
                counter = 0;
            }
        }

        return counters.size();
    }
@Test
    public static void raqani(){

        System.out.println(solution(33));
    }

}
