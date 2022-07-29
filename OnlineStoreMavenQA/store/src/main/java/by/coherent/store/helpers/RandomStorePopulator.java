package by.coherent.store.helpers;

import by.coherent.domain.Category;
import by.coherent.domain.Product;
import by.coherent.store.Store;
import org.reflections.Reflections;


import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class RandomStorePopulator {
    Store store;

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

    private static Set<Category> createCategorySet() {
        Set<Category> categorySet = new HashSet<>();
        Reflections reflections = new Reflections("by.coherent.domain.category");
        Set<Class<?>> subTypes =
                reflections.get(SubTypes.of(Category.class).asClass());
        for (Class<? extends Category> c : subTypes) {
            Category category = null;
            try {
                category = c.getConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            categorySet.add(category);
        }
        return categorySet;
    }


    public void populateProducts() {
        RandomProductGenerator populator = new RandomProductGenerator();
        Set<Category> categorySet = createCategorySet();
        for (Category category : categorySet) {

            this.store.addCategory(category);
            for (int i = 0; i < 3; i++) {
                Product product = new Product(
                        populator.getProductName(category.getName()),
                        populator.getRating(),
                        populator.getPrice());
                category.addProduct(product);
            }

        }
    }

}


