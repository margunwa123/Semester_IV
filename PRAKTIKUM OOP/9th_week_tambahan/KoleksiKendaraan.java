public class KoleksiKendaraan {
    private Kendaraan[] array_kendaraan;
    private int neff;

    public KoleksiKendaraan(int size) {
        try{
            this.neff = 0;
            this.array_kendaraan = new Kendaraan[size];
        }
        catch(NegativeArraySizeException e) {
            System.out.println("Size tidak bisa negative, Koleksi kendaraan diinisiasi dengan max_size 100");
            this.array_kendaraan = new Kendaraan[100];
        }
    }
    public KoleksiKendaraan() {
        this(100);
    }

    public void PrintAll() {
        for (int i = 0 ; i < this.neff ; i++) {
            this.array_kendaraan[i].PrintInfo();
        }
    }
    public void add(Kendaraan kendaraan) {
        try {
            this.array_kendaraan[this.neff] = kendaraan;
            this.neff++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Anda tidak bisa menambahkan kendaraan ke koleksi karena koleksi sudah penuh");
        }
        
    }
    public void add(KoleksiKendaraan koleksiKendaraan) {
        for (int i = 0 ; i < koleksiKendaraan.neff ; i++) {
            this.add(koleksiKendaraan.array_kendaraan[i]);
        }
    }

    public static void main(String[] args) {
        Minibus minibus = new Minibus();
        Mobil mobil = new Mobil(15, "suzuki", 2000, "jeffri");
        Bus bus = new Bus(12, "Toyota", 1992, 48);

        KoleksiKendaraan KK = new KoleksiKendaraan();
        KoleksiKendaraan KK2 = new KoleksiKendaraan(3);
        KK2.add(new Mobil());
        KK2.add(new Minibus(20222, "daihatsu", 3000));
        KK2.add(minibus);
        KK2.add(mobil);
        KK.add(minibus);
        KK.add(mobil);
        KK.add(bus);
        KK.add(KK2);
        KK.PrintAll();
    }
}