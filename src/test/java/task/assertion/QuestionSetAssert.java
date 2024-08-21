package task.assertion;

import org.w3c.dom.Document;

import static utils.XMLUtils.parseXMLFile;
import static utils.XMLUtils.writeXMLasString;

import org.w3c.dom.Node;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.*;
import utils.XMLUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionSetAssert {

    public static void compareXML(String fileName) {
        Document exp = parseXMLFile("src/test/resources/expected/" + fileName + "Expected.xml");
        Document act = parseXMLFile("src/test/resources/actual/" + fileName + "Actual.xml");
        String actual = writeXMLasString(act);
        String expected = writeXMLasString(exp);
        checkForXMLMisMatches(actual, expected);

    }

    public static void checkForXMLMisMatches(String actual, String expected) {
        String[] jsonIgnore = XMLUtils.getIgnoreTags();
        Diff diff = DiffBuilder.compare(expected)
                .withTest(actual)
                .withNodeFilter(node -> testNode(node, jsonIgnore))
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
                .ignoreWhitespace().checkForSimilar().build();
        Iterator<Difference> differences = diff.getDifferences().iterator();
        int size = 0;
        List<String> dif = new ArrayList<>();
        while (differences.hasNext()) {
            String difference = differences.next().toString();
            dif.add(difference);
            System.out.println("Difference:" + difference);
            size++;
        }
    }

    private static boolean testNode(Node node, String[] name) {
        for (String s : name) {
            if (node.getNodeName().equalsIgnoreCase(s)) {
                return false;
            }
        }
        return true;
    }
}
