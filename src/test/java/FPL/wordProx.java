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
        //                                             hm.put("KF Gjilani","Gjilan");
        String paola=null;
        hm.put("Rio Ave U23","Vila do Conde");
        hm.put("JK Tammeka Tartu II","Tartu");
        hm.put("Deportes Tolima","Ibague");
        hm.put("KF Gjilani","Gjilan");
        hm.put("JK Tammeka Tartu","Tartu");
        hm.put("Ararat-2","Yeravan");
        hm.put("Levadia II Tallinn","Tallinn");
        hm.put("Rio Ave","Vila do Conde");
        hm.put("Patriotas FC","Tunja,CO");
        hm.put("Al Baten","Hafar al-Batin");
        hm.put("Hertha BSC","Berlin,DE");
        hm.put("Chippa United","Port Elizabeth");
        hm.put("Valerenga (W)","Oslo");
        hm.put("Guarani/CE","Juazeiro do Norte");
        hm.put("Jong PSV","Eindhoven");
        hm.put("Jong AZ Alkmaar","Alkmaar");
        hm.put("FK Leningradets","Leningrad");
        hm.put("AZ Alkmaar","Alkmaar");
        hm.put("Five Islands FC","Antigua");
        hm.put("KF Laci","Lac,AL");
        hm.put("APOEL FC","Strovolos,CY");
        hm.put("Bohemians FC","Dublin");
        hm.put("Sepsi OSK","Sfântu Gheorghe");
        hm.put("CA Osasuna","Pamplona");
        hm.put("Valerenga","Oslo");
        hm.put("Estrela do Norte/ES","Cachoeiro de Itapemirim");
        hm.put("Mladost Novi Sad","Novi Sad");
        hm.put("Jong Ajax","Amsterdam");
        hm.put("RWD Molenbeek U21","Molenbeek-Saint-Jean");
        hm.put("RWD Molenbeek B","Molenbeek-Saint-Jean");
        hm.put("RWD Molenbeek","Molenbeek-Saint-Jean");
        hm.put("Arsenal Sarandi","Sarandi,AR");
        hm.put("OFK Žarkovo","Belgrade");
        hm.put("Kasımpaşa SK","Istanbul");
        hm.put("Águia de Marabá/PA","Maraba");
        hm.put("Casa Pia AC","Lisbon");
        hm.put("Boca Juniors","La Boca");
        hm.put("Leandro N. Alem","General Rodriguez");
        hm.put("Al Masry","Port Said");
        hm.put("Kenkre FC","Mumbai");
        hm.put("Bregalnica Stip","Shtip,MK");
        hm.put("Brasiliense/DF","Taguatinga");
        hm.put("Panelefsiniakos","Elefsina,GR");
        hm.put("Millonarios","Bogota");
        hm.put("Celtic FC","glasgow");
        hm.put("Celtic LFC (W)","glasgow");
        hm.put("ASAC Concorde","Nouakchott");
        hm.put("Kastamonuspor","Kastamonu");
        hm.put("PAOK Salonica","Thessaloniki,GR");
        hm.put("Melita FC","St. Julian's,MT,");
        hm.put("Virtus Entella","Chiavari,IT");
        hm.put("Wollongong Wolves","Wollongong");
        hm.put("Metro Gallery ","Kowloon,HK");
        hm.put("Al Ahli Manama","Manama");
        hm.put("Fortaleza/CE","Fortaleza");
        hm.put("Montrose FC","Montrose,GB");
        hm.put("AD Sanjoanense","São João da Madeira");
        hm.put("CD Oberena","Pamplona");
        hm.put("San Jose Earthquake","San Jose,US");
        hm.put("MŠK Považská Bystrica","Považská Bystrica");
        hm.put("Nakhon Ratchasima","Nakhon Ratchasima");
        hm.put("Hearts FC","edinburgh,gb");
        hm.put("Guangdong Haiyin (W)","Guangdong");
        hm.put("Ironi Kiryat Shmona","Kiryat Shmona");
        hm.put("O'Higgins","Rancagua");
        hm.put("Real Sociedad (W)","San Sebastián,ES");
        hm.put("Pors Grenland","Porsgrunn,NO");
        hm.put("Panathinaikos Youth","Athens,GR");
        hm.put("Panathinaikos","Athens,GR");
        hm.put("Dorking Wanderers","Dorking,GB");
        hm.put("AS Arta","arta,DJ");
        hm.put("South Korea","Seoul");
        hm.put("South Korea U17","Seoul");
        hm.put("South Korea U20","Seoul");
        hm.put("Anorthosis FC","Famagusta");
        hm.put("De Graafschap","Doetinchem,NL");
        hm.put("América/MG U20","Belo Horizonte");
        hm.put("Real Ariquemes/RO","Ariquemes");
        hm.put("Sahel (KUW)","Abu Halifa,KW");
        hm.put("América/MG7","Belo Horizonte");
        hm.put("América/MG","Belo Horizonte");
        hm.put("FK Kolubara","Lazarevac,RS");
        hm.put("HB Chelghoum Laid","Chelghoum Laid");
        hm.put("CD Tapatio","Guadalajara");
        hm.put("Mussanah Club","Barka,OM");
        hm.put("Rio Branco/ES","Vitoria,BR");
        hm.put("Al Fayha","Riyadh");
        hm.put("Stjarnan FC","Reykjavík");
        hm.put("Deportes Quindío","Armenia,CO");
        hm.put("Tacuary FBC","Asuncion,PY");
        hm.put("Atlante FC","Mexico City");
        hm.put("Sotra SK","Bergen");
        hm.put("Al Duhail SC","Doha");
        hm.put("Juventus U23","Turin,IT");
        hm.put("Al Fateh (KSA)","Hofuf,SA");
        hm.put("Debrecen VSC","Debrecen,Hu");
        hm.put("Juventus U19","Turin,IT");
        hm.put("Juventus","Turin,IT");
        hm.put("Baroka FC","Polokwane,za");
        hm.put("Maringa FC/PR","Maringá,BR");
        hm.put("FK Radnički 1923","Kragujevac");
        hm.put("Univ de Chile","Ñuñoa,CL");
        hm.put("Grêmio/RS U20","Porto Alegre");
        hm.put("Marumo Gallants FC","Polokwane");
        hm.put("FCSB","Bucharest");
        hm.put("Grêmio/RS","Porto Alegre");
        hm.put("ASEC Mimosas","Abidjan");
        hm.put("San Gwann","San Gwann");
        hm.put("TRAU FC","Imphal");
        hm.put("Beitar Tel Aviv Bat Yam","Ramla,IL");
        hm.put("CD Dragon","San Miguel,SV");
        hm.put("Great Olympics","Accra");
        hm.put("Tshakhuma TM","Thohoyandou,za");
        hm.put("Jeonnam Dragons","Gwangyang");
        hm.put("Wazito FC","Nairobi");
        hm.put("Sudeva Moonlight","delhi,in");
        hm.put("Seongnam Ilhwa Ch.","Seongnam");
        hm.put("Səbail FK II","baku");
        hm.put("Səbail FK","baku");
        hm.put("Sandnes Ulf","Sandnes");
        hm.put("Berlin AK 07 U19","Moabit,de");
        hm.put("Hibernian LFC (W)","edinburgh,gb");
        hm.put("gyeongnam","changwon");
        hm.put("Rangers LFC (W)","Cumbernauld,gb");
        hm.put("Berlin AK 07","Moabit,de");
        hm.put("Hamilton A. (W)","Hamilton,gb");
        hm.put("Arsenal","Islington");
        hm.put("Arsenal U21","Islington");
        hm.put("Arsenal U18","Islington");
        hm.put("Oakland Roots","oakland,cn,us");
        hm.put("FK Trajal","Kruševac,rs");
        hm.put("Northern Tigers","Sydney,au");
        hm.put("Atlético Marte","San Salvador,SV");
        hm.put("Tiszafüred VSE","Tiszafüred,HU");
        hm.put("Étoile Sahel Sousse","Sousse,tn");
        hm.put("Arua Hill SC","Arua,UG");
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
