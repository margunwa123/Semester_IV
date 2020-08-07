public class Car extends Vehicle {
    private int kapasitas;

    public Car(String merk, int kapasitas) {
        super("Car", merk);
        this.kapasitas = kapasitas;
    }
    
    public Car(Car other) {
        super("Car", other.merk);
        this.kapasitas = other.kapasitas;
    }

    public Car clone() {
        return new Car(this);
    }

    /**
     * @param kapasitas the kapasitas to set
     */
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    /**
     * @return the kapasitas
     */
    public int getKapasitas() {
        return kapasitas;
    }

    public static void main(String[] args) {
        Car ford = new Car("Ford", 5);
        Car fordEvolved = ford.clone();
        fordEvolved.setKapasitas(6);
        System.out.println(ford.getKapasitas());
        System.out.println(fordEvolved.getKapasitas());
    }
}