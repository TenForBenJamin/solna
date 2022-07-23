package smith.rowe;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static String genRandomStadt() {
    	Faker faker = new Faker();
    	return faker.address().cityName();
    	
    }
}
