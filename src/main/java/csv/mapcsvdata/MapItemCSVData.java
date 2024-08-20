package csv.mapcsvdata;

import csv.ReadCSVData;
import model.QuestionSetItemFields;
import org.apache.commons.csv.CSVRecord;

import java.util.LinkedList;
import java.util.List;

public class MapItemCSVData {
    public static List<QuestionSetItemFields> itemRead() {
        List<QuestionSetItemFields> itemList = new LinkedList<>();
        for (CSVRecord csvRecord : ReadCSVData.recordIterable("./csv/items.csv")) {
            itemList.add(QuestionSetItemFields.builder()
                    .name(csvRecord.get("Name"))
                    .run(csvRecord.get("Run"))
                    .value(csvRecord.get("Value"))
                    .coverOutSide(csvRecord.get("CoverOutside"))
                    .build());
        }
        return itemList;
    }
}
