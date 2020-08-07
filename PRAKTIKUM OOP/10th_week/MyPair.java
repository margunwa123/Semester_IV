class MyPair<K,V> {
  private K key;
  private V value;

  public MyPair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return this.key;
  }
  public V getVal() {
    return this.value;
  }

  public void setKey(K key) {
    this.key = key;
  }
  public void setVal(V value) {
    this.value = value;
  }

  public boolean isEqual (MyPair pair) {
    return(this.key.equals(pair.key) && this.value.equals(pair.value));
  }

  public int nearEQ(MyPair pair) {
    int nilaiEQ = 0;
    if(this.key == pair.key) {
      nilaiEQ++;
    }
    if(this.value == pair.value) {
      nilaiEQ += 2;
    }
    return nilaiEQ;
  }
}