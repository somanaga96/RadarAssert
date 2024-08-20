package maker;

import mapping.RadarMapping;

import java.io.IOException;
import java.util.Map;

public class RadarAssert {

    public static void play() throws IOException {
        Map<String, String> getRadarInput = RadarMapping.csvToHashMap();
        GetCSVDataMaker.setRadarInput(getRadarInput);
    }

}
