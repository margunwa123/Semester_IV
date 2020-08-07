class Minibus extends Kendaraan {
    public Minibus(int no_kendaraan, String merk, int tahun_keluaran) {
        super(no_kendaraan, "minibus", merk, tahun_keluaran);
    }
    public Minibus() {
        this(0, "XXX", 0);
    }

    public int BiayaSewa(int lamaSewa) {
        return 5000000 + (lamaSewa > 5 ? (lamaSewa-5) * 500000 : 0);
    }
    public double CalculateDiscount(int lamaSewa) {
        return lamaSewa > 10 ? 0.1 * BiayaSewa(lamaSewa) : 0;
    }

    public void PrintInfo() {
        super.PrintInfo();
        System.out.println("");
    }
}