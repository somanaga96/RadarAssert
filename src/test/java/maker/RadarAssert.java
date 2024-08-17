package maker;

import com.fasterxml.jackson.core.JsonProcessingException;
import mapping.RadarMapping;

import java.util.Map;

public class RadarAssert {

    public static void play() throws JsonProcessingException {
        Map<String, String> getRadarInput = RadarMapping.csvToHashMap();
        GetCSVDataMaker.setRadarInput(getRadarInput);
    }

}
