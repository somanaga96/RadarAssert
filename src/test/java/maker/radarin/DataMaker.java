package maker.radarin;

import com.example.generated.RadarIn.Data;
import maker.GetCSVDataMaker;

public class DataMaker extends GetCSVDataMaker {
    public static Data setData() {
        Data data = new Data();
        data.setId(getUserResponse().getData().getId());
        data.setEmail(getUserResponse().getData().getEmail());
        data.setFirstName(getUserResponse().getData().getFirstName());
        data.setLastName(getUserResponse().getData().getLastName());
        data.setAvatar(getUserResponse().getData().getAvatar());
        return data;
    }
}
