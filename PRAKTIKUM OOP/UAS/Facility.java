
public class Facility {
    private int cost;
    private String name;

    public Facility(String name, int cost) {
        this.cost = cost;
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }
}