package objectRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class parama
{
	public static String OpCo="en";
	protected String apiKey="2b1fd2d7f77ccf1b7de9b441571b39b8";
	protected static String  apiKey_wrong="2b1fd2d7f77ccf1b7de9b441571b39b8146";
	public String zipUSTulsa="74015,US";
	public String zipDENrw="50676,DE";
	public String zipDEBodersee="37434,DE";
	public static String f95="40474,DE";
	public String wolves="WV14QR,GB";
	public static String baseUrl="someBaseURL";
	public static String baseUrlopenWeather="https://api.openweathermap.org";
	public String sID_1="50676ABCD";
	public static String s_id="12345";
	public static String b04="51371,DE";
	public static String bvb="44287,DE";
	public static String HBC="14053,DE";
	public static String UNI="12555,DE";
	public static String KAI="67663,DE";
	public static String ROS="18057,DE";
	public static String HOF="74889,DE";
	public static String FCB="80939,DE";
	public static String FCA="86199,DE";
	public static String HOFs="74889,DE";
	public static String FCBs="80939,DE";
	public static String S04="45881,DE";
	public static String Hamburg="20097,DE";
	public static String sgf="90765,DE";
	public static String d="86199,DE";
	public static String w="74889,DE";
	//public static String e="80939,DE";
	public static String q="45881,DE";
	// �����������FCB���������������������������  FCB
	public static String glascow="glasgow";
	public static String Graz="Graz";
	public static String vienna="vienna";
	public static String LEI ="LE2 7FL , GB";

	// �����������FKerala HOme���������������  FCB
	public static String KL56 ="673522,IN";
	//685612 munnar
	//495118 marwahi
	public static String marwahi ="495118,IN";
	
	// UEL destinations
	// Graz , vienna 
	// rennes , nantes , marseille
	// rangers , hearts
	// eindhoven , Feyenoord
	// USG , brugge , gent
	//Zurich
	// midyalland , FCK
	//Poznan
	// Plizen
	public void FISch() 
	{
		
		File file = new File("C:/home/datafile.properties");
		  
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//public static String ten4ben=prop.getProperty("URL");
		
		
		
		//System.out.println("URL ::" + prop.getProperty("URL"));
	}
	
	//
	
	//barrow Ak 99723
	
}
