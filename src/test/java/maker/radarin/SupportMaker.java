package maker.radarin;


import com.example.generated.RadarIn.Support;
import maker.GetCSVDataMaker;

public class SupportMaker extends GetCSVDataMaker {
    public static Support addSupport() {
        Support support = new Support();
        support.setText(getUserResponse().getSupport().getText());
        support.setUrl(getUserResponse().getSupport().getUrl());
        return support;
    }
}
