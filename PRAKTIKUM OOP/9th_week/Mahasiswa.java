import java.lang.Comparable;

class Mahasiswa implements Comparable<Mahasiswa> {
  private float ipk;
  private int kodeJurusan;
  private int angkatan;

  public Mahasiswa(float ipk) {
    this.ipk = ipk;
  }
  public Mahasiswa(int kodeJurusan, int angkatan, float ipk) {
    this.ipk = ipk;
    this.angkatan = angkatan;
    this.kodeJurusan = kodeJurusan;
  }

  public float getIpk() {
      return this.ipk;
  }
  public int getAngkatan() {
      return this.angkatan;
  }
  public int getKodeJurusan() {
      return this.kodeJurusan;
  }

  public int compareTo(Mahasiswa m) {
    // compareTo mengembalikan:
    // 0 bila this sama dengan m
    // 1 bila this lebih dari m
    // -1 bila this kurang dari m
    if(this.kodeJurusan < m.getKodeJurusan()) {
        return -1;
    }
    else if(this.kodeJurusan == m.getKodeJurusan()) {
        if(this.angkatan > m.getAngkatan()) {
            return -1;
        }
        else if(this.angkatan == m.getAngkatan()) {
            if(this.ipk > m.ipk) {
                return -1;
            }
            else if(this.ipk == m.ipk) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
    else {
        return 1;
    }
  }
}