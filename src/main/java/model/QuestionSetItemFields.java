package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class QuestionSetItemFields {
    private String name;
    private String run;
    private String value;
    private String coverOutSide;
}
