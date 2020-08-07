import java.util.ArrayList;
import java.util.List;

public abstract class Property {
    protected PropertyType propertyType;
    protected List<Facility> facilities;
    protected boolean availability;

    public Property(PropertyType propertyType) {
        this.availability = true;
        this.propertyType = propertyType;
        this.facilities = new ArrayList<>();
    }

    public int getCost() {
        int sumOfCost = 0;
        for(Facility facility : facilities) {
            sumOfCost += facility.getCost();
        }
        return sumOfCost;
    }

    public String getDescription() {
        return ("Property ");
    }
    
    public void addFacility(Facility facility) {
        this.facilities.add(facility);
    }

    /**
     * @return the facilities
     */
    public List<Facility> getFacilities() {
        return facilities;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return availability;
    }
}