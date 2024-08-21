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
        System.out.println("Fields K:"+fields);
        Map<String, String> radarIn = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        radarIn = objectMapper.convertValue(fields.toBuilder().build(), new TypeReference<Map<String, String>>() {
        });
        System.out.println("radarIn1:"+radarIn);
        radarIn.putAll(SystemSetMapping.systemMapping(radarIn));
        System.out.println("radarIn2:"+radarIn);
        return radarIn;
    }
}
