package mapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import csv.CSVMapper;
import model.QuestionSetPropertyFields;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RadarMapping {
    public static Map<String, String> csvToHashMap() throws IOException {
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();
        Map<String, String> radarIn = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        radarIn = objectMapper.convertValue(fields.toBuilder().build(), new TypeReference<Map<String, String>>() {
        });
        radarIn.putAll(SystemSetMapping.systemMapping(radarIn));
        return radarIn;
    }
}
