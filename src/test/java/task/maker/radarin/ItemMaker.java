package task.maker.radarin;

import com.example.generated.RadarIn.Item;
import csv.mapcsvdata.MapItemCSVData;
import model.QuestionSetItemFields;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMaker {
    public static List<Item> makeItemList() {
        List<Item> itemList = new ArrayList<>();
        List<QuestionSetItemFields> items = itemRead();
        for (QuestionSetItemFields fields : items) {
            Item item = new Item();
//            item.setItemId("1234");
            item.setName(fields.getName());
            item.setCoverOutside(fields.getCoverOutSide());
            item.setValue(fields.getValue());
            itemList.add(item);
        }
        return itemList;
    }

    public static List<QuestionSetItemFields> itemRead() {
        List<QuestionSetItemFields> itm = MapItemCSVData.itemRead()
                .stream().filter(s -> s.getRun().equalsIgnoreCase("Yes"))
                .collect(Collectors.toList());
        return itm;
    }
}
