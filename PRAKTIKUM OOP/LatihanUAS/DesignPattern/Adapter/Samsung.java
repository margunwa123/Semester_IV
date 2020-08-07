public class Samsung {
    private String tipe;
    
    public Samsung(String tipe) {
        this.tipe = tipe;
    }

    public void chargeWithMicro() {
        System.out.println(getDesc() + " charging with micro");
    }

    public String getDesc() {
        return ("Samsung tipe " + tipe);
    }
}