package csv;

import lombok.Getter;
import model.QuestionSetPropertyFields;

public class CSVMapper {


    @Getter
    private static QuestionSetPropertyFields questionSetPropertyFields;

    public static void setQuestionSetPropertyFields(QuestionSetPropertyFields questionSetPropertyFields) {
        CSVMapper.questionSetPropertyFields = questionSetPropertyFields;

    }
}
