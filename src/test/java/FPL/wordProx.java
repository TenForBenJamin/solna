package FPL;

import java.util.HashSet;
import java.util.Iterator;

public class wordProx {

    public static String wordProcesserV2(String homeTeam)
    {
        HashSet<String> hs = new HashSet<String>();
        // next additions -  AZ Dynamos & Spartans
        hs.add("Glory");
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
        hs.add("IK");
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

//Giresunspor
        //
        Iterator<String> i=hs.iterator();

        Boolean flag = false;
        String[] result = homeTeam.split(" ");
        if(result.length<2)
            homeTeam=result[0];
        else {
            homeTeam = result[1];
            while(i.hasNext())
            {
                //System.out.println(i.next());
                String macher = i.next();
                if(homeTeam.equalsIgnoreCase(macher))
                    flag=true;
            }
            if(flag)
                homeTeam=result[0];

        }




        return homeTeam;
    }

}
