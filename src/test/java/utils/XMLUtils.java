package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {
    public static Document parseXMLFile(String filePath) {
        Document document = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            File file = new File(filePath);
            document = documentBuilder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String writeXMLasString(Document document) {
        String xml = "";
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static JsonObject readJsonFile(String fileName) {
        try {
            BufferedReader bfs = new BufferedReader(new FileReader(fileName));
            JsonReader jsonReader = new JsonReader(bfs);
            JsonElement joss = JsonParser.parseReader(jsonReader);
            return joss.getAsJsonObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getIgnoreTags() {
        JsonObject s = XMLUtils.readJsonFile("src/test/resources/config/IgnoreTag.json");
        List<String> l = new ArrayList<>(s.keySet());
        return l.toArray(new String[0]);
    }
}
