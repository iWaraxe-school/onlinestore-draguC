package by.coherent.consoleApp;

import by.coherent.XMLParser.ComparatorMethods;
import by.coherent.domain.Product;
import by.coherent.store.helpers.OrderCleaner;
import by.coherent.store.helpers.OrderCreator;
import by.coherent.store.helpers.RandomStorePopulator;
import by.coherent.store.Store;
import com.github.javafaker.Faker;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class storeApp {

    public static void main(String[] args) throws Exception {
        Store onlineStore = Store.getInstance();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator(onlineStore);
        randomStorePopulator.populateProducts();
        onlineStore.printCategoryAndProducts();
        Timer timer =  new Timer();
        timer.schedule(new OrderCleaner(),0,120000);
        ComparatorMethods comparatorMethods = new ComparatorMethods();
        System.out.println("Enter 'S' to sort by name,'T' for top 5, 'B' to simulate multiple orders or 'Q' to exit");
        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("s")) {
                comparatorMethods.sortProducts(onlineStore);
            } else if (userInput.equalsIgnoreCase("t")) {
                comparatorMethods.getTop5(onlineStore);
            } else if (userInput.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if (userInput.equalsIgnoreCase("b")) {
                int listMaxSize = onlineStore.getAllProducts().size();
                Random random = new Random();

                while (true) {

                    Product selectedProduct = onlineStore.getAllProducts().get(random.nextInt(listMaxSize));
                    OrderCreator orderCreator = new OrderCreator(selectedProduct, random.nextInt(3) + 1);
                    new Thread(orderCreator).start();
                    Thread.sleep(10000);
                }
            } else {
                System.out.println("Input is incorrect, Enter 'S' to sort by name,'T' for top 5, 'B' to simulate multiple orders or 'Q' to exit");
            }

        }
    }

}
