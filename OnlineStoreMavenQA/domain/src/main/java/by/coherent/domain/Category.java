package by.coherent.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> productList;


    public Category(String name) {

        this.name = name;
        this.productList = new ArrayList<>();

    }


    public String getName() {
        return this.name;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void printAllProducts() {
        System.out.println(String.format("%s", "======================================================="));
        System.out.println("Category: " + name);
        System.out.println(String.format("%s", "======================================================="));
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public List<Product> getProductList() {
        return this.productList;
    }
}
