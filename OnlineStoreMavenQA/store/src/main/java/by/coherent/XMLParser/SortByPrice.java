package by.coherent.XMLParser;

import by.coherent.domain.Product;

import java.util.Comparator;

public class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
       return Double.compare(product1.getPrice(), product2.getPrice());
    }
}
