package by.coherent.store.helpers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryGetHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange he) throws IOException {
        ArrayList resultMetaData;
        try {
            resultMetaData = SQLCommands.returnCategoryTable();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String response = "<h1>" + resultMetaData + "</h1>";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}