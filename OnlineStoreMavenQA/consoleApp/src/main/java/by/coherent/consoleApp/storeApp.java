package by.coherent.consoleApp;

import by.coherent.store.helpers.*;
import by.coherent.store.Store;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class storeApp {
    static final int port = 9000;


    public static void main(String[] args) throws Exception {
        Store onlineStore = Store.getInstance();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator(onlineStore);
        randomStorePopulator.populateProducts();
        onlineStore.printCategoryAndProducts();
        SQLCommands.populateProductsTable();
        SQLCommands.populateCategoryTable();
        SQLCommands.returnProductsTable();
        //SQLCommands.returnCategoryTable();
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new HeaderHandler());
        HttpContext get = server.createContext("/GetCategories", new CategoryGetHandler());
        HttpContext post = server.createContext("/PostProduct", new ProductPostHandler());
        get.setAuthenticator(new BasicAuthenticator("/GetCategories") {

            @Override

            public boolean checkCredentials(String user, String pwd) {

                return user.equals("admin") && pwd.equals("password");

            }

        });
        post.setAuthenticator(new BasicAuthenticator("/PostProduct") {

            @Override

            public boolean checkCredentials(String user, String pwd) {

                return user.equals("admin") && pwd.equals("password");

            }

        });

        server.setExecutor(null);
        server.start();
        //SQLCommands.returnProductsTable();
/*        Timer timer =  new Timer();
        timer.schedule(new OrderCleaner(),0,120000);
        ComparatorMethods comparatorMethods = new ComparatorMethods();
        System.out.println("Enter 'S' to sort by name,'T' for top 5, 'B' to simulate multiple orders or 'Q' to exit");
        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("s")) {
                comparatorMethods.sortProducts(onlineStore);
            } else if (userInput.equalsIgnoreCase("t")) {
                comparatorMethods.getTop5(onlineStore);
            } else if (userInput.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if (userInput.equalsIgnoreCase("b")) {
                int listMaxSize = onlineStore.getAllProducts().size();
                Random random = new Random();

                while (true) {

                    Product selectedProduct = onlineStore.getAllProducts().get(random.nextInt(listMaxSize));
                    OrderCreator orderCreator = new OrderCreator(selectedProduct, random.nextInt(3) + 1);
                    new Thread(orderCreator).start();
                    Thread.sleep(10000);
                }
            } else {
                System.out.println("Input is incorrect, Enter 'S' to sort by name,'T' for top 5, 'B' to simulate multiple orders or 'Q' to exit");
            }

        }*/
    }

}

