package utils;

import csv.CSVMapper;
import model.QuestionSetPropertyFields;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateExpectedFile {
    public static void frameExpected(String xml) {
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();
        Path path = Paths.get("src/test/resources/expected/" + fields.getScenarioId() + "Expected.xml");
        try {
            Files.write(path, xml.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
