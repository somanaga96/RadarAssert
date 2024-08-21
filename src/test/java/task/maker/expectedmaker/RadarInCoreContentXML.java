package task.maker.expectedmaker;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import task.maker.nodestructure.GetQuoteTag;
import utils.CreateExpectedFile;

import java.io.BufferedReader;
import java.io.StringReader;

public class RadarInCoreContentXML {
    public static void frameContenXML(String json) {
        try {
            Document doc = new Document();
            Element root = new Element("root");
            BufferedReader bf = new BufferedReader(new StringReader(json));
            JsonReader jsonReader = new JsonReader(bf);

            JsonElement jos = JsonParser.parseReader(jsonReader);
            System.out.println("jsonreader:" + jos);
            JsonElement object = jos.getAsJsonObject().getAsJsonObject("root");
            System.out.println("root:" + root);
            JsonElement quote = object.getAsJsonObject().getAsJsonObject("Quote");
            System.out.println("quote:" + quote);
            root.addContent(GetQuoteTag.getStructure(quote));
            doc.addContent(root);
            XMLOutputter outPutter = new XMLOutputter(Format.getPrettyFormat());
            String s = outPutter.outputString(doc);
//            System.out.println("xml:" + s);
            CreateExpectedFile.frameExpected(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
