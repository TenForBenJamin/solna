package FPL;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
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
      int randomManagerId= genRandomMgrId();

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
         //team Name //div[@class='Entry__TeamName-sc-1kf863-1 inZJya']
         String teamName= driver.findElement(By.xpath("//div[@class='Entry__TeamName-sc-1kf863-1 inZJya']")).getText() ;
         // managerName //div[@class='Entry__EntryName-sc-1kf863-0 cMEsev']
         String managerName= driver.findElement(By.xpath("//div[@class='Entry__EntryName-sc-1kf863-0 cMEsev']")).getText() ;
         //transfers //div[@class='EntryEvent__SecondaryValue-l17rqm-14 EntryEvent__TransfersValue-l17rqm-15 sRSFe diuHJS']
         String transfers= driver.findElement(By.xpath("//div[@class='EntryEvent__SecondaryValue-l17rqm-14" +
                 " EntryEvent__TransfersValue-l17rqm-15 sRSFe diuHJS']")).getText() ;
         //GWR (//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[3]
         String GWR= driver.findElement(By.xpath("(//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[3]")).getText() ;
         // avgPts (//div[@class='EntryEvent__SecondaryValue-l17rqm-14 sRSFe'])[1]
         // sideBar (//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[8]
         String ovrPts= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[1]")).getText() ;
         String ovrRank= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[2]")).getText() ;
         String TotalPlys= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[3]")).getText() ;
         String gwPtsLastUpdated= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[4]")).getText() ;
         String totalTransfers= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[5]")).getText() ;
         String squadValue= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[6]")).getText() ;
         String remBalance= driver.findElement(By.xpath("(//div[@class='Entry__DataListValue-sc-1kf863-5 jUtEoF'])[7]")).getText() ;
         String[] latestPoints = fp.split("\n");
         fp=latestPoints[0];
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
