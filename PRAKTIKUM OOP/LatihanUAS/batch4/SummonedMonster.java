public class SummonedMonster implements ISummoned {
    private Monster monster;
    private boolean isOpened;
    private boolean isAttacking;

    public SummonedMonster(Monster monster, boolean isOpened, boolean isAttacking) {
        this.monster = monster;
        this.isOpened = isOpened;
        this.isAttacking = isAttacking;
    }

    // mengubah keadaan kartu dari tertutup jadi terbuka dan mengembalikan true
    // bila kartu sudah terbuka, tidak lakukan apa-apa dan kembalikan false
    public boolean flip() {
        if(this.isOpened) {
            return false;
        }
        else {
            this.isOpened = true;
            return true;
        }
    }

    // mengubah posisi karakter dari menyerang jadi bertahan, atau sebaliknya
    public void rotate() {
        this.isAttacking = !this.isAttacking;
    }

    // bila dalam posisi menyerang, mengembalikan attack.
    // bila dalam posisi bertahan, mengembalikan defense
    public int getPositionValue() {
        if(isAttacking) {
            return this.monster.getAttackValue();
        }
        else {
            return this.monster.getDefenseValue();
        }
    } 

    // menggambar kartu ke layar
    public void render() {
        System.out.println(String.format("Monster %s dalam keadaan %s dengan posisi %s", this.monster.getName(), this.isOpened ? "terbuka" : "tertutup", this.isAttacking ? "menyerang" : "bertahan"));
    }
}