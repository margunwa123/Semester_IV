import java.util.List;

public class Test {
    private List<Integer> list;
    private int n;

    public Test(List<Integer> list, int n) {
        this.list = list;
        this.n = n;
    }
    
    public void reset() {
        list.clear();
        for(int i = 0 ; i < n ; i++) {
            list.add(0);
        }
    }

    public long get(int idx) {
        this.reset();
        long start = Util.getTime();
        this.list.get(idx);
        long finish = Util.getTime();
        return finish - start;
    }

    public long del(int idx, int t) {
        this.reset();
        long start = Util.getTime();
        for(int i = 0 ; i < t ; i++) {
            list.remove(idx);
        }
        long finish = Util.getTime();
        return finish - start;
    }
}