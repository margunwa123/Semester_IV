public class RekeningDeposito extends Rekening {
    private int bulan;

    public RekeningDeposito(String nama, double saldo) {
        super(nama, saldo, 0.15);
        this.bulan = 0;
    }

    public void setor(double value) {
        System.out.println("Tidak dapat melakukan penyetoran uang untuk rekening ini.");
    }

    public void tarik(double value) {
        System.out.println("Tidak dapat melakukan penarikan uang sebagian untuk rekening ini.");
    }

    public void update() {
        this.bulan++;
        if(this.bulan % 12 == 0) {
            this.saldo += this.saldo * this.sukuBunga - super.hitungBiaya();
        }
        else {
            this.saldo -= super.hitungBiaya();
        }
    }

    public void tarik() {
        if(this.bulan < 12) {
            double penalti = 0.2 * this.saldo;
            System.out.println("Anda terkena penalti sebesar " + penalti + ".");
        }
        this.saldo = 0;
    }
}