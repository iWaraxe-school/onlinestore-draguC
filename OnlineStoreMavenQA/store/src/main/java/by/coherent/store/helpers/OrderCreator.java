package by.coherent.store.helpers;

import by.coherent.domain.Product;
import by.coherent.store.Store;

public class OrderCreator implements Runnable {

    private Product selectedProduct;

    private int sleepTime;

    public OrderCreator(Product selectedProduct, int sleepTime) {
        this.selectedProduct = selectedProduct;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Store.getInstance().PurchasedProducts.add(selectedProduct);
        System.out.println("Running thread ID " + Thread.currentThread().getId());
        Store.getInstance().PurchasedProducts.forEach(System.out::println);

    }
}
