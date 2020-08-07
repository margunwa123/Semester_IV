public class RekeningGiro extends Rekening {
    private boolean penalti;

    public RekeningGiro(String nama, double saldo) {
        super(nama, saldo, 0.07);
        this.penalti = saldo < 500 ? true : false;
    }

    public void setor(double value) {
        this.saldo += value - 0.1;
        if(this.saldo < 500) {
            this.penalti = true;
        }
    }

    public void tarik(double value) {
        if(this.saldo >= value) {
            this.saldo -= (value + 0.1);
            if(this.saldo < 500) {
                this.penalti = true;
            }
        }
    }

    public void update() {
        this.saldo += (this.saldo * this.sukuBunga - (this.penalti ? 10 : 0) - super.hitungBiaya()); 
        this.penalti = this.saldo < 500 ? true : false;
        if(this.saldo < 0) {
            this.saldo = 0;
        }
    }

}