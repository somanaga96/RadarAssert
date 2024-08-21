package task.maker.radarin.property;

import com.example.generated.RadarIn.Cycle;
import csv.mapcsvdata.MapCycleCSVData;
import model.QuestionSetCycleFields;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CycleMaker {
    public static List<Cycle> makeCycle() {
        List<Cycle> cycleList = new ArrayList<>();
        List<QuestionSetCycleFields> cycles = cycleRead();
        for (QuestionSetCycleFields cycleFields : cycles) {
            Cycle cycle = new Cycle();
//            cycle.setCycleId("1234");
            cycle.setName(cycleFields.getName());
            cycle.setValue(cycleFields.getValue());
            cycle.setCoverOutside(cycleFields.getCoverOutSide());
            cycleList.add(cycle);
        }
        return cycleList;
    }

    public static List<QuestionSetCycleFields> cycleRead() {
        List<QuestionSetCycleFields> cycleList = MapCycleCSVData.cycleRead().stream()
                .filter(s -> s.getRun().equalsIgnoreCase("Yes")).collect(Collectors.toList());
        return cycleList;
    }
}
