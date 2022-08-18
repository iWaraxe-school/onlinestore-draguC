package by.coherent.XMLParser;

import by.coherent.domain.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ComparatorMethods {
    LinkedHashSet<Product> hashSet;

    //Print products by ascending prices
    public void printAscendingPrices(LinkedHashSet<Product> hashSet) {
        this.hashSet = hashSet;

        System.out.println("Items in ascending order: " + "\n" + Arrays.toString(hashSet.stream().sorted(Comparator.comparingDouble(Product::getPrice)).toArray()));
    }
    //Print products by descending prices
    public void printDescendingPrices(LinkedHashSet<Product> hashSet) {
        this.hashSet = hashSet;
        System.out.println("Items in descending order: " + "\n" + Arrays.toString(hashSet.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toArray()));
    }
    //Print top 5 products by price
    public void printTop5Prices(LinkedHashSet<Product> hashSet) {
        this.hashSet = hashSet;
        System.out.println("Top 5 items: " + "\n" + Arrays.toString(hashSet.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(5).toArray()));
    }

    //User console used in storeApp - placeholder
//    ComparatorMethods comparatorMethods = new ComparatorMethods();
//        System.out.println("Enter 's' to sort, 't' for top 5, or 'q' to exit");
//        while (true) {
//        Scanner input = new Scanner(System.in);
//        String userInput = input.next();
//        if (userInput.equalsIgnoreCase("s")) {
//            comparatorMethods.printAscendingPrices(hashSet);
//        }
//        else if (userInput.equalsIgnoreCase("t")) {
//            comparatorMethods.printTop5Prices(hashSet);
//        }
//        else if (userInput.equalsIgnoreCase("q")) {
//            System.exit(0);
//        } else {
//            System.out.println("Input is incorrect, try 's', 't' or 'q'");
//        }
//    }
}
