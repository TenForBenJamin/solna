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

import static FPL.wordProx.*;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class futbol24Live extends parama{

    @Test
    public void f24LiveGames() throws IOException, InterruptedException {
        driver=initilizeDriver();
        int failureCount=0;
        int statCount=0;
        int methodUtilzationCount=0;
        String debuggerEntry = "debugging instanze";
        String coldestCountryTwoLetter=null;
        String hottestCountryTwoLetter=null;
        float idealWeather=95;
        float lastHottest=0;
        float lastColdest =idealWeather;
        String coldestPlace = "your mind";
        String hotPlace = "your mind";
        HashSet<String> team = new HashSet<String>();
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        Thread.sleep(2000);// (//a/span[@class='f24com_lang'])[1] for live
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        Thread.sleep(5000);
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        if(count>200)// for weekends
        {
            //driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[1]")).click();
            Thread.sleep(4000);
            xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
            count= xpathFinder.size();
        }
        int currentIteration = count;
        List<String> al = new ArrayList<>(count);
        System.out.println(" -------------------XXXXXX___________total matches --------------  " +count +" and currentIteration -------------X-----------" +currentIteration);
        for(int i=0;i<currentIteration;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            team.add(homeTeam);
            al.add(homeTeam); // alCounter=0;alCounter<count
        }
        driver.quit();
        int alCounter=0;
        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();
        String coldestCountry = null;
        String hottestCountry = null;
        String wc;
        Iterator<String > ht = team.iterator();
        while (alCounter<count)
        {
            String realName=al.get(alCounter); // first initialization
            if(realName==debuggerEntry)
                System.out.println("Stop the count ");
            String firstCheckMap=southendReplacement(realName);
            if (firstCheckMap == null)
                wc=wordProcesserV2(realName);
            else {
                wc = firstCheckMap; // caught the exact word
                methodUtilzationCount=methodUtilzationCount+1;
            }
            //String temp= f24Weather(homeTeam).trim();
            String temp= f24Weather(wc).trim(); // real
            temp=temp.trim();
            if(temp.equalsIgnoreCase("400 error")) {
                temp =jorginho(realName);// need to write more logic to extract the failure reason
                if(temp == null)
                    failureCount = failureCount + 1;
            }
            else
            {
                String[] lowe = temp.split(",");
                nat.add(lowe[1]);
                // lowe[1] can be used to trigger the API
                String exTemp= lowe[0];
                float cityTemp = Float.parseFloat(exTemp);
                if(cityTemp<lastColdest)
                {
                    coldestPlace = wc +" " +temp;
                    lastColdest = cityTemp;
                    String[] lander = temp.split(",");
                    coldestCountryTwoLetter=lander[1];
                }
                if(cityTemp>lastHottest)
                {
                    hotPlace = wc +" " +temp;
                    lastHottest = cityTemp;
                    String[] lander = temp.split(",");
                    hottestCountryTwoLetter=lander[1];
                }
            }
            statCount=statCount+1;
            Calendar cal= Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            String tim =sdf.format(cal.getTime());
            System.out.println("Home Team v4 # " + statCount +" is " + realName +" and weather is    ->   "+ temp +"    at " +tim);
            alCounter++;
        }
        System.out.println("Total Failure/Success is " + failureCount + " / " + statCount +" = " +(double)failureCount/(double)statCount +" total Nations involved  " +nat.size());
        System.out.println("methodUtilzationCount --- " +methodUtilzationCount );
        coldestCountry=getCountryName(coldestCountryTwoLetter);
        hottestCountry=getCountryName(hottestCountryTwoLetter);
        System.out.println("coldest place amongst the places is "+coldestPlace +" , "  + coldestCountry +" and is - away  "  +f24Distance(coldestPlace));
        System.out.println("hottest place amongst the places is "+hotPlace +" , "  + hottestCountry +" and is - away  "  +f24Distance(hotPlace));
        System.out.println("Bordering coldest country --- " +restCountriesBoundary(coldestCountryTwoLetter) );
        System.out.println("Bordering hottest country --- " +restCountriesBoundary(hottestCountryTwoLetter) );
    }


       @Test
    public void f24AllGamesV3() throws IOException, InterruptedException {
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
          Thread.sleep(5000);
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

    @Test
    public void f24AllGamesV4() throws IOException, InterruptedException {
        driver=initilizeDriver();
        int failureCount=0;
        int statCount=0;
        int methodUtilzationCount=0;
        String debuggerEntry = "debugging instanze";
        String coldestCountryTwoLetter=null;
        String hottestCountryTwoLetter=null;
        float idealWeather=95;
        float lastHottest=0;
        float lastColdest =idealWeather;
        String coldestPlace = "your mind";
        String hotPlace = "your mind";
        HashSet<String> team = new HashSet<String>();
        HashSet<String>  nat = new HashSet<String>();
        driver.manage().window().maximize();		// maximizing the window
        String uri= "https://www.futbol24.com/Live/?__igp=1&LiveDate=&o=0";
        driver.get(uri);
        Thread.sleep(2000);// (//a/span[@class='f24com_lang'])[1] for live
        driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[2]")).click();
        Thread.sleep(5000);
        List<WebElement> xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
        int count= xpathFinder.size();
        if(count>200)// for weekends
        {
            driver.findElement(By.xpath("(//a/span[@class='f24com_lang'])[1]")).click();
            Thread.sleep(4000);
            xpathFinder   = driver.findElements(By.xpath("//td[@class='home']"));
            count= xpathFinder.size();
        }
        int currentIteration = count;
        List<String> al = new ArrayList<>(count);
        System.out.println(" -------------------XXXXXX___________total matches --------------  " +count +" and currentIteration -------------X-----------" +currentIteration);
        for(int i=0;i<currentIteration;i++)
        {
            String homeTeam=xpathFinder.get(i).getText();
            homeTeam=homeTeam.trim();
            team.add(homeTeam);
            al.add(homeTeam); // alCounter=0;alCounter<count
        }
        driver.quit();
        int alCounter=0;
        float ratiao=failureCount/count;
        Iterator<String> e = nat.iterator();
        String coldestCountry = null;
        String hottestCountry = null;
        String wc;
        Iterator<String > ht = team.iterator();
        while (alCounter<count)
        {
            String realName=al.get(alCounter); // first initialization
            if(realName==debuggerEntry)
                System.out.println("Stop the count ");
            String firstCheckMap=southendReplacement(realName);
            if (firstCheckMap == null)
                wc=wordProcesserV2(realName);
            else {
                wc = firstCheckMap; // caught the exact word
                methodUtilzationCount=methodUtilzationCount+1;
            }
            //String temp= f24Weather(homeTeam).trim();
            String temp= f24Displacement(wc).trim(); // real
            temp=temp.trim();
            if(temp.equalsIgnoreCase("400 error")) {
                temp =jorginho(realName);// need to write more logic to extract the failure reason
                if(temp == null)
                    failureCount = failureCount + 1;
            }
            else
            {
                /*
                String[] lowe = temp.split(",");
                nat.add(lowe[1]);
                // lowe[1] can be used to trigger the API
                String exTemp= lowe[0];
                float cityTemp = Float.parseFloat(exTemp);
                if(cityTemp<lastColdest)
                {
                    coldestPlace = wc +" " +temp;
                    lastColdest = cityTemp;
                    String[] lander = temp.split(",");
                    coldestCountryTwoLetter=lander[1];
                }
                if(cityTemp>lastHottest)
                {
                    hotPlace = wc +" " +temp;
                    lastHottest = cityTemp;
                    String[] lander = temp.split(",");
                    hottestCountryTwoLetter=lander[1];
                }*/
            }
            statCount=statCount+1;
            Calendar cal= Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            String tim =sdf.format(cal.getTime());
            System.out.println("Home Team v4 # " + statCount +" is " + realName +" and weather is    ->   "+ temp +"    at " +tim);
            alCounter++;
        }
   /*System.out.println("Total Failure/Success is " + failureCount + " / " + statCount +" = " +(double)failureCount/(double)statCount +" total Nations involved  " +nat.size());
        System.out.println("methodUtilzationCount --- " +methodUtilzationCount );
        coldestCountry=getCountryName(coldestCountryTwoLetter);
        hottestCountry=getCountryName(hottestCountryTwoLetter);
        System.out.println("coldest place amongst the places is "+coldestPlace +" , "  + coldestCountry +" and is - away  "  +f24Distance(coldestPlace));
        System.out.println("hottest place amongst the places is "+hotPlace +" , "  + hottestCountry +" and is - away  "  +f24Distance(hotPlace));
        System.out.println("Bordering coldest country --- " +restCountriesBoundary(coldestCountryTwoLetter) );
        System.out.println("Bordering hottest country --- " +restCountriesBoundary(hottestCountryTwoLetter) );*/
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

    public  Double f24Distance(String place)
    {
        String[] pla = place.split(" ");
        place=pla[0];
        RestAssured.baseURI =baseUrlopenWeather;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.queryParam("q", place).queryParam("appid", apiKey).queryParam("units", "metric");
        Response response = httpRequest.request(Method.GET,"data/2.5/weather");

            String getReqRes =
                    given().
                            queryParam("q", place).
                            queryParam("appid", apiKey).
                            queryParam("lang", OpCo).queryParam("units", "metric").
                            when().get("data/2.5/weather").
                            then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = new JsonPath(getReqRes);
            String  latS = js.getString("coord.lat");
            String lonS = js.getString("coord.lon");
            String nameOfPlace = js.getString("name");
            //coundry=restCOuntries(coundry);
        if(300>200){
            double lat = Double.parseDouble(latS);
            double lon = Double.parseDouble(lonS);
            double Coordx= malta(lat,lon);
            DecimalFormat df = new DecimalFormat("#.##"); // pattern for two decimal places
            double roundedNumber = Double.parseDouble(df.format(Coordx));
            //35.8922 , 14.5183
            return roundedNumber;
        }else
            return 400.0;
    }
    public  String f24Displacement(String place)
    {
        String[] pla = place.split(" ");
        place=pla[0];
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
            String  latS = js.getString("coord.lat");
            String lonS = js.getString("coord.lon");
            String nameOfPlace = js.getString("name");
            //coundry=restCOuntries(coundry);
            double lat = Double.parseDouble(latS);
            double lon = Double.parseDouble(lonS);
            double Coordx= malta(lat,lon);
            DecimalFormat df = new DecimalFormat("#.##"); // pattern for two decimal places
            double roundedNumber = Double.parseDouble(df.format(Coordx));
            String  mainTemp = js.getString("main.temp");
            String coundry = js.getString("sys.country");
            //coundry=restCOuntries(coundry);
            mainTemp= roundedNumber +"," +coundry;
            return mainTemp;
        }else
            return "400 error ";

    }
    @Test
    public Double malta(double lat2, double lon2) {
        // required params are lat2,lon2 and cityName

        double lat1 = 35.8922; // Malta latitude
        double lon1 = 14.5183; // Malta longitude
        // New York City longitude
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        // System.out.printf("The distance between you and other city is %.2f km.", distance);
        // String chain="The distance between you and other city is %.2f km."+ distance;
        return distance;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double EARTH_RADIUS = 6371; // in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
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
            return "400 error";

    }
@Test
    public void trueCaller()
    {
        String oTS="Austria";
        System.out.println(" One Time Search result for "+oTS +"  - " +f24Distance(oTS));

        /*
        //String timeZonesOfCountry =restCountriesTmzV2("mlt");
        String fullCountryName =getCountryName("GT");
        System.out.println("Response - " +fullCountryName);
        String bordersOfNation =restCountriesBoundary("GT"); // to get the border field
        System.out.println("Response - " +bordersOfNation);

       // System.out.println("Response - " +timeZonesOfCountry);
        //String testSring =arrayProcesserV2("AND]");
        //System.out.println("Printer is " +testSring);//Sampaio Correa/MA
        String brazillianName="Caruaru City/PE";
        System.out.println("wcBrazillianName  - " +brazilClubIdentifier(brazillianName));*/

    }
    public String jorginho(String j5)
    {
            String wc;
        String realName=j5; // first initialization
        String firstCheckMap=southendReplacement(realName);
        if (firstCheckMap == null)
            wc=wordProcesserV2(realName);
        else
            wc=firstCheckMap;

            //String temp= f24Weather(homeTeam).trim();
            String temp= f24Weather(wc).trim();
            temp=temp.trim();
            if(temp.equalsIgnoreCase("400 error")) {
                 // need to write more logic to extract the failure reason
                // Likely reason nonPlace related name.
                //System.out.println("Need to check if replacement exists for  " +wc);//Sampaio Correa/MA
                // need to have a keyValue pair to fix the problem example NS Mura vs Murska sobota
                temp=null;
                //temp=southendReplacement(j5);
                if (temp == null) {
                   // System.out.println("Need to work more for   " +j5);
                }
                else
                   temp= f24Weather(temp).trim();
            }
            else
            {
                String[] lowe = temp.split(",");
                // lowe[1] can be used to trigger the API
                String exTemp= lowe[0];
                float cityTemp = Float.parseFloat(exTemp);

            }
            return temp;

    }
@Test
    public static void mainz()
    {
        boolean t = true;
        first : {
            second : {
                third : {
                    System.out.println("Before the break");
                    if (t) // break out of second block
                        break second;
                }
                System.out.println("This won't execute");
            }
            System.out.println("This is after the second block");
        }
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
