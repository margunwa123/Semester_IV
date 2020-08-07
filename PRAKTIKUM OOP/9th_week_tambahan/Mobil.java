class Mobil extends Kendaraan{
    private String supir;

    public Mobil(int no_kendaraan, String merk, int tahun_keluaran, String supir) {
        super(no_kendaraan, "mobil", merk, tahun_keluaran);
        this.supir = supir;
    }
    public Mobil() {
        super();
        this.supir = "XXXX";
    }

    public int BiayaSewa(int lamaSewa) {
        return 500000 * lamaSewa;
    }
    public void PrintInfo() {
        super.PrintInfo();
        System.out.println(" Mobil ini memiliki supir bernama " + this.supir);
    }
}