abstract class Kendaraan{
    protected int no_kendaraan;
    protected String kategori;
    protected String merk;
    protected int tahun_keluaran;

    public Kendaraan(int no_kendaraan, String kategori, String merk, int tahun_keluaran) {
        this.no_kendaraan = no_kendaraan;
        this.kategori = kategori;
        this.merk = merk;
        this.tahun_keluaran = tahun_keluaran;
    }
    public Kendaraan() {
        this(0, "mobil", "XXX", 0);
    }
    public Kendaraan(Kendaraan other) {
        this.no_kendaraan = other.no_kendaraan;
        this.kategori = other.kategori;
        this.merk = other.merk;
        this.tahun_keluaran = other.tahun_keluaran;
    }

    public void PrintInfo() {
        System.out.print("Kendaraan " + this.kategori +" dengan nomor " + this.no_kendaraan + " ini dibuat tahun " + this.tahun_keluaran + " dan bermerk " + this.merk);
    }

    public abstract int BiayaSewa(int lamaSewa);
}
