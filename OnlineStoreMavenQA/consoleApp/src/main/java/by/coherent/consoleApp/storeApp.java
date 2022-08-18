package by.coherent.consoleApp;

import by.coherent.XMLParser.ComparatorMethods;
import by.coherent.XMLParser.SortByName;
import by.coherent.XMLParser.SortByPrice;
import by.coherent.XMLParser.SortByRating;
import by.coherent.domain.Product;
import by.coherent.store.Store;
import by.coherent.store.helpers.RandomStorePopulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class storeApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator(onlineStore);
        randomStorePopulator.populateProducts();
        onlineStore.printCategoryAndProducts();
        ArrayList<Product> ar = new ArrayList<>(onlineStore.getAllProducts());

        System.out.println("Unsorted");
        for (Product product : ar) System.out.println(product);

        ar.sort(new SortByPrice());
        System.out.println("\nSorted by Price");
        for (Product product : ar) System.out.println(product);

        ar.sort(new SortByName());
        System.out.println("\nSorted by Name");
        for (Product product : ar) System.out.println(product);

        ar.sort(new SortByRating());
        System.out.println("\nSorted by Rating");
        for (Product product : ar) System.out.println(product);

        ar.sort(new SortByPrice().reversed());
        System.out.println("\nSorted by Top 5");
        for (int i = 0; i < 5; i++)
            System.out.println(ar.get(i));



    }
}
