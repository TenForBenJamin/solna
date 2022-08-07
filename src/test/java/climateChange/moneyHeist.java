package climateChange;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static smith.rowe.randomData.genRandomCapitalName;

import java.io.IOException;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import objectRepo.reUsableMethods;

public class moneyHeist extends parama {

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[15][2];

        data[0][0]="Helsinki";
        data[0][1]="Group A";

        data[1][0]="Oslo";
        data[1][1]="Group B";

        data[2][0]="Stockholm";
        data[2][1]="Group C";

        data[3][0]="Nairobi";
        data[3][1]="Group D";

        data[4][0]="Manila";
        data[4][1]="Group E";

        data[5][0]="Berlin";
        data[5][1]="Group F";

        data[6][0]="marseille";
        data[6][1]="Group E";

        data[7][0]="Palermo";
        data[7][1]="Group F";

        data[8][0]="Nairobi";
        data[8][1]="Group D";

        data[9][0]="Tokyo";
        data[9][1]="Group E";

        data[10][0]="Rio";
        data[10][1]="Group F";

        data[11][0]="Denver";
        data[11][1]="Group A";

        data[12][0]="Moscow";
        data[12][1]="Group B";

        data[13][0]="pamplona";
        data[13][1]="Group C";

        data[14][0]="Bogota";
        data[14][1]="Group C";

        return data;
    }

@Test(dataProvider="getData")
    public void proffessor(String ort , String comp) throws IOException
    {
        System.out.println(" place " +ort);
        String apiKey=schussel();
        RestAssured.baseURI =baseUrlopenWeather;
        String getReqRes =
                given().
                        queryParam("q", ort).
                        queryParam("appid", apiKey).
                        queryParam("lang", OpCo).queryParam("units", "metric").
                        when().get("data/2.5/weather").
                        then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(getReqRes);
        reUsableMethods sd = new reUsableMethods();
        // sd.coordsExtractor(getReqRes);
        sd.simbleDaylengthPrint(getReqRes," Capital details ");
        String  mainTemp = js.getString("main.temp");
    }
}
