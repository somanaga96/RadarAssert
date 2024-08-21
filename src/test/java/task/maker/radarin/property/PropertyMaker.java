package task.maker.radarin.property;

import com.example.generated.RadarIn.Property;

import static task.maker.GetCSVDataMaker.getRadarInput;

public class PropertyMaker {
    public static Property makeProperty() {
        Property property = new Property();
        property.setRadarModelId(getRadarInput().get("radarModelId"));
        property.setFirstName(getRadarInput().get("fname"));
        property.setCycle(CycleMaker.makeCycle());
        return property;
    }
}
