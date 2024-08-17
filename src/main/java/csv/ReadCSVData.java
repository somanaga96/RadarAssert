package csv;

import exception.CSVLoadException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadCSVData {
    public static Iterable<CSVRecord> recordIterable(String filePath) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        try {
            return CSVFormat.DEFAULT.withFirstRecordAsHeader().withAllowMissingColumnNames(true).parse(new InputStreamReader(inputStream));
        } catch (IOException e) {
            throw new CSVLoadException(e);
        }
    }
}
