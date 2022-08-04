package by.coherent.domain;

public class Product {

    public String name;
    public int rating;
    public double price;

    public Product(String name, int rating, double price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        String productInfo = String.format("Name: %s, Price: %s, Rate: %s", name, price, rating);
        return productInfo;
    }

}
