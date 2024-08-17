package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class QuestionSetPropertyFields {
    private String scenarioId;
    private String run;
    private String fName;
    private String lName;
    private String dob;

}
