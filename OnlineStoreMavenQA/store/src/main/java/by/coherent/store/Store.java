package by.coherent.store;

import by.coherent.domain.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Category> categoryList = new ArrayList<>();

    public Store() {

        System.out.println("Initialized store");
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public void printCategoryAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }

    }

}
