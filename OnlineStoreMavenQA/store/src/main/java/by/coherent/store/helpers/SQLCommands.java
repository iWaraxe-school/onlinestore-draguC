package by.coherent.store.helpers;

import by.coherent.domain.Category;
import by.coherent.store.Store;

import java.sql.*;
import java.util.*;

public class SQLCommands {
    public static void populateProductsTable() throws ClassNotFoundException, SQLException {
        RandomProductGenerator productGenerator = new RandomProductGenerator();
        Set<Category> categorySet = RandomStorePopulator.createCategorySet();
        String createTable = "CREATE TABLE IF NOT EXISTS PRODUCTS(ID INT PRIMARY KEY, NAME VARCHAR(255), RATING INT, PRICE INT);";
        String dropTable = "DELETE FROM PRODUCTS";
        Class.forName("org.h2.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
             Statement st = con.createStatement()) {
            st.executeUpdate(createTable);
            st.executeUpdate(dropTable);
            int j = 0;
            for (Category category : categorySet) {
                Store.addCategory(category);
                for (int i = 0; i < 3; i++) {
                    String insertNewRow = "INSERT INTO PRODUCTS(ID, NAME, RATING, PRICE) VALUES(" + j + ",'"
                            + productGenerator.getProductName(category.getName()) + "',"
                            + productGenerator.getRating() + ","
                            + productGenerator.getPrice() + ")";
                    st.execute(insertNewRow);
                    System.out.println("Inserting attempt " + j);
                    j++;

                }

            }

        }
    }

    public static ArrayList returnProductsTable() throws ClassNotFoundException, SQLException {
        ArrayList resultMetaData = new ArrayList<>();
        String selectQuery = "SELECT * FROM PRODUCTS";

        Class.forName("org.h2.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
             Statement st = con.createStatement()) {
            ResultSet resultSet = st.executeQuery(selectQuery);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " " + columnValue);
                    resultMetaData.add("<br>" + rsmd.getColumnName(i) + " " + columnValue);
                }
                System.out.println("");
            }
        }
        return resultMetaData;
    }

    public static void populateCategoryTable() throws ClassNotFoundException, SQLException {
        Set<Category> categorySet = RandomStorePopulator.createCategorySet();
        String createTable = "CREATE TABLE IF NOT EXISTS CATEGORY(ID INT, NAME VARCHAR(255) PRIMARY KEY);";
        String dropTable = "DELETE FROM CATEGORY";
        Class.forName("org.h2.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
             Statement st = con.createStatement()) {
            st.executeUpdate(createTable);
            st.executeUpdate(dropTable);
            int j = 0;
            for (Category category : categorySet) {
                Store.addCategory(category);
                String insertNewRow = "INSERT INTO CATEGORY(ID, NAME) VALUES(" + j + ",'"
                        + category.getName() + "')";
                st.execute(insertNewRow);
                j++;

            }

        }

    }

    public static ArrayList returnCategoryTable() throws ClassNotFoundException, SQLException {
        String selectQuery = "SELECT * FROM CATEGORY";
        ArrayList resultMetaData = new ArrayList<>();

        Class.forName("org.h2.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
             Statement st = con.createStatement()) {
            ResultSet resultSet = st.executeQuery(selectQuery);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " " + columnValue);
                    resultMetaData.add("<br>" + rsmd.getColumnName(i) + " " + columnValue);
                }
                System.out.println("");
            }
        }
        return resultMetaData;
    }

    public static void addRandomProductToCart() throws ClassNotFoundException, SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS CART(ID INT PRIMARY KEY, NAME VARCHAR(255), RATING INT, PRICE INT);";
        String dropTable = "DELETE FROM CART";
        Class.forName("org.h2.Driver");
        Random random = new Random();

        try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
             Statement st = con.createStatement()) {
            st.executeUpdate(createTable);
            st.executeUpdate(dropTable);
            String copyRandomRowFromProductToCart = "INSERT INTO CART SELECT * FROM PRODUCTS WHERE ID =" + random.nextInt(9) + ";";
            st.executeUpdate(copyRandomRowFromProductToCart);
        }

    }

}
