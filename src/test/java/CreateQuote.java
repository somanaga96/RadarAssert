import com.fasterxml.jackson.core.JsonProcessingException;
import csv.CSVMapper;
import csv.MapCSVData;
import model.QuestionSetPropertyFields;
import maker.RadarAssert;
import org.junit.Test;

import java.util.List;

public class CreateQuote extends CSVMapper {

    @Test
    public void quoteCreation() {
        List<QuestionSetPropertyFields> mapper = MapCSVData.read("./csv/QuestionSet.csv");
        mapper.forEach(questionSet -> {
            setQuestionSetPropertyFields(questionSet.toBuilder().build());
            if (questionSet.getRun().equalsIgnoreCase("Yes")) {
//                UiPlay.ui();
                try {
                    RadarAssert.play();
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}


