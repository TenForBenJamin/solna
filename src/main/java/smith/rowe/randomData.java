package smith.rowe;

import com.github.javafaker.Faker;

public class randomData {

    public static String generateName() {
        Faker faker =new Faker();
        return faker.name().firstName();
    }

    public static String genRandomCapitalName() {
        Faker faker = new Faker();
        String soorarai=faker.country().capital();
        return soorarai;

    }
}
