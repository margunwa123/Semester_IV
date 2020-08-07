// Di bawah ini, kelas NegativeExpression menginherit Expression
// Namun, sekarang Expression merupakan interface, bukan kelas.
class NegativeExpression implements Expression {
    // Di Java, tidak ada konsep pointer. Polymorphism dapat dilakukan
    // pada reference, bukan pointer.
    protected Expression x;

    public NegativeExpression(Expression x) {
        this.x = x;
    }

    public int solve() {
        return -1 * this.x.solve();
    }
};