package csv.mapcsvdata;

import csv.ReadCSVData;
import model.QuestionSetCycleFields;
import org.apache.commons.csv.CSVRecord;

import java.util.LinkedList;
import java.util.List;

public class MapCycleCSVData {
    public static List<QuestionSetCycleFields> cycleRead() {
        List<QuestionSetCycleFields> cycleList = new LinkedList<>();
        for (CSVRecord csvRecord : ReadCSVData.recordIterable("./csv/cycles.csv")) {
            cycleList.add(QuestionSetCycleFields.builder()
                    .scenarioId(csvRecord.get("ScenarioId"))
                    .run(csvRecord.get("Run"))
                    .value(csvRecord.get("Value"))
                    .coverOutSide(csvRecord.get("CoverOutside"))
                    .build());
        }
        return cycleList;
    }
}
