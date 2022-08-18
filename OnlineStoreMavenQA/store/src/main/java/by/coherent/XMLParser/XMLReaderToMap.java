package by.coherent.XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class XMLReaderToMap {

    private final static String PATH = "C:\\Users\\CosticaDragu\\IdeaProjects\\onlinestore-draguC\\OnlineStoreMavenQA\\store\\src\\main\\resources\\config.xml";

    public static Map<String, String> getAllPropertiesToSort() {
        String sortTag = "sort";
        Map<String, String> propertiesMap = new LinkedHashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(PATH);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        Node node = document.getElementsByTagName(sortTag).item(0);
        NodeList sortProperties = node.getChildNodes();

        Element element;
        for (int i = 0; i < sortProperties.getLength(); i++) {
            if (sortProperties.item(i).getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) sortProperties.item(i);

                String key = element.getTagName().toLowerCase(Locale.ROOT);
                String value = element.getTextContent().toUpperCase(Locale.ROOT);

                propertiesMap.put(key, value);

            }

        }

        return propertiesMap;
    }


}
