package task.maker.radarin;

import com.example.generated.RadarIn.Quote;
import task.maker.GetCSVDataMaker;
import task.maker.radarin.property.PropertyMaker;
import utils.DateParser;

public class QuoteRequestMaker extends GetCSVDataMaker {
    public static Quote makeQuote() {
        Quote quote = new Quote();
        quote.setDob(getRadarInput().get("dob"));
        quote.setAge(DateParser.getAge(getRadarInput().get("dob")));
        quote.setData(DataMaker.setData());
        quote.setSupport(SupportMaker.addSupport());
        quote.setItem(ItemMaker.makeItemList());
        quote.setProperty(PropertyMaker.makeProperty());
        return quote;
    }
}
