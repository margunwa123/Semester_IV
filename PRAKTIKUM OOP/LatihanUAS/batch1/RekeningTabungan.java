public class RekeningTabungan extends Rekening {
    public RekeningTabungan(String nama, double saldo) {
        super(nama, saldo, 0.05);
    }

    public void setor(double value) {
        this.saldo += value;
    }

    public void tarik(double value) {
        if(this.saldo >= value) {
            this.saldo -= value;
        }
    }

    public void update() {
        this.saldo += (this.saldo * this.sukuBunga - this.hitungBiaya());
    }
}