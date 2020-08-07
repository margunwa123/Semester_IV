class Bus extends Kendaraan{
    private int kapasitas;

    public Bus(int no_kendaraan, String merk, int tahun_keluaran, int kapasitas) {
        super(no_kendaraan, "bus", merk, tahun_keluaran);
        this.kapasitas = kapasitas;
    }
    public Bus() {
        this(0, "XXX", 0, 0);
    }
    public int BiayaSewa(int lamaSewa) {
        return 1000000 * lamaSewa;
    }

    public void PrintInfo() {
        super.PrintInfo();
        System.out.println(" dengan kapasitas " + this.kapasitas);
    }
}