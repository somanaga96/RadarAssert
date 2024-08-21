package task.maker;

import csv.CSVMapper;
import mapping.RadarMapping;
import model.QuestionSetPropertyFields;
import task.assertion.QuestionSetAssert;

import java.io.IOException;
import java.util.Map;

public class RadarAssert {

    public static void play() throws IOException {
        QuestionSetPropertyFields fields= CSVMapper.getQuestionSetPropertyFields();
        Map<String, String> getRadarInput = RadarMapping.csvToHashMap();
        System.out.println("Map :"+getRadarInput);
        GetCSVDataMaker.setRadarInput(getRadarInput);
        QuestionSetAssert.compareXML(fields.getScenarioId());
    }

}
