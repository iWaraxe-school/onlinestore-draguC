package by.coherent.store.helpers;

import by.coherent.store.Store;

public class OrderCleaner implements Runnable {

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Running cleaner...");
            Store.getInstance().PurchasedProducts.clear();
        }
    }
}
