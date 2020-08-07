
public class Homestay extends Property {
    private int cost;

    public Homestay(int cost) {
        super(PropertyType.HOMESTAY_ROOM);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost() + cost;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "Homestay ";
    }
}