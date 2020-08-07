public class Buyer extends Account {

    private int saldo;

    public Buyer(String username, Position address, int saldo) {
        super(username, address);
        this.saldo = saldo;
    }

    public void substractSaldo(int quantity) throws NotEnoughMoneyException {
        if(this.saldo < quantity) {
            throw new NotEnoughMoneyException(String.format("membutuhkan uang %d sedangkan saldo hanya %d", quantity, this.saldo));
        }
        this.saldo -= quantity;
    }
}