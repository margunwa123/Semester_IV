import java.util.List;

class Test {
  private List<Integer> list;
  private int n;
  
  public Test(List<Integer> list, int n) {
    this.list = list;
    this.n = n;
  }

  public void reset() {
    this.list.clear();
    for(int i = 0 ; i < n ; i++) {
      this.list.add(0);
    }
  }

  public long get(int idx) {
    this.reset();
    long now = Util.getTime();
    this.list.get(idx);
    long finish = Util.getTime();
    return(finish - now);
  }

  public long del(int idx, int t) {
    this.reset();
    long now = Util.getTime();
    for(int i = 0 ; i < t ; i++) {
      this.list.remove(idx);
    }
    long finish = Util.getTime();
    return(finish - now);
  }
}