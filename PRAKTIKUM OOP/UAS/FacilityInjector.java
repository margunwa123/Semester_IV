import java.util.List;

public class FacilityInjector {
    private List<Facility> facilities;
    
    public void inject(Property property, String facilityName, int cost) {
        property.addFacility(new Facility(facilityName, cost));
    }
}