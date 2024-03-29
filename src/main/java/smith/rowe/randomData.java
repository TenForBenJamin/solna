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
    public static String genRandomHIMYM() {
        Faker faker = new Faker();
        String soorarai=faker.howIMetYourMother().catchPhrase();
        return soorarai;

    }

    public static int genRandomMgrId() {
        Faker faker = new Faker();
        Integer ttest=faker.number().numberBetween(0,100000);
        return ttest;

    }

    public static String genRandomSpecificCapitalName() {
        Faker faker = new Faker();
        String soorarai=faker.country().countryCode3();
        return soorarai;
    }

    public static String genRandomCity() {
        Faker faker = new Faker();
        String randomGenerated=faker.nation().capitalCity();
        // For invalid random cities use String randomGenerated=faker.address().cityName();
        return randomGenerated;

    }
}
