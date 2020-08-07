public class MyPair <K,V> {
    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }
    
    /**
     * @return the value
     */
    public V getVal() {
        return value;
    }

    /**
     * @param key the key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @param value the value to set
     */
    public void setVal(V value) {
        this.value = value;
    }

    public boolean isEqual(MyPair pair) {
        if(this.key == pair.key && this.value == pair.value) {
            return true;
        }
        return false;
    }

    public int nearEQ(MyPair other) {
        if(this.isEqual(other)) {
            return 3;
        }
        else {
            if(this.key == other.key) {
                return 1;
            }
            else if(this.value == other.value) {
                return 2;
            }
            else {
                return 0;
            }
        }
    }
}