public class Iphone {
    private String series;

    public Iphone(String series) {
        this.series = series;
    }
    
    public void chargeWithLightning() {
        System.out.println(getDesc() + " Charging with lightning");
    }

    public String getDesc() {
        return ("Iphone series " + this.series);
    }
}