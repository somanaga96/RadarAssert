package task.maker;


import com.example.generated.singleUser.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import task.maker.radarin.RadarInRequestMaker;

import java.util.Map;


public class GetCSVDataMaker {
    static Map<String, String> radarInput;
    @Getter
    @Setter
    private static UserResponse userResponse;


    public static void setRadarInput(Map<String, String> map) throws JsonProcessingException {
        radarInput = map;
        RadarInRequestMaker.makeRadarInput();
    }

    public static Map<String, String> getRadarInput() {
        return radarInput;
    }

}
