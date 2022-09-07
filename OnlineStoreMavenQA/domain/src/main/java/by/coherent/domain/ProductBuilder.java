package by.coherent.domain;


public class ProductBuilder {

    private String name;
    private int rating;
    private double price;
    private String attributeOne;
    private String attributeTwo;

    public static Builder newBuilder() {
        return new ProductBuilder().new Builder();
    }

    public class Builder {
        private String name;
        private int rating;
        private double price;
        private String attributeOne;
        private String attributeTwo;

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

        public Builder setAttributeOne(String attributeOne) {
            this.attributeOne = attributeOne;
            return this;
        }

        public Builder setAttributeTwo(String attributeTwo) {
            this.attributeTwo = attributeTwo;
            return this;
        }

        public ProductBuilder build() {
            ProductBuilder.this.name = this.name;
            ProductBuilder.this.rating = this.rating;
            ProductBuilder.this.price = this.price;
            ProductBuilder.this.attributeOne = this.attributeOne;
            ProductBuilder.this.attributeTwo = this.attributeTwo;
            return ProductBuilder.this;
        }

    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setAttributeOne(String attributeOne) {
        this.attributeOne = attributeOne;
        return this;
    }

    public ProductBuilder setAttributeTwo(String attributeTwo) {
        this.attributeTwo = attributeTwo;
        return this;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append("\'");
        sb.append(", rating").append(rating);
        sb.append(", price").append(price);
        sb.append(", attributeOne=").append(attributeOne);
        sb.append(", attributeTwo=").append(attributeTwo).append("}");
        return sb.toString();
    }

}
