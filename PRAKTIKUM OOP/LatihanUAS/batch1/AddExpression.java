// Di bawah ini, kelas AddExpression menginherit Expression
// Namun, sekarang Expression merupakan interface, bukan kelas.
class AddExpression implements Expression {
  // Di Java, tidak ada konsep pointer. Polymorphism dapat dilakukan
  // pada reference, bukan pointer.
    protected Expression x;
    protected Expression y;

    public AddExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    public int solve() {
        return this.x.solve() + this.y.solve();
    }
};