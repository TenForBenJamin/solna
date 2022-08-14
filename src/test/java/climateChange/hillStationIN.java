package climateChange;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import objectRepo.parama;
import smith.rowe.climateClouds;

public class hillStationIN  extends parama {

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[21][2];

        data[0][0]="Nainital,IN";
        data[0][1]="UK";

        data[1][0]="Gangtok";
        data[1][1]="Sikkim";

        data[2][0]="Mount Abu";
        data[2][1]="Rajastan";

        data[3][0]="Lunglei";
        data[3][1]="Mizoram";

        data[4][0]="Almora";
        data[4][1]="UK";

        data[5][0]="Mahabaleshwar";
        data[5][1]="MH";

        data[6][0]="Lonavala";
        data[6][1]="MH";

        data[7][0]="Kumily";
        data[7][1]="Kerala";

        data[8][0]="Rajgir";
        data[8][1]="Bihar";

        data[9][0]="Vythiri";
        data[9][1]="Kerala";

        data[10][0]="Aru,IN";
        data[10][1]="JnK";

        data[11][0]="Chikkamagaluru";
        data[11][1]="KA";

        data[12][0]="Pushpagiri";
        data[12][1]="KA";

        data[13][0]="Gulmarg";
        data[13][1]="JnK";

        data[14][0]="Tirumala";
        data[14][1]="AP";

        data[15][0]="Bhaderwah";
        data[15][1]="JnK";

        data[16][0]="Patnitop";
        data[16][1]="JnK";

        data[17][0]="Kasol";
        data[17][1]="HP";

        data[18][0]="Yelagiri";
        data[18][1]="TN";

        data[19][0]="Yercaud";
        data[19][1]="TN";

        data[20][0]="Tawang";
        data[20][1]="Arunachal";

        return data;
    }

    @Test(dataProvider="getData")
    public void random2oHillstationIN(String ort , String comp) throws IOException
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
        climateClouds sd = new climateClouds();
        // sd.coordsExtractor(getReqRes);
        sd.simbleDaylengthPrintAssert(getReqRes," Hill Station details ");
        //sd.simbleDaylengthPrint(getReqRes," Hill Station details ");

    }
}
