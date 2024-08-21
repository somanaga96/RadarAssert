package task.maker.nodestructure;

import com.google.gson.JsonElement;
import org.jdom2.Element;

import java.util.Map;
import java.util.stream.Stream;

public class PropertyTag {
    public static Element getPropertyTag(JsonElement quote) {
        System.out.println("quote:" + quote);
        Element name;
        Element cycleList;
        Element cycle;
        Element child = new Element("property");
        for (Map.Entry<String, JsonElement> ns : quote.getAsJsonObject().entrySet()) {
            if (Stream.of("cycle").noneMatch(ns.getKey()::equalsIgnoreCase)) {
                name = new Element(ns.getKey()).setAttribute("value", ns.getValue().getAsString());
                child.addContent(name);
            }
            if (Stream.of("cycle").anyMatch(ns.getKey()::equalsIgnoreCase)) {
//                System.out.println("ns:" + ns.getKey() + "--" + ns.getValue());
                for (JsonElement jsonElement : ns.getValue().getAsJsonArray()) {
                    System.out.println("Cycle jsonElement:" + jsonElement);
                    cycleList = new Element(ns.getKey());
                    child.addContent(cycleList);
                    for (Map.Entry<String, JsonElement> props : jsonElement.getAsJsonObject().entrySet()) {
                        cycle = new Element(props.getKey()).setAttribute("value", props.getValue().getAsString());
                        cycleList.addContent(cycle);
                    }
                }
            }
        }
        return child;
    }
}
