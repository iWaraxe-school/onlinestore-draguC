package by.coherent.store.helpers;

import com.github.javafaker.Faker;

public class RandomProductGenerator {

    Faker faker = new Faker();


    public String getProductName(String categoryName) {
        switch (categoryName) {
            case "Bikes":
                return faker.artist().name();
            case "Phones":
                return faker.pokemon().name();
            case "Milk":
                return faker.food().ingredient();
            default:
                return null;

        }
    }

    public int getRating() {
        return faker.number().numberBetween(0, 100);
    }

    public double getPrice() {
        return faker.number().randomDouble(2, 1, 999);
    }
}