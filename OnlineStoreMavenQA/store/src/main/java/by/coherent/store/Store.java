package by.coherent.store;

import by.coherent.domain.Category;
import by.coherent.domain.Product;

import java.util.ArrayList;
import java.util.List;


public class Store {
    public List<Product> PurchasedProducts = new ArrayList<>();
    private static List<Category> categoryList = new ArrayList<>();

    private Store() {
        System.out.println("Initialized store");
    }

    private static class SingletonHelper{
        private static final Store UNIQUE_INSTANCE = new Store();
    }

    public static Store getInstance() {
        return SingletonHelper.UNIQUE_INSTANCE;

    }

    public static void addCategory(Category category) {
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
