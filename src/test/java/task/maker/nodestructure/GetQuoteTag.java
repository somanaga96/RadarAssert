package task.maker.nodestructure;

import com.google.gson.JsonElement;
import org.jdom2.Element;

import java.util.Map;
import java.util.stream.Stream;

import static task.maker.nodestructure.PropertyTag.getPropertyTag;

public class GetQuoteTag {

    public static Element getStructure(JsonElement quote) {
        System.out.println("element:" + quote);
        Element name;
        Element data;
        Element dataValue;
        Element item;
        Element itemList;
        Element child = new Element("Quote");
        for (Map.Entry<String, JsonElement> ns : quote.getAsJsonObject().entrySet()) {
            System.out.println("ns :" + ns.getValue());
            if (Stream.of("data", "support", "property", "item").noneMatch(ns.getKey()::equalsIgnoreCase)) {
                name = new Element(ns.getKey()).setAttribute("value", ns.getValue().getAsString());
                child.addContent(name);
            }
            else if (Stream.of("data", "support").anyMatch(ns.getKey()::equalsIgnoreCase)) {
                data = new Element(ns.getKey());
                child.addContent(data);
                for (Map.Entry<String, JsonElement> Prps : ns.getValue().getAsJsonObject().entrySet()) {
                    dataValue = new Element(Prps.getKey()).setAttribute("value", Prps.getValue().getAsString());
                    data.addContent(dataValue);
                }
            } else if (Stream.of("Item").anyMatch(ns.getKey()::equalsIgnoreCase)) {
//                System.out.println("ns:" + ns.getKey() + "--" + ns.getValue());
                for (JsonElement jsonElement : ns.getValue().getAsJsonArray()) {
                    System.out.println("Item jsonElement:" + jsonElement);
                    itemList = new Element(ns.getKey());
                    child.addContent(itemList);
                    for (Map.Entry<String, JsonElement> props : jsonElement.getAsJsonObject().entrySet()) {
                        item = new Element(props.getKey()).setAttribute("value", props.getValue().getAsString());
                        itemList.addContent(item);
                    }
                }
            }
        }
        JsonElement property = quote.getAsJsonObject().getAsJsonObject("property");
        child.addContent(getPropertyTag(property));
        return child;
    }
}
