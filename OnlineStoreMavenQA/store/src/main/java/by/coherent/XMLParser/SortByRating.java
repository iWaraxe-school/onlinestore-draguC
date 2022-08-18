package by.coherent.XMLParser;

import by.coherent.domain.Product;

import java.util.Comparator;

public class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
       return Integer.compare(product1.getRating(), product2.getRating());
    }
}
