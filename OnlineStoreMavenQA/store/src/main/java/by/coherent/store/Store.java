package by.coherent.store;

import by.coherent.domain.Category;
import by.coherent.domain.Product;

import java.util.ArrayList;
import java.util.List;


public class Store {
    private static Store uniqueInstance = null;
    private List<Category> categoryList = new ArrayList<>();

    private Store() {

        System.out.println("Initialized store");
    }

    public static synchronized Store getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Store();
        return uniqueInstance;
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public List<Category> getCategories() {
        return categoryList;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        for (Category cat : categoryList) {
            productList.addAll(cat.getProductList());
        }
        return productList;
    }

    public void printCategoryAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }

    }

}
