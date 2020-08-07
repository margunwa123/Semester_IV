public abstract class Vehicle {
    protected String merk;
    protected String tipe;

    public Vehicle(String tipe, String merk) {
        this.tipe = tipe;
        this.merk = merk;
    }

    public Vehicle() {
        this("Car","Mustang");
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @return the tipe
     */
    public String getTipe() {
        return tipe;
    }

    public abstract Vehicle clone();
    
    public void drive() {
        System.out.println("driving in " + tipe + " of " + merk);
    }
} 