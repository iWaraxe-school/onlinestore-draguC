package by.coherent.consoleApp;

import by.coherent.store.Store;
import by.coherent.store.helpers.RandomStorePopulator;

public class storeApp {
    public static void main(String[] args) {
        Store onlineStore = new Store();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator(onlineStore);
        randomStorePopulator.populateProducts();
        onlineStore.printCategoryAndProducts();

    }
}
