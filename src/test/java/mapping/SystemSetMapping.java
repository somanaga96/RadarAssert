package mapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mule.GetUser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SystemSetMapping {
    public static Map<String, String> systemMapping(Map<String, String> radarInput) throws IOException {
        File file = new File("src/test/resources/config/SystemTag.json");
        ObjectMapper objectMapper = new ObjectMapper();
        radarInput = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {
        });
        System.out.println("system mapping:"+radarInput);
        radarInput.putAll(GetUser.getUserById(radarInput));
        return radarInput;
    }
}
