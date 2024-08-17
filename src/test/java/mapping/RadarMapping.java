package mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import csv.CSVMapper;
import model.QuestionSetPropertyFields;
import mule.GetUser;

import java.util.Map;

public class RadarMapping {
    public static Map<String, String> csvToHashMap() throws JsonProcessingException {
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();
        Map<String, String> csvMap;
        ObjectMapper objectMapper = new ObjectMapper();
        csvMap = objectMapper.convertValue(fields.toBuilder().build(), new TypeReference<Map<String, String>>() {
        });
//        csvMap = PostUser.addUser(csvMap);
        csvMap = GetUser.getUserById(csvMap);
        return csvMap;
    }
}
