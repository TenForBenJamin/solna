package FPL;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static smith.rowe.randomData.genRandomMgrId;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

import java.lang.reflect.Array;
import java.util.Arrays;

public class fplHistory implements centralTraffice{

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
        int[] m = {12,42,35,24};
        int[] n = {5,47,31,2};
        for(int i=0;i<m.length;i++)
        {
            //System.out.println(m[i]);
        }
        Arrays.sort(m);

        for(int i=0;i<m.length;i++)
        {
            //System.out.println(m[i]);
        }

        System.out.println(solution(m, n));

    }

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    @Override
    public void greenGo() {

    }

    @Override
    public void redStop() {

    }

    @Override
    public void yellowWait() {

    }
}
