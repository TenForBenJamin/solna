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
        String soorarai=faker.howIMetYourMother().catchPhrase();
        Integer ttest=faker.number().numberBetween(0,1000000);
        return ttest;

    }
}
