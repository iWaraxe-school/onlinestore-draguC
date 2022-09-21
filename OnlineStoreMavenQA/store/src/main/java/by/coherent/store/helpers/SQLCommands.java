package by.coherent.store.helpers;

import by.coherent.domain.Category;
import by.coherent.store.Store;

import java.sql.*;
import java.util.Set;

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

    public static void returnProductsTable() throws ClassNotFoundException, SQLException {
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
                }
                System.out.println("");
            }
        }
    }
}