package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static String dateFormat = "DD/mm/yyyy";

    public static int getAge(String dob) {
        System.out.println("dob :"+dob);
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate parse = LocalDate.parse(dob, dateTimeFormatter);
        Period period = Period.between(parse, todayDate);
        return period.getYears();
    }
}
