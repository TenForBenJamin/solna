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
         String[] latestPoints = fp.split("\n");
         fp=latestPoints[0];
         System.out.println("LatestPoints is for User  " +randomManagerId  +" is " +fp);
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
