import csv.CSVMapper;
import csv.mapcsvdata.MapQuestionSetCSVData;
import model.QuestionSetPropertyFields;
import task.maker.RadarAssert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CreateQuote extends CSVMapper {

    @Test
    public void quoteCreation() {
        List<QuestionSetPropertyFields> mapper = MapQuestionSetCSVData.read("./csv/QuestionSet.csv");
        mapper.forEach(questionSet -> {
            setQuestionSetPropertyFields(questionSet.toBuilder().build());
            if (questionSet.getRun().equalsIgnoreCase("Yes")) {
                System.out.println("CSV :" + questionSet);
//                UiPlay.ui();
                try {
                    RadarAssert.play();
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}


