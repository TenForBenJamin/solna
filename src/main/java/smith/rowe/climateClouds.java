package smith.rowe;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Calendar;
import java.util.TimeZone;

public class climateClouds {

    public static String simbleDaylengthPrintAssert(String s , String z)
    {
        JsonPath js = new JsonPath(s);
        String dt = js.getString("dt");
        int ddt=Integer.parseInt(dt);
        java.util.Date time=new java.util.Date((long)ddt*1000);
        String asliJagah=js.getString("name");
        String coundry = js.getString("sys.country");
        System.out.println("Place for the coordinate at  "+ z +" is                  " + asliJagah + " , " + coundry);
        double count = js.getDouble("main.temp");
        String mainTemp = js.getString("main.temp");
        String rlat = js.getString("coord.lat");
        String rlon = js.getString("coord.lon");
        String windSpeed =js.getString("wind.speed");
        String weatherDesc =js.getString("weather[0].description");
        String weatherCode = js.getString("weather[0].id");
        String  epTimeSR = js.getString("sys.sunrise");
        int iSR=Integer.parseInt(epTimeSR);
        String  epTimeSS = js.getString("sys.sunset");
        int iSS=Integer.parseInt(epTimeSS);
        double mainTempInt =  Double.parseDouble(mainTemp);
        int daylength = iSS-iSR;
        String dl=Duracion(daylength);
        System.out.println("      DayLength -   " +dl + " |  weather description -  " + weatherDesc + "  | temperature is " + mainTemp   );
        System.out.println("      Coords -   |  Latitude  -  " + rlat + " N°  | Longitude  " + rlon +" E° "  );
        int aarm =20;
        if (mainTempInt>aarm)
        {
            System.out.println("     test failed  for "+asliJagah);
            Assert.assertEquals(mainTempInt,"a Hill station temp shouldnt be above Limit set at - "+aarm +" degree");
        }

        return null;
    }

    public static String Duracion(int dl) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dl * 1000L);
        cal.setTimeZone(TimeZone.getTimeZone("UTC+1"));
        int daylengthHours = cal.get(Calendar.HOUR_OF_DAY);
        daylengthHours = daylengthHours + 1;
        // System.out.println(cal.get(Calendar.HOUR_OF_DAY));//12 hour clock
        String miren="daylength is " + daylengthHours + " H " + cal.get(Calendar.MINUTE) + " M  ";// 24 hour
        // clock
        // return dl;
        return miren;
    }

    public static String simbleDaylengthPrint(String s , String z)
    {


        try
        {
            JsonPath js = new JsonPath(s);
            String dt = js.getString("dt");
            int ddt=Integer.parseInt(dt);
            java.util.Date time=new java.util.Date((long)ddt*1000);
            String asliJagah=js.getString("name");
            String coundry = js.getString("sys.country");
            System.out.println("Place for the coordinate at  "+ z +" is                  " + asliJagah + " , " + coundry);
            double count = js.getDouble("main.temp");
            String mainTemp = js.getString("main.temp");
            String rlat = js.getString("coord.lat");
            String rlon = js.getString("coord.lon");
            String windSpeed =js.getString("wind.speed");
            String weatherDesc =js.getString("weather[0].description");
            String weatherCode = js.getString("weather[0].id");
            String  epTimeSR = js.getString("sys.sunrise");
            int iSR=Integer.parseInt(epTimeSR);
            String  epTimeSS = js.getString("sys.sunset");
            int iSS=Integer.parseInt(epTimeSS);
            int daylength = iSS-iSR;
            String dl=Duracion(daylength);
            System.out.println("      DayLength -   " +dl + " |  weather description -  " + weatherDesc + "  | temperature is " + mainTemp   );
            System.out.println("      Coords -   |  Latitude  -  " + rlat + " N°  | Longitude  " + rlon +" E° "  );
        }
        catch(Exception e) {
            System.out.println("no pinCode found for "+ z);
        }

        return null;
    }
}
