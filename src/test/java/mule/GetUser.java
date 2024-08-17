package mule;

import com.example.generated.singleUser.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import csv.CSVMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import maker.GetCSVDataMaker;
import model.QuestionSetPropertyFields;

import java.util.Map;

public class GetUser {
    public static Map<String, String> getUserById(Map<String, String> radarIn) {
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();
        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.given().log().all().get("/api/users/" + fields.getScenarioId());
        UserResponse userResponse;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userResponse = objectMapper.readValue(response.getBody().asString(), new TypeReference<UserResponse>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        GetCSVDataMaker.setUserResponse(userResponse);
        return radarIn;
    }
}
