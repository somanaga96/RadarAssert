package maker.radarin;

import com.example.generated.RadarIn.RadarInput;
import com.example.generated.RadarIn.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maker.expectedmaker.RadarInCoreContentXML;

public class RadarInRequestMaker {
    public static void makeRadarInput() throws JsonProcessingException {
        RadarInput radarInput = new RadarInput();
        radarInput.setRoot(makeRoot());
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(radarInput);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        RadarInCoreContentXML.frameContenXML(json);
//        RadarInCoreXML.frameXML(json);
        System.out.println("Json2 :" + json);
    }

    public static Root makeRoot() {
        Root root = new Root();
        root.setQuote(QuoteRequestMaker.makeQuote());
        return root;
    }
}
