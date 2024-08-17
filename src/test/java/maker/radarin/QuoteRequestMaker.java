package maker.radarin;

import com.example.generated.RadarIn.Quote;
import maker.GetCSVDataMaker;
import utils.DateParser;

public class QuoteRequestMaker extends GetCSVDataMaker {
    public static Quote makeQuote() {
        Quote quote = new Quote();
        quote.setDob(getRadarInput().get("dob"));
        quote.setAge(DateParser.getAge(getRadarInput().get("dob")));
        quote.setData(DataMaker.setData());
        quote.setSupport(SupportMaker.addSupport());
        return quote;
    }
}
