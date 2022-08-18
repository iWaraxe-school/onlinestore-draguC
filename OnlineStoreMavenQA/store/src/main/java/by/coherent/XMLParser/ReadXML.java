package by.coherent.XMLParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;


public class ReadXML {

    public static void main(String[] args) {

        final Map<String, String> allPropertiesToSort = XMLReaderToMap.getAllPropertiesToSort();
        System.out.println("Parser with DOM");
        System.out.println(allPropertiesToSort);


    }

}