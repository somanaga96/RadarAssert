package maker.expectedmaker;

import com.google.gson.Gson;
import csv.CSVMapper;
import model.QuestionSetPropertyFields;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RadarInCoreXML {
    public static void frameXML(String json) {
        // Retrieve QuestionSetPropertyFields instance
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();

        // Initialize Gson instance
        Gson gson = new Gson();

        // Convert the provided JSON string to JSON format (assuming json is already a JSON string)
        String json1 = gson.toJson(json); // Use this if json is already the desired JSON string

        // Construct the directory and file paths
        Path directoryPath = Paths.get("./expected");
        Path filePath = directoryPath.resolve(fields.getScenarioId() + ".json");

        try {
            // Ensure the directory exists
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
                System.out.println("Directory created: " + directoryPath.toAbsolutePath());
            }

            // Write the JSON string to the file
            Files.write(filePath, json1.getBytes(StandardCharsets.UTF_8));
            System.out.println("File written successfully to: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            // Print stack trace for debugging
            e.printStackTrace();
            throw new RuntimeException("Error writing JSON to file", e);
        }
    }
}
