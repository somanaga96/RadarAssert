package pc;

import csv.CSVMapper;
import model.QuestionSetPropertyFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiPlay {
    public static void ui() {
        QuestionSetPropertyFields fields = CSVMapper.getQuestionSetPropertyFields();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.cssSelector("input#firstName")).sendKeys(fields.getFName());
        driver.findElement(By.cssSelector("input#lastName")).sendKeys(fields.getLName());
    }
}
