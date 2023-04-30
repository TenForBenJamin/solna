package FPL;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectRepo.parama;
import objectRepo.reUsableMethods;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.*;

import static io.restassured.RestAssured.given;

public class wordProx extends parama {

    public static String wordProcesserV2(String homeTeam)
    {
        HashSet<String> hs = new HashSet<String>();
        // next additions -  Pyunik Academy &  hs.add("Academy");
        hs.add("2");
        hs.add("Zelvia");
        hs.add("Unido");
        hs.add("Academy");
        hs.add("Calcio");
        hs.add("Sepasi");
        hs.add("Citizen");
        hs.add("Africa");
        hs.add("Athletic");
        hs.add("AFC");
        hs.add("Wanderers");
        hs.add("OSC");
        hs.add("Sports");
        hs.add("County");
        hs.add("AC");
        hs.add("KE");
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
        hs.add("U22");
        hs.add("FF");
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
            //                                     hm.put("Aris Salonica Youth","Thessaloniki");
            String paola=null;
        hm.put("Rio Ave U23","Vila do Conde");
        hm.put("UMF Sindri","Höfn");
        hm.put("Galatasaray SK","Istanbul");
        hm.put("Unión Molinense","Murcia");
        hm.put("Rewa FC","Nausori");
        hm.put("Villarreal CF (W)","Villarreal,ES");
        hm.put("Ciudad de Lucena","Córdoba,ES");
        hm.put("Aris Salonica Youth","Thessaloniki");
        hm.put("Aris Salonica","Thessaloniki");
        hm.put("Aris","Thessaloniki");
        hm.put("FK Slutsk (R)","Minsk");
        hm.put("Cheng Fung","Macao");
        hm.put("FK Slutsk","Minsk");
        hm.put("Fortis FC","Dhaka");
        hm.put("FC Cartagena B","Cartagena,ES");
        hm.put("FC Cartagena","Cartagena,ES");
        hm.put("FK Veles Moscow","Moscow");
        hm.put("Muras United","Bishkek");
        hm.put("SønderjyskE","Haderslev");
        hm.put("SK Sparta Kolín","Kolín");
        hm.put("Kashima Antlers","Kashima");
        hm.put("FK Ural-2","Ural");
        hm.put("CE Europa","Barcelona,ES");
        hm.put("BK Forward","Orebro");
        hm.put("PE Sant Jordi","Sant Josep de sa Talaia");
        hm.put("PE Sant Jordi","Sant Jordi");
        hm.put("Rizespor","Rize");
        hm.put("Samsunspor","Samsun");
        hm.put("Bodrumspor SK","Bodrum");
        hm.put("Kasımpaşa SK","Istanbul");
        hm.put("FC Vilafranca","Vilafranca,ES");
        hm.put("Crystal Palace (W)","Londres");
        hm.put("Crystal Palace","Londres");
        hm.put("Tromsdalen UIL","Tromso");
        hm.put("Hirnyk-Sport","Horishni Plavni");
        hm.put("Zabbar St. Patrick","Zabbar,MT");
        hm.put("Ujpest FC II","Budapest");
        hm.put("Ujpest FC","Budapest");
        hm.put("Heidelberg Utd U21","Heidelberg,AU");
        hm.put("Centenary Stormers","Darra");
        hm.put("Kirivong Sok Sen Chey","Doun Kaev");
        hm.put("Taichung Futuro","Taichung");
        hm.put("FC Petrzalka","Bratislava");
        hm.put("Sunshine Coast","Sunshine Coast");
        hm.put("Heidelberg Utd","Heidelberg,AU");
        hm.put("Kawasaki Frontale","Kawasaki");
        hm.put("Heidelberg United","Heidelberg,AU");
        hm.put("Newcastle Olympic","Newcastle,AU");
        hm.put("Reggina Youth","Reggio Calabria");
        hm.put("Union Saint-Gilloise","Belgium");
        hm.put("Southside Eagles","Brisbane");
        hm.put("Unirea Slobozia","Slobozia,RO");
        hm.put("Macarthur Rams","Campbelltown");
        hm.put("SD Raiders","Moorebank");
        hm.put("Kitchee SC","Hong kong");
        hm.put("Tai Po FC","Hong kong");
        hm.put("HK Rangers","Hong kong");
        hm.put("FO Jas Qyran","Almaty");
        hm.put("Adelaide Comets","Adelaide");
        hm.put("Gold Coast Utd","Gold Coast");
        hm.put("Newmarket SFC","Newmarket,AU");
        hm.put("North Star","Zillmere");
        hm.put("Chainat Hornbill","Chainat");
        hm.put("Adelaide Olympic","Adelaide");
        hm.put("Hapoel Kafr Kanna","Kafr Kanna");
        hm.put("Ulsan Hyundai","Ulsan");
        hm.put("Omiya Ardija","Omiya");
        hm.put("PAOK Youth","Thessaloniki");
        hm.put("Newcastle Jets","Newcastle,AU");
        hm.put("UQ FC","Brisbane");
        hm.put("PAOK","Thessaloniki");
        hm.put("Legia II Warszawa","Warszawa");
        hm.put("CD Alesves","Villafranca,es");
        hm.put("Adelaide Vipers","Adelaide");
        hm.put("Ytterhogdals IK","Ytterhogdal");
        hm.put("Central Coast Utd","Central Coast");
        hm.put("Dandenong Th. U21","Melbourne");
        hm.put("Dandenong Thunder","Melbourne");
        hm.put("Kuban Holding","Pavlovskaya");
        hm.put("FK Vidar","Stavanger");
        hm.put("Gangwon B","Gangneung");
        hm.put("Hapoel Bnei Zalafa","Zalafa");
        hm.put("Colo Colo","Macul");
        hm.put("Maccabi Ata Bialik","Haifa");
        hm.put("Maccabi Ata Bialik","Nazareth");
        hm.put("Saprissa","San Jose,CR");
        hm.put("Sirens FC","St. Paul's Bay");
        hm.put("West Ham","West Ham");
        hm.put("Sint Maarten (W) U20","Sint Maarten");
        hm.put("Sint Maarten (W)","Sint Maarten");
        hm.put("Sint Maarten","Sint Maarten");
        hm.put("Sivasspor","Sivas");
        hm.put("Unión Adarve","Madrid");
        hm.put("Binh Dinh FC","Qui Nhon");
        hm.put("Egersunds IK","Egersund");
        hm.put("IL Hodd 2","Ulsteinvik");
        hm.put("Cherno More Varna","Varna");
        hm.put("Birmingham City","Birmingham,GB");
        hm.put("Birmingham U21","Birmingham,GB");
        hm.put("Bergnäsets AIK ","Luleå");
        hm.put("Trelleborgs FF","Trelleborg");
        hm.put("IL Hodd","Ulsteinvik");
        hm.put("Maccabi Ironi Ashdod","Ashdod");
        hm.put("SJK Akatemia","Seinäjoki");
        hm.put("West Bromwich U21","West Bromwich");
        hm.put("West Bromwich","West Bromwich");
        hm.put("Thanh Hoa FC","Thanh Hoa");
        hm.put("SK Brann 2","Bergen,nO");
        hm.put("Viborg FF (R)","Viborg FF");
        hm.put("Boluspor","Bolu");
        hm.put("Viborg FF","Viborg FF");
        hm.put("Talanta FC","Nairobi");
        hm.put("Tromso 2","Tromso");
        hm.put("Shirak-2","Gyumri");
        hm.put("FK Elektron","Veliky Novgorod");
        hm.put("Unión Santa Fe","Santa Fe,AR");
        hm.put("Caldas SC","Caldas da Rainha");
        hm.put("Sevilla Atlético","Seville");
        hm.put("Sevilla","Seville");
        hm.put("Sevilla FC","Seville");
        hm.put("Busan I'Park","Busan");
        hm.put("Rayo Vallecano B","Madrid");
        hm.put("Rayo Vallecano","Madrid");
        hm.put("RCD Mallorca B","Palma de Mallorca");
        hm.put("Atlético Baleares","Palma de Mallorca");
        hm.put("Pyunik Academy","Yereven");
        hm.put("Pyunik FC","Yereven");
        hm.put("Urartu-2","Yereven");
        hm.put("Mito HollyHock","Mito,JP");
        hm.put("Abdysh-Ata Kant","kant,KG");
        hm.put("CD Ebro","Zaragoza");
        hm.put("Siheung Citizen","Ansan");
        hm.put("Hong Kong U23","Hong Kong");
        hm.put("St Ives Town","St Ives");
        hm.put("Dorchester Town","Dorchester,GB");
        hm.put("ADO Den Haag (W)","Den Haag");
        hm.put("ADO Den Haag","Den Haag");
        hm.put("Hong Kong","Hong Kong");
        hm.put("Marconi Stallions","Sydney");
        hm.put("Silver Strikers","Lilongwe");
        hm.put("Tishreen SC","Latakia");
        hm.put("WS Wanderers","Sydney");
        hm.put("Hrvatski Dragovoljac","Zagreb");
        hm.put("Club Africain Tunis","Tunis");
        hm.put("Étoile Sahel Sousse","Sousse");
        hm.put("Dalian Professional","Dalian");
        hm.put("Os Belenenses SAD","Lisbon");
        hm.put("Beroe Stara Zagora","Stara Zagora");
        hm.put("Blau-Weiß 90 Berlin","Berlin");
        hm.put("Skjetten SK","Lillestrøm");
        hm.put("Bahlinger SC","Bahlingen");
        hm.put("IK Junkeren","Bodo,NO");
        hm.put("Cambridge United","Cambridge,GB");
        hm.put("Hannover 96 II","Hannover");
        hm.put("TSV 1860","MUnich");
        hm.put("Hannover 96","Hannover");
        hm.put("Ascoli","Ascoli Piceno");
        hm.put("Ascoli Youth","Ascoli Piceno");
        hm.put("Puskás Akadémia (W)","Felcsút");
        hm.put("Puskás Akadémia","Felcsút");
        hm.put("SPAL 1907","Ferrara");
        hm.put("Odd Grenland 2","Skien");
        hm.put("National Bank SC","Cairo");
        hm.put("Aston Villa","Birmingham,GB");
        hm.put("FC Ararat-Armenia","Ararat,AR");
        hm.put("Ashton United","Tameside");
        hm.put("SS San Giovanni","San Marino");
        hm.put("Yeni Malatyaspor","Malatya");
        hm.put("Union Titus Pétange","Luxembourg City,LU");
        hm.put("Folgore Calcio","San Marino");
        hm.put("Rabat Ajax","Rabat,MT");
        hm.put("Yomraspor","Yomra");
        hm.put("SP Tre Fiori","San Marino");
        hm.put("SS Cosmos","San Marino");
        hm.put("Gjelleråsen IF","Akershus");
        hm.put("SKA-Khabarovsk","Khabarovsk");
        hm.put("Punjab FC","Mohali,IN");
        hm.put("FC Twente","Enschede");
        hm.put("Erzurumspor FK","Erzurum");
        hm.put("Besiktas JK","Istanbul");
        hm.put("Molynes United","Kingston,JM");
        hm.put("Atromitos Youth","Athens");
        hm.put("Atromitos","Athens");
        hm.put("Erbaaspor SK","Erbaa");
        hm.put("Lee Man FC","Hong Kong");
        hm.put("East Bengal B","Kolkata");
        hm.put("East Bengal","Kolkata");
        hm.put("Logan Lightning","Logan City");
        hm.put("Benfica de Macau","Macau");
        hm.put("Pohang Steelers","Pohang");
        hm.put("Goczalkowice Zdroj","Katowice");
        hm.put("Chemnitzer FC","Chemnitz");
        hm.put("Udinese Calcio","Udine");
        hm.put("Ulsan Citizen","Ulsan");
        hm.put("Reggina","Reggio Calabria");
        hm.put("Yokohama F Marinos","Yokohama");
        hm.put("Reggina Youth","Reggio Calabria");
        hm.put("Modbury Jets","Adelaide");
        hm.put("North Lakes United","Brisbane");
        hm.put("Tala'ea Al Jaish Cairo","Cairo");
        hm.put("Shatin SA","Hong Kong");
        hm.put("CD Magallanes","San Bernardo, Chile");
        hm.put("Silkeborg IF","Silkeborg");
        hm.put("UD San Fernando","San Bartolome de Tirajana");
        hm.put("Aumund-Vegesack","Vegesack");
        hm.put("Villarreal CF B","Valencia,ES");
        hm.put("Villarreal CF","Valencia,ES");
        hm.put("St Patrick's Dublin","Dublin");
        hm.put("Southend United","Southend,GB");
        hm.put("Cobh Ramblers","Cobh");
        hm.put("Varzim SC","Póvoa de Varzim");
        hm.put("SC Telstar","Velsen");
        hm.put("Ammanford AFC","Ammanford");
        hm.put("SL16 FC","Liege");
        hm.put("Tractor SC","Tabriz");
        hm.put("Real San Joaquín","San Joaquin,CL");
        hm.put("Glenavon","Lurgan");
        hm.put("Chesterfield","Chesterfield,UK");
        hm.put("Bala Town","Gwynedd");
        hm.put("Vukovar '91","Vinkovci");
        hm.put("Hittarps IK","Helsingborg");
        hm.put("Niendorfer TSV","Niendorf");
        hm.put("Vorskla","Poltava");
        hm.put("Trefelin BGC","Port Talbot");
        hm.put("Honduras Progreso","El Progreso");
        hm.put("SP Falcons","Ulaanbaatar");
        hm.put("Inter d'Escaldes","Andorra");
        hm.put("CD Marathón","San Pedro Sula");
        hm.put("Liverpool (URU)","Montevideo");
        hm.put("Richmond Kickers","Richmond");
        hm.put("Maroons FC","Kampala");
        hm.put("North Pine","Brisbane");
        hm.put("Vipers SC","Kampala");
        hm.put("FK Voska Sport","Ohrid");
        hm.put("Tulsa Athletics","Tulsa");
        hm.put("CS Switchbacks","Colorado Springs, Colorado");
        hm.put("APIA Tigers Youth","Leichhardt");
        hm.put("Mesaimeer SC","Al Rayyan");
        hm.put("Asante Kotoko","Kumasi");
        hm.put("Loudoun United","Leesburg, Virginia");
        hm.put("Maryland Bobcats FC","Montgomery County");
        hm.put("Clachnacuddin","Inverness");
        hm.put("Des Moines Menace","Des Moines");
        hm.put("Diriangén FC","Diriamba");
        hm.put("APIA Tigers","Leichhardt");
        hm.put("RCD Espanyol B","Barcelona,ES");
        hm.put("RCD Espanyol","Barcelona,ES");
        hm.put("Ceramica Cleopatra","Nasr City");
        hm.put("Energetik-BGU (R)","Minsk");
        hm.put("Batman Petrolspor","Batman");
        hm.put("Sheffield Wed U21","Sheffield");
        hm.put("Sheffield Wed","Sheffield");
        hm.put("Sheffield Wednesday","Sheffield");
        hm.put("Helsingborgs U21","Helsingborg");
        hm.put("Helsingborgs","Helsingborg");
        hm.put("Ghazl Al Mahalla","Gharbia Governorate");
        hm.put("Khimik-Avgust","Vurnary");
        hm.put("Energetik-BGU","Minsk");
        hm.put("Peninsula Power","Redcliffe");
        hm.put("CP San Cristóbal","Terrassa");
        hm.put("Yuen Long","Hong Kong");
        hm.put("UD Poblense","Sa Pobla");
        hm.put("Brisbane Roar","Brisbane");
        hm.put("Arema FC","Malang");
        hm.put("FK Khan Tengri","almaty");
        hm.put("Samut Sakhon City FC","Samut Sakhon");
        hm.put("Somaspor","Manisa");
        hm.put("Gaddafi FC","Jinja");
        hm.put("Holland Park Hawks","Camp Hill,AU");
        hm.put("Jagiellonia II","Białystok");
        hm.put("Jagiellonia Youth","Białystok");
        hm.put("Patacona CF","Alboraya");
        hm.put("RANS Nusantara","bogor");
        hm.put("Slavia TU Kosice","Kosice");
        hm.put("Brisbane Roar Youth","Brisbane");
        hm.put("Daejeon Citizen B","Daejeon");
        hm.put("Dangjin Citizen","Sejong");
        hm.put("Al Fateh Youth","Hofuf,SA");
        hm.put("Apollon Smyrni","Athens");
        hm.put("ZESCO United","Ndola");
        hm.put("Gandzasar FC","Kapan");
        hm.put("Samut Prakan FC","Samut Prakan");
        hm.put("Dinamo Bucuresti","Bucharest");
        hm.put("Hajer Youth","Hofuf,SA");
        hm.put("SC Farense U23","Faro");
        hm.put("Stabaek","Bærum");
        hm.put("Macarthur FC","Sydney");
        hm.put("WS Wanderers (W)","Sydney");
        hm.put("SK Lisen","Brno");
        hm.put("Mjällby AIF","Blekinge");
        hm.put("Young Lions","Singapore");
        hm.put("Jagiellonia","Białystok");
        hm.put("FC Noah","Yerevan");
        hm.put("SK Lisen","Brno");
        hm.put("Malmö FF","Malmo");
        hm.put("BK Hacken FF (W)","Gothenburg");
        hm.put("BK Hacken","Gothenburg");
        hm.put("CR Témouchent","Ain Temouchent");
        hm.put("Chayka FK Pesch","Peschanokopskoye");
        hm.put("Hamburger SV II","Hamburg");
        hm.put("Hamburger SV U19","Hamburg");
        hm.put("Hamburger SV","Hamburg");
        hm.put("1. FC Saarbrücken","Saarbrücken");
        hm.put("Halmstads BK","Halmstad");
        hm.put("SK Traeff","Molde");
        hm.put("Oure FA","Svendborg");
        hm.put("Lunds BK","Lund");
        hm.put("SC Farense","Faro");
        hm.put("The Strongest","La Paz");
        hm.put("Sepsi OSK","Sfantu Gheorghe");
        hm.put("Semouha Club","Alexandria");
        hm.put("Los Angeles FC","Los Angeles");
        hm.put("Shabab (KUW)","Al Ahmadi");
        hm.put("Union Saint-Gilloise","Brussels");
        hm.put("Altay FK Ust-Kamen.","Semey");
        hm.put("Fajr Sepasi","Shiraz");
        hm.put("İnegölspor","İnegöl");
        hm.put("Al Nassr Riyadh","Riyadh");
        hm.put("TSV 1860","Munich");
        hm.put("Ipswich Knights","Ipswich,AU");
        hm.put("CD Santa Úrsula","Santa Ursula");
        hm.put("Binh Phuoc FC","dong xoai");
        hm.put("AO Pyliou","Kos");
        hm.put("Udon Thani FC","Udon Thani");
        hm.put("Nafpaktiakos","Nafpaktos");
        hm.put("Pyramids FC ","Cairo");
        hm.put("Ankaraspor ","Ankara");
        hm.put("Zira FK II","Baku");
        hm.put("Zira FK","Baku");
        hm.put("KF Llapi","Podujevo");
        hm.put("River Plate (URU)","Montevideo");
        hm.put("Hoa Binh FC","Hoa Binh");
        hm.put("Lierse Kempenzonen U21","Lier");
        hm.put("Lierse Kempenzonen","Lier");
        hm.put("Gharrafa SC","Al Rayyan");
        hm.put("Al Hala","Muharraq");
        hm.put("Bulleen Lions","Melbourne");
        hm.put("Zob Ahan","Isfahan");
        hm.put("İstanbulspor AŞ","İstanbul");
        hm.put("Melb. Victory (W)","Melbourne");
        hm.put("Melbourne Victory","Melbourne,AU");
        hm.put("Botev II Plovdiv","Plovdiv");
        hm.put("San Telmo","San Telmo,AR");
        hm.put("Sulaibikhat","Kuwait City");
        hm.put("Harbour View","Kingston,JM");
        hm.put("CA Palmaflor","Cochabamba");
        hm.put("Makedonikos FC","Neapoli");
        hm.put("Riffa Club","Bahrain");
        hm.put("FC Lahti","Lahti,FI");
        hm.put("Midtjylland (R)","Herning");
        hm.put("TJK Legion","Tallinn");
        hm.put("Botev Plovdiv","Plovdiv");
        hm.put("Midtjylland","Herning");
        hm.put("Phu Tho FC","Phu Tho");
        hm.put("Səbail FK","Baku");
        hm.put("Bradford PA","Bradford");
        hm.put("Univ de Vinto","Vinto");
        hm.put("Versailles 78","Versailles");
        hm.put("FC AGMK","Olmaliq");
        hm.put("FCV Dender EH","Denderleeuw");
        hm.put("FCV Dender EH U21","Denderleeuw");
        hm.put("Gyori ETO II","Gyor");
        hm.put("Gyori ETO","Gyor");
        hm.put("Hatayspor","Hatay");
        hm.put("Fenerbahçe SK (W)","Istanbul");
        hm.put("Fenerbahçe SK","Istanbul");
        hm.put("IF Lodde","Skåne County");
        hm.put("Melbourne City","Melbourne");
        hm.put("Trabzonspor","Trabzon");
        hm.put("Kazincbarcikai SC","Kazincbarcika");
        hm.put("Levadiakos","Livadeia5");
        hm.put("Bayrampasaspor","Istanbul");
        hm.put("West Ham (W)","West Ham");
        hm.put("Paide Linnameeskond","Paide");
        hm.put("West Ham","West Ham");
        hm.put("APEJES","Yaounde");
        hm.put("Brisbane Strikers ","Brisbane");
        hm.put("Barrow AFC","Cumbria,gb");
        hm.put("H&W Welders","Belfast");
        hm.put("Real Tomayapo","Tarija");
        hm.put("Zonguldak Kömürspor","Zonguldak");
        hm.put("Milton Keynes Dons","Milton Keynes");
        hm.put("Mohammedan SC","Kolkata");
        hm.put("Bayburt Ozel Idare","Bayburt");
        hm.put("MŠK Fomat Martin","Martin,SK");
        hm.put("Notts County","Nottingham");
        hm.put("Yeoju Citizen","Yeoju");
        hm.put("Turgutluspor","Turgutlu");
        hm.put("General Velásquez","O'Higgins Region");
        hm.put("Kozakken Boys","Werkendam");
        hm.put("SD Lagunak","baranain");
        hm.put("24 Erzincanspor","Erzincan");
        hm.put("CD Tudelano","Tudela");
        hm.put("RB Bragantino/SP U20","Sao Paulo");
        hm.put("RFK Aksu","Aksu,KZ");
        hm.put("Vancouver WC","Vancouver");
        hm.put("Jahra FC","Kuwait City,KW");
        hm.put("RB Bragantino/SP","Sao Paulo");
        hm.put("IF Elfsborg","Boras");
        hm.put("Ettifaq FC","Dammam");
        hm.put("Barito Putera","Banjarmasin");
        hm.put("Ayeyawady United","Pathein");
        hm.put("Budaiya","Bahrain");
        hm.put("East Riffa","Bahrain");
        hm.put("Diriangén FC","Diriamba");
        hm.put("Cobresal","El Salvador,CL");
        hm.put("B68 Toftir II","Eysturoy");
        hm.put("B68 Toftir","Eysturoy");
        hm.put("Raya2 Expansión","Guadalupe");
        hm.put("Alianza Petrolera","Barrancabermeja");
        hm.put("CS Emelec","Guayaquil");
        hm.put("Tepatitlan FC","Guadalajara");
        hm.put("Bandirmaspor","Panderma");
        hm.put("CA Huracán","Parque Patricios");
        hm.put("Sakaryaspor","Adapazarı");
        hm.put("JK Tammeka Tartu II","Tartu");
        hm.put("CA Osasuna (W)","Pamplona");
        hm.put("CA Osasuna B","Pamplona");
        hm.put("Glenwood Redbacks","Glenwood,AU");
        hm.put("KF Ballkani","Suva Reka");
        hm.put("Deportes Tolima","Ibague");
        hm.put("CSD Xinabajul","Huehuetenango");
        hm.put("Sporting CP U23","Lisbon");
        hm.put("Sporting CP","Lisbon");
        hm.put("KF Gjilani","Gjilan");
        hm.put("JK Tammeka Tartu","Tartu");
        hm.put("Ararat-2","Yerevan");
        hm.put("FC Ararat-Armenia-2","Yerevan");
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
        hm.put("Real Sociedad B","San Sebastián,ES");
        hm.put("Real Sociedad","San Sebastián,ES");
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
        hm.put("Juventus FC","Turin,IT");
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
        hm.put("FK Ekranas","Panevezys");
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
