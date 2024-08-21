package mule;

import com.example.generated.singleUser.UserResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import task.maker.GetCSVDataMaker;

import java.util.Map;

public class PostUser {

    public static Map<String, String> addUser(Map<String, String> map) {
        RestAssured.baseURI = "https://reqres.in";
        Response postResponse = RestAssured.given().log().all().post("/api/users");
        ObjectMapper objectMapper = new ObjectMapper();
        UserResponse response = objectMapper.convertValue(postResponse.getBody().asString(), new TypeReference<UserResponse>() {
        });
        GetCSVDataMaker.setUserResponse(response);
        return map;
    }
}
