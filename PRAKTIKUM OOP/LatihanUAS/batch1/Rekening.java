public abstract class Rekening {
    protected String nama;
    protected double saldo;
    protected double sukuBunga;

    public Rekening(String nama, double saldo, double sukuBunga) {
        this.nama = nama;
        this.saldo = saldo;
        this.sukuBunga = saldo < 0 ? 0 : sukuBunga;
    }

    public abstract void setor(double value);
    
    public abstract void tarik(double value);

    public abstract void update();

    public double hitungBiaya() {
        return Math.min(0.1 * this.saldo, 10);
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSukuBunga() {
        return sukuBunga;
    }
}