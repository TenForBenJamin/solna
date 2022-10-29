package FPL;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static smith.rowe.randomData.genRandomMgrId;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fplJsonLib extends  parama{

   @Test
    public void differdange() throws IOException {
       int randomManagerId= genRandomMgrId();

       System.out.println(" Testing FPL  - " +randomManagerId );
       RestAssured.baseURI ="https://fantasy.premierleague.com";
       String getReqRes =
               given().
                       when().get("/api/entry/" + randomManagerId   +"/history/").
                       then().assertThat().statusCode(200).extract().response().asString();
       JsonPath js = new JsonPath(getReqRes);
       reUsableMethods sd = new reUsableMethods();
       // sd.coordsExtractor(getReqRes);
       //sd.fplJsonExtraction(getReqRes);
      //look for hidden champ, if the any of the rank is under 1000 fail the testcase
       sd.fplFirstSeasonsCount(getReqRes);
       sd.fplPastSeasonsDetails(getReqRes);
   }
@Test
   public void findingNeedleInHayStack() throws IOException {
      int randomManagerId= genRandomMgrId();
      System.out.println(" Testing FPL  - " +randomManagerId );
      RestAssured.baseURI ="https://fantasy.premierleague.com";
      String getReqRes =
              given().
                      when().get("/api/entry/" + randomManagerId   +"/history/").
                      then().assertThat().statusCode(200).extract().response().asString();
      JsonPath js = new JsonPath(getReqRes);
      reUsableMethods sd = new reUsableMethods();
      Boolean lowRank = sd.lowRankFinder(getReqRes);
      if(lowRank){
          assertEquals(false ,true,"Failed due to length of Rank less than 6 digits - ");
      }
   }
   @Test
   public void fplAPIwithWeb() throws IOException {
      int randomManagerId= genRandomMgrId();

      System.out.println(" Testing FPL  - " +randomManagerId );
      RestAssured.baseURI ="https://fantasy.premierleague.com";
      String getReqRes =
              given().
                      when().get("/api/entry/" + randomManagerId   +"/history/").
                      then().assertThat().statusCode(200).extract().response().asString();
      JsonPath js = new JsonPath(getReqRes);
      reUsableMethods sd = new reUsableMethods();
      // sd.coordsExtractor(getReqRes);
      //sd.fplJsonExtraction(getReqRes);
      sd.fplFirstSeasonsCount(getReqRes);
      sd.fplPastSeasonsDetails(getReqRes);
      driver=initilizeDriver();
      driver.manage().window().maximize();		// maximizing the window
      int  gameweek =13 ;
      String uri= "https://fantasy.premierleague.com/entry/" + randomManagerId + "/event/"+ gameweek ;
      driver.get(uri);
      // xPath for LatestPoints = //*[@id="root"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/div
      // //div[@class="EntryEvent__PrimaryValue-l17rqm-4 fryVza"]
      String kanda = initilizeBrowser();
      //System.out.println("browser is   "+kanda);
      String fp= driver.findElement(By.xpath("//div[@class='EntryEvent__PrimaryValue-l17rqm-4 fryVza']")).getText() ;
      String[] latestPoints = fp.split("\n");
      fp=latestPoints[0];
      System.out.println("LatestPoints is for User  " +randomManagerId  +" is " +fp);
      driver.quit();
   }
   @Test
      public void fplAPIwithWebScrapper() throws IOException {
      //int randomManagerId= genRandomMgrId();
      int randomManagerId= 1;
      System.out.println(" Testing FPL  - " +randomManagerId );
      RestAssured.baseURI ="https://fantasy.premierleague.com";
      String getReqRes =
              given().
                      when().get("/api/entry/" + randomManagerId   +"/history/").
                      then().assertThat().statusCode(200).extract().response().asString();
      JsonPath js = new JsonPath(getReqRes);
      reUsableMethods sd = new reUsableMethods();

      for(int randomMgId=randomManagerId;randomMgId<(randomManagerId+12);randomMgId++){
         driver=initilizeDriver();
         driver.manage().window().maximize();		// maximizing the window
         int  gameweek =13 ;
         String uri= "https://fantasy.premierleague.com/entry/" + randomMgId + "/event/"+ gameweek ;
         driver.get(uri);
         String kanda = initilizeBrowser();
         String fp= driver.findElement(By.xpath("//div[@class='EntryEvent__PrimaryValue-l17rqm-4 fryVza']")).getText() ;
         String teamName= driver.findElement(By.xpath("//div[@class='Entry__TeamName-sc-1kf863-1 inZJya']")).getText() ;
         String managerName= driver.findElement(By.xpath("//div[@class='Entry__EntryName-sc-1kf863-0 cMEsev']")).getText() ;
         String transfers= driver.findElement(By.xpath("//div[@class='EntryEvent__SecondaryValue-l17rqm-14" +
                 " EntryEvent__TransfersValue-l17rqm-15 sRSFe diuHJS']")).getText() ;
         String GWR= driver.findElement(By.xpath("(//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[3]")).getText() ;
         String ovrPts= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[1]")).getText() ;
         String ovrRank= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[2]")).getText() ;
         String TotalPlys= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[3]")).getText() ;
         String gwPtsLastUpdated= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[4]")).getText() ;
         String totalTransfers= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[5]")).getText() ;
         String squadValue= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[6]")).getText() ;
         String remBalance= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[7]")).getText() ;
         String[] latestPoints = fp.split("\n");
         fp=latestPoints[0];
         //document.getElementsByClassName("Pitch__StyledPitchElement-sc-1mctasb-5 jLgWIY")[8].innerText - For spielerDetail


         System.out.println("LatestPoints is for User  " +randomMgId  +" is " +fp);
         System.out.println("managerName is for User  " +randomMgId  +" is " +managerName);
         System.out.println("teamName is for User  " +randomMgId  +" is " +teamName);
         System.out.println("transfers is for User  " +randomMgId  +" is " +transfers);
         System.out.println("overall points " +ovrPts  +" overallRank " +ovrRank +" GW pts lastUpdate " +gwPtsLastUpdated);
         System.out.println("total  Transfers " +totalTransfers );
         System.out.println("squadValue  " +squadValue  +" remainingBalance " +remBalance);
         sd.fplPastSeasonsDetails(getReqRes);
         driver.quit();
      }

   }

   public void singleIdScrapper(int ID) throws IOException {

      int randomManagerId= ID;
      for(int randomMgId=randomManagerId;randomMgId<(randomManagerId+1);randomMgId++){
         driver=initilizeDriver();
         driver.manage().window().maximize();		// maximizing the window
         int  gameweek =13 ;
         String uri= "https://fantasy.premierleague.com/entry/" + randomMgId + "/event/"+ gameweek ;
         driver.get(uri);
         String kanda = initilizeBrowser();
         String fp= driver.findElement(By.xpath("//div[@class='EntryEvent__PrimaryValue-l17rqm-4 fryVza']")).getText() ;
         String teamName= driver.findElement(By.xpath("//div[@class='Entry__TeamName-sc-1kf863-1 inZJya']")).getText() ;
         String managerName= driver.findElement(By.xpath("//div[@class='Entry__EntryName-sc-1kf863-0 cMEsev']")).getText() ;
         String transfers= driver.findElement(By.xpath("//div[@class='EntryEvent__SecondaryValue-l17rqm-14" +
                 " EntryEvent__TransfersValue-l17rqm-15 sRSFe diuHJS']")).getText() ;
         String GWR= driver.findElement(By.xpath("(//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[3]")).getText() ;
         String ovrPts= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[1]")).getText() ;
         String ovrRank= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[2]")).getText() ;
         String TotalPlys= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[3]")).getText() ;
         String gwPtsLastUpdated= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[4]")).getText() ;
         String totalTransfers= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[5]")).getText() ;
         String squadValue= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[6]")).getText() ;
         String remBalance= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[7]")).getText() ;
         String[] latestPoints = fp.split("\n");
         fp=latestPoints[0];
         //document.getElementsByClassName("Pitch__StyledPitchElement-sc-1mctasb-5 jLgWIY")[8].innerText - For spielerDetail


         System.out.println("LatestPoints is for User  " +randomMgId  +" is " +fp);
         System.out.println("managerName is for User  " +randomMgId  +" is " +managerName);
         System.out.println("teamName is for User  " +randomMgId  +" is " +teamName);
         System.out.println("transfers is for User  " +randomMgId  +" is " +transfers);
         System.out.println("overall points " +ovrPts  +" overallRank " +ovrRank +" GW pts lastUpdate " +gwPtsLastUpdated);
         System.out.println("total  Transfers " +totalTransfers );
         System.out.println("squadValue  " +squadValue  +" remainingBalance " +remBalance);

         driver.quit();
      }
   }

   public void singleIdScrapperOvrPts(int ID) throws IOException {

      int randomManagerId= ID;
      for(int randomMgId=randomManagerId;randomMgId<(randomManagerId+1);randomMgId++){
         driver=initilizeDriver();
         driver.manage().window().maximize();		// maximizing the window
         int  gameweek =14 ;
         String uri= "https://fantasy.premierleague.com/entry/" + randomMgId + "/event/"+ gameweek ;
         driver.get(uri);
         String fp= driver.findElement(By.xpath("//div[@class='EntryEvent__PrimaryValue-l17rqm-4 fryVza']")).getText() ;
         String teamName= driver.findElement(By.xpath("//div[@class='Entry__TeamName-sc-1kf863-1 inZJya']")).getText() ;
         String managerName= driver.findElement(By.xpath("//div[@class='Entry__EntryName-sc-1kf863-0 cMEsev']")).getText() ;
         String transfers= driver.findElement(By.xpath("//div[@class='EntryEvent__SecondaryValue-l17rqm-14" +
                 " EntryEvent__TransfersValue-l17rqm-15 sRSFe diuHJS']")).getText() ;
         String GWR= driver.findElement(By.xpath("(//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[3]")).getText() ;
         String ovrPts= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[1]")).getText() ;
         String ovrRank= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[2]")).getText() ;
         String TotalPlys= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[3]")).getText() ;
         String gwPtsLastUpdated= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[4]")).getText() ;
         String totalTransfers= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[5]")).getText() ;
         String squadValue= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[6]")).getText() ;
         String remBalance= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[7]")).getText() ;
         String[] latestPoints = fp.split("\n");
         fp=latestPoints[0];
         /*
         String xPathClasser = "//div[@class='Pitch__PitchElementWrap-sc-1mctasb-4 bWWBeR notranslate']";
         List<WebElement> allInputElementsV   = driver.findElements(By.cssSelector(".PitchElementData__ElementValue-sc-1u4y6pr-1"));
         List<WebElement> allInputElementsN   = driver.findElements(By.cssSelector(".PitchElementData__ElementName-sc-1u4y6pr-0"));
         List<WebElement> xpathFinder   = driver.findElements(By.xpath(xPathClasser));
*/
         for(int plyr=0;plyr<15;plyr++) {
            String Prossy =driver.findElement(By.xpath("(//*[@class='Pitch__PitchElementWrap-sc-1mctasb-4 bWWBeR notranslate'])[" + (plyr+1) +"]")).getText() ;
            //System.out.println("Raw string " +Prossy) ;
            String[] playerDetails = Prossy.split("\n");
             int splittedStringSize = playerDetails.length;
             if(splittedStringSize==1){
                JavascriptExecutor js = (JavascriptExecutor)driver;
                System.out.println("Missing Plyr") ;
                Prossy = driver.findElement(By.xpath("(//*[@class='PitchElementData__StyledPitchElementData-sc-1u4y6pr-0 gTayAP'])[" + (plyr+1) +"]")).getText() ;
                //String PlyName ="playerDetails[0]";
                //System.out.println(PlyName);

             }
             else {
                String PlyName =playerDetails[0];
                String PlyPoints=playerDetails[1];
                //System.out.println(PlyName);
                String impStuff ="" +PlyName+" " +PlyPoints;
                System.out.println(impStuff);
             }


             //PitchElementData__ElementValue-sc-1u4y6pr-2 fQREvA
            //String PlyPoints=driver.findElement(By.xpath("(//div[@class='PitchElementData__ElementValue-sc-1u4y6pr-2 fQREvA'])[" + (plyr+1) +"]")).getText();
            //String impStuff ="" +PlyName+" " +PlyPoints;
            //System.out.println(impStuff);

         }
         //System.out.println("overall points " +ovrPts  +" overallRank " +ovrRank +" GW pts lastUpdate " +gwPtsLastUpdated);
         driver.quit();
      }
   }
   @Test
   public void earlyBirdsFPL(){
      int randomManagerId= 1;
      for(int randomMgId=randomManagerId;randomMgId<5;randomMgId++) {
         System.out.println(" Testing FPL  - " + randomMgId);
         RestAssured.baseURI = "https://fantasy.premierleague.com";
         String getReqRes =
                 given().
                         when().get("/api/entry/" + randomMgId + "/history/").
                         then().assertThat().statusCode(200).extract().response().asString();
         JsonPath js = new JsonPath(getReqRes);
         reUsableMethods sd = new reUsableMethods();
         sd.fplPastSeasonsDetails(getReqRes);
      }

   }
@Test
   public void superEarlyBirdsFPL() throws IOException {
      int randomManagerId= 1;
      int counter=0;
      for(int randomMgId=randomManagerId;randomMgId<1000;randomMgId++) {
         //System.out.println(" FPL managerID  - " + randomMgId);
         RestAssured.baseURI = "https://fantasy.premierleague.com";
         String getReqRes =
                 given().
                         when().get("/api/entry/" + randomMgId + "/history/").
                         then().assertThat().statusCode(200).extract().response().asString();
         JsonPath js = new JsonPath(getReqRes);
         reUsableMethods sd = new reUsableMethods();
         //Boolean lowRank = sd.lowRankFinderThreeDigits(getReqRes);
         //Boolean lowRank = sd.lowRankFinderFourDigits(getReqRes);
         Boolean lowRank = sd.lowRankFinderConsistant10K(getReqRes);
         int seasonCount = sd.fplPastSeasonsCount(getReqRes);
         if(lowRank){
            //sd.fplPastSeasonsDetails(getReqRes);
            counter=counter+1;
            //singleIdScrapper(randomMgId);
            singleIdScrapperOvrPts(randomMgId);
            System.out.println(" FPL managerID  - " + randomMgId +" and Total seasons " +seasonCount);
         }
         //System.out.println(" FPL managerID  - " + randomMgId +" and Total seasons " +seasonCount);

      }
   System.out.println("Gems unearthed = "+counter);
   }
   @Test
   public void superEarlyNoLogsFPL() throws IOException {
      int randomManagerId= 1200;
      int counter=0;
      ArrayList a =new ArrayList();
      for(int randomMgId=randomManagerId;randomMgId<1250;randomMgId++) {
         //System.out.println(" FPL managerID  - " + randomMgId);
         RestAssured.baseURI = "https://fantasy.premierleague.com";
         String getReqRes =
                 given().
                         when().get("/api/entry/" + randomMgId + "/history/").
                         then().assertThat().statusCode(200).extract().response().asString();
         JsonPath js = new JsonPath(getReqRes);
         reUsableMethods sd = new reUsableMethods();
         //Boolean lowRank = sd.lowRankFinderThreeDigits(getReqRes);
         //Boolean lowRank = sd.lowRankFinderFourDigits(getReqRes);
         Boolean lowRank = sd.lowRankFinderConsistant10K(getReqRes);
         int seasonCount = sd.fplPastSeasonsCount(getReqRes);
         if(lowRank){
            //sd.fplPastSeasonsDetails(getReqRes);
            counter=counter+1;
            //singleIdScrapper(randomMgId);
           // singleIdScrapperOvrPts(randomMgId);
            System.out.println(" FPL managerID  - " + randomMgId +" and Total seasons " +seasonCount);
            a.add(randomMgId);
            //sd.fplPastSeasonsDetails(getReqRes);
         }
         //System.out.println(" FPL managerID  - " + randomMgId +" and Total seasons " +seasonCount);

      }
   System.out.println("Gems unearthed = "+counter);
      for(int ar=0;ar<a.size();ar++) {
         //System.out.println(a.get(ar));
         singleIdScrapperOvrPts((Integer) a.get(ar));
      }
   }

   @Test
   public void callerFPL() throws IOException {

      //singleIdScrapper(923);genRandomMgrId()
      int randomManagerId= genRandomMgrId();
      System.out.println(randomManagerId);
      singleIdScrapperOvrPts(randomManagerId);
   }

   @Test
   public void jsonMan() throws IOException {

      JSONObject obj=new JSONObject();
      obj.put("managerId","232124");
      obj.put("firstSeason","232124");
      obj.put("Seasons","232124");
      obj.put("Remark","232124");

      FileWriter file = new FileWriter("jason\\test.json",false);
      file.write(obj.toJSONString());
      file.close();

   }


}
