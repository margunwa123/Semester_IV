
public class SummonedMonster implements ISummoned{
  private Monster monster;
  private boolean isOpen;
  private boolean onAttackPosition;

  public SummonedMonster(Monster monster, boolean isOpen, boolean onAttackPosition) {
    this.monster = monster;
    this.isOpen  = isOpen;
    this.onAttackPosition = onAttackPosition;
  }
  public boolean flip() {
    if(!isOpen) {
      isOpen = true;
      return true;
    }
    else {
      return false;
    }
  }

  // mengubah posisi karakter dari menyerang jadi bertahan, atau sebaliknya
  public void rotate() {
    this.onAttackPosition = !this.onAttackPosition;
  }

  // bila dalam posisi menyerang, mengembalikan attack.
  // bila dalam posisi bertahan, mengembalikan defense
  public int getPositionValue() {
    if(onAttackPosition) {
      return monster.getAttackValue();
    }
    else {
      return monster.getDefenseValue();
    }
  }

  // menggambar kartu ke layar
  public void render() {
    String posisi = this.onAttackPosition ? "menyerang" : "bertahan";
    String keadaan = this.isOpen ? "terbuka" : "tertutup";
    System.out.println(String.format("Monster %s dalam keadaan %s dengan posisi %s", monster.getName(), keadaan, posisi));
  }

}