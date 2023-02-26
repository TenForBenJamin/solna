package FPL;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectRepo.reUsableMethods;

import java.util.*;

import static io.restassured.RestAssured.given;

public class wordProx {

    public static String wordProcesserV2(String homeTeam)
    {
        HashSet<String> hs = new HashSet<String>();
        // next additions -  Bullets Rangers &  hs.add("Unido");
        hs.add("Zelvia");
        hs.add("Unido");
        hs.add("Sepasi");
        hs.add("Africa");
        hs.add("OSC");
        hs.add("County");
        hs.add("AC");
        hs.add("Shenhua");
        hs.add("Tunisien");
        hs.add("Stars");
        hs.add("Shenhua");
        hs.add("Bullets");
        hs.add("Rangers");
        hs.add("Cities");
        hs.add("Glory");
        hs.add("09");
        hs.add("Town");
        hs.add("Park");
        hs.add("Zeiss");
        hs.add("Sporting");
        hs.add("Bld.");
        hs.add("Rovers");
        hs.add("District");
        hs.add("VV");
        hs.add("Market");
        hs.add("Hotspurs");
        hs.add("Spartans");
        hs.add("Fotboll");
        hs.add("Al");
        hs.add("Hainiu");
        hs.add("IK");
        hs.add("Cuju");
        hs.add("Lions");
        hs.add("SE");
        hs.add("fB");
        hs.add("IF");
        hs.add("C.");
        hs.add("United");
        hs.add("City");
        hs.add("IL");
        hs.add("B");
        hs.add("FC");
        hs.add("FK");
        hs.add("U20");
        hs.add("II");
        hs.add("32");
        hs.add("MTE");
        hs.add("U19");
        hs.add("U16");
        hs.add("U17");
        hs.add("U23");
        hs.add("Blasters");
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

        Iterator<String> i=hs.iterator();
        Boolean flag = false;
        String[] result = homeTeam.split(" ");
        if(result.length<2){
            homeTeam=result[0];
            homeTeam=brazilClubIdentifier(homeTeam);
        }
        else {
            homeTeam = result[1];
            while(i.hasNext())
            {
                String macher = i.next();
                if(homeTeam.equalsIgnoreCase(macher))
                    flag=true;// second word is cliche
            }
            if(flag){
                //if "/" is found then split and take the first word
                homeTeam=brazilClubIdentifier(result[0]);
            }
        }
          return homeTeam;
    }

    public static String brazilClubIdentifier(String clubName){
        // example Palmeiras/SP Youth , Jacuipense/BA Lagarto/SE
        String brazilClubs =clubName;
        String[] br_result = brazilClubs.split("/");
        String op;
        if(br_result.length<2)
            op=clubName;
        else
            op=br_result[0];

        return op;
    }

    public static String southendReplacement(String clubName){
        HashMap<String,String> hm = new HashMap<String,String>();
        String originalKeyName=null;
        // Paola Heredia Paola hm.put("Kerala Blasters","Kochi,IN");
        String paola=null;
        hm.put("Hertha BSC","Berlin,DE");
        hm.put("Cavalier FC","Kingston,JM");
        hm.put("Kerala Blasters","Kochi,IN");
        hm.put("FK Ekranas","Panevėžys");
        hm.put("Asane Fotball","Åsane");
        hm.put("Ferroviário/CE","Fortaleza");
        hm.put("Gol Gohar","Sīrjān");
        hm.put("CS Herediano","heredia,CR");
        hm.put("KF Malisheva","Prizren,XK");
        hm.put("Yadanarbon FC","Mandalay,MM");
        hm.put("CD Guabirá","Montero,Bo");
        hm.put("Antigua GFC","Antigua,GT");
        hm.put("Hertha BSC II","Berlin,DE");
        hm.put("Raya2 Expansión","Monterrey,MX");
        hm.put("Formartine United","Pitmedden,GB");
        hm.put("Rld alajuelense","Alajuela,CR");
        hm.put("Real Kashmir FC","Srinagar,IN");
        hm.put("AFC Leopards","Nairobi");
        hm.put("Port FC","Khlong Toei");
        hm.put("Hibernians Paola","Paola,MT");
        hm.put("Samut Prakan City","Samut Prakan");
        hm.put("Rivers United","Port Harcourt");
        hm.put("CA Vianés","La Rioja");
        hm.put("Viking FK Youth","Stavanger");
        hm.put("Viking FK","Stavanger");
        hm.put("CD Numancia","Soria,ES");
        hm.put("SønderjyskE","Haderslev,DK");
        hm.put("Al Qaisoma","Qaisumah,SA");
        hm.put("St Albans City","St Albans,GB");
        hm.put("Platinum City Rovers FC","Potchefstroom");
        hm.put("Al Akhdood","Najran,SA");
        hm.put("Hapoel Qalansawe","Qalansawe");
        hm.put("Kapaz PFK II","Ganja,AZ");
        hm.put("Kapaz PFK","Ganja,AZ");
        hm.put("Hapoel Petah Tikva","Petah Tikva");




        Set sn=hm.entrySet();
        Iterator it= sn.iterator();
        while(it.hasNext())
        {
            //String macher = it.next();
            Map.Entry mp=( Map.Entry)it.next();
             originalKeyName=mp.getKey().toString();
            //System.out.println("search value is " +mp.getValue());
            if(clubName.equalsIgnoreCase(originalKeyName))
                paola=mp.getValue().toString();// second word is cliche
        }
        //System.out.println("realValue is  value is " +paola);
        return paola;
    }
    public static String restCountriesBoundary(String coutryCode){

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
            int count=js.getInt("borders.size()");
            String allBorders="BorderNations of " + countryName +" = " ;
            String totalBorders=js.getString("borders[0]");
            if(totalBorders==null) {
                 allBorders=countryName + "  has No Borders";
            }
            else {
            String[] tzCount = totalBorders.split(",");
            int totalTZ=tzCount.length;
            System.out.println("total bordering nations - " +totalTZ);
            for(int i=0;i<totalTZ;i++){
                String temp = arrayProcesserV2(tzCount[i]); // need to replace "[" and "]" array prox
                String threeLetterCountryCode=temp;
                String currentBorderingNation=getCountryName(temp);
                allBorders= allBorders +" " + currentBorderingNation +", "  ;
                System.out.println( "Nation " +(i+1) +" is " + threeLetterCountryCode +"," +currentBorderingNation);
               // allBorders=allBorders +" " +(totalTZ) +" " +totalBorders;
            }
            }
            return allBorders;
        }else
            return "400 error ";

    }
    public static String restCountriesTmzV2(String coutryCode){

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
                String[] tzCount = currentTMZ.split(",");
                int totalTZ=tzCount.length;

                timeZones=timeZones +" " +(totalTZ) +" " +currentTMZ;
            }
            return countryName +"  and TMZ details  -  " + timeZones;
        }else
            return "400 error ";

    }

    public static String arrayProcesserV2(String arrazItem)
    {
        String[] tzCount = arrazItem.split("\\]");
        int totalTZ=tzCount.length;
            arrazItem=tzCount[0];

        String[] backBracCount = arrazItem.split("\\[");
        int totalbackBracCount=backBracCount.length;
        if(totalbackBracCount>1)
            arrazItem=backBracCount[1];
        arrazItem=arrazItem.trim();
        return arrazItem;
    }

    public static String getCountryName(String coutrycode){


        RestAssured.baseURI ="https://restcountries.com/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/v3.1/alpha/" +coutrycode);
        if(response.statusCode()==200){
            String getReqRes =
                    given().
                            when().get("/v3.1/alpha/" +coutrycode).
                            then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js = new JsonPath(getReqRes);
            reUsableMethods sd = new reUsableMethods();
            String  countryName = null;
            try {
                  countryName = js.getString("[0].name.common");
                String  deutschName = js.getString("[0].translations.deu.official");
                String  capital = js.getString("[0].capital[0]");
                String  fifaCode = js.getString("[0].fifa");
                int count=js.getInt("timezones.size()");
            }
            catch (Exception e){
                countryName ="exception";
            }


            return countryName;
        }else
            return "400 error ";

    }

    public static int numberOfYearsForFixed(int p , int r , int t){



        return 4;
    }

}
