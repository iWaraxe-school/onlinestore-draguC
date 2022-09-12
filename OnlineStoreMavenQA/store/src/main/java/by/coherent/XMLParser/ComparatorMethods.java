package by.coherent.XMLParser;

import by.coherent.domain.Category;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.coherent.domain.Product;
import by.coherent.store.*;

public class ComparatorMethods {

    public List<Product> getAllProducts(Store store) {
        List<Product> allProducts = new ArrayList<>();
        for (Category category : store.getCategories()) {
            allProducts.addAll(category.getProductList());
        }
        return allProducts;
    }

    private static final Map<String, Comparator<Product>> COMPARATOR_MAP = new LinkedHashMap<String, Comparator<Product>>() {{

        put("name", Comparator.comparing(Product::getName));

        put("price", Comparator.comparing(Product::getPrice));

        put("rate", Comparator.comparing(Product::getRating));
    }};

    private Comparator<Product> prepareComparator(Map.Entry<String, String> entry) {
        String comparatorName = entry.getKey();
        Comparator<Product> comparator = COMPARATOR_MAP.getOrDefault(comparatorName, null);

        if (entry.getValue().equals(SortingTypes.DESC.toString()) && Objects.nonNull(comparator)) {
            comparator = comparator.reversed();
        }
        return comparator;
    }

    private Comparator<Product> buildComparator(Map<String, String> comparatorConfig) throws Exception {
        return comparatorConfig.entrySet().stream()
                .map(this::prepareComparator)
                .filter(Objects::nonNull)
                .reduce(Comparator::thenComparing)
                .orElseThrow(Exception::new);
    }

    private Stream<Product> buildSortProductStream(Store store, Comparator<Product> comparator) {
        return getAllProducts(store)
                .stream()
                .sorted(comparator);
    }

    public void sortProducts(Store store) throws Exception {
        Map<String, String> configMap = XMLReaderToMap.getAllPropertiesToSort();
        Comparator<Product> productComparator = buildComparator(configMap);
        Stream<Product> sortProductsStream = buildSortProductStream(store, productComparator);
        List<Product> allProductListFromStream = sortProductsStream.collect(Collectors.toList());
        System.out.println("-----------------------------------------------");
        System.out.println("SORT PRODUCTS - COMPARATOR FROM STREAM");
        System.out.println("-----------------------------------------------");
        for (Product product : allProductListFromStream) {
            System.out.println(product);
        }
    }

    public void getTop5(Store store) {
        List<Product> allProducts = getAllProducts(store);
        allProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        System.out.println("----------------------------");
        System.out.println("TOP 5");
        System.out.println("----------------------------");
        for (Product product : allProducts.subList(0, 5)) {
            System.out.println(product);
        }
    }

}

