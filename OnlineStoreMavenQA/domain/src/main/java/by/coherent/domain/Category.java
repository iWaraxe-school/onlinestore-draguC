package by.coherent.domain;

import java.util.List;

public class Category {
    private String name;
    private List<Product> productList;


    public Category(String name){

        this.name = name;

    }
    public String getName(){
        System.out.println(name);
        return this.name;
    }
    public void addProduct(Product product){
        productList.add(product);
    }
}
