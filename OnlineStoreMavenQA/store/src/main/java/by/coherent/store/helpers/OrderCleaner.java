package by.coherent.store.helpers;

import by.coherent.store.Store;

import java.util.TimerTask;

public class OrderCleaner extends TimerTask {

    @Override
    public void run() {
        System.out.println("Running cleaner...");
        Store.getInstance().PurchasedProducts.clear();
    }
}