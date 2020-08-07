public class MicroAdapter extends Samsung {
    private Iphone iphone;

    public MicroAdapter(Iphone iphone) {
        super("");
        this.iphone = iphone;
    }

    @Override
    public String getDesc() {
        return iphone.getDesc();
    }


    public static void main(String[] args) {
        MicroAdapter microAdapter = new MicroAdapter(new Iphone("1.1"));
        microAdapter.chargeWithMicro();
    }
}