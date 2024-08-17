package csv;

import model.QuestionSetPropertyFields;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class MapCSVData {
    public static List<QuestionSetPropertyFields> read(String csvPath) {
        List<QuestionSetPropertyFields> fields = new ArrayList<>();
        for (CSVRecord csvRecord : ReadCSVData.recordIterable(csvPath)) {
            fields.add(QuestionSetPropertyFields.builder()
                    .scenarioId(csvRecord.get("ScenarioId"))
                    .run(csvRecord.get("Run"))
                    .fName(csvRecord.get("FirstName"))
                    .lName(csvRecord.get("LastName"))
                    .dob(csvRecord.get("DOB"))
                    .build());
        }
        return fields;
    }
}
