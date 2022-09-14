package by.coherent.domain;


public class Product {

    private String name;
    private int rating;
    private double price;
    private String attributeOne;
    private String attributeTwo;

    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    public class Builder {
        private String name;
        private int rating;
        private double price;

        private Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }


        public Product build() {
            Product.this.name = this.name;
            Product.this.rating = this.rating;
            Product.this.price = this.price;
            return Product.this;
        }

    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public double getPrice() {
        return this.price;
    }


    public String toString() {
        final StringBuilder sb = new StringBuilder("Product ");
        sb.append("Name='").append(name).append("\'");
        sb.append(", rating ").append(rating);
        sb.append(", price ").append(price);
        return sb.toString();
    }

}
