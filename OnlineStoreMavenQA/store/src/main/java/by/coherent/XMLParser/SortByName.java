package by.coherent.XMLParser;

import by.coherent.domain.Product;

import java.util.Comparator;

public class SortByName implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getName().compareTo(product2.getName());
    }
}
