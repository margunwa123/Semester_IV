import java.util.ArrayList;
import java.util.List;

public class UnitApartment extends Property {
    private int numOfRooms;
    private int cost;

    public UnitApartment() {
        super(PropertyType.APARTMENT);
        numOfRooms = 0;
    }

    public UnitApartment(int numOfRooms, int cost) {
        super(PropertyType.APARTMENT);
        this.cost = cost;
        this.numOfRooms = numOfRooms;
    }

    @Override
    public int getCost() {
        return super.getCost() + cost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Apartment with " + Integer.toString(numOfRooms) + " rooms";
    }
}