package FPL;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static smith.rowe.randomData.genRandomMgrId;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

public class fplHistory extends parama {

    // here we need to pass the managerId and get the history , input is String
   @Test
    public void fplPastHistory() {

       //https://fantasy.premierleague.com/api/entry/3283365/history/
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
       sd.fplPasthistoryFirstSeason(getReqRes);

   }
    @Test
    public void fplrandomGen() {
        System.out.println(" random  : " + genRandomMgrId());

    }

}
