package by.coherent.consoleApp;

import by.coherent.XMLParser.ComparatorMethods;
import by.coherent.domain.Product;
import by.coherent.store.helpers.RandomStorePopulator;
import by.coherent.store.Store;

import java.util.Scanner;

public class storeApp {
    public static void main(String[] args) throws Exception {
        Store onlineStore = new Store();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator(onlineStore);
        randomStorePopulator.populateProducts();
        onlineStore.printCategoryAndProducts();
        ComparatorMethods comparatorMethods = new ComparatorMethods();
        System.out.println("Enter 'S' to sort by name,'T' for top 5, or 'Q' to exit");
        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("s")) {
                comparatorMethods.sortProducts(onlineStore);
            } else if (userInput.equalsIgnoreCase("t")) {
                comparatorMethods.getTop5(onlineStore);
            } else if (userInput.equalsIgnoreCase("q")) {
                System.exit(0);
            } else {
                System.out.println("Input is incorrect, Enter 'S' to sort by name,'T' for top 5, or 'Q' to exit");
            }
        }
    }
}
