package pair;

public class Pair<K, V>{

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(1, "One");
        Pair<String, String> pair2 = new Pair<String, String>("ksbdfkds", "One");
        System.out.println(pair);
        System.out.println(pair2.toString());
    }

    @SuppressWarnings("rawtypes")
    public boolean equals(Object pairObject) {
        if (this.key == ((Pair) pairObject).key
                && this.value == ((Pair) pairObject).value) {
            return true;
        }
        return false;
    }


    public String toString(){
        return "Key: " + this.key + " Value: " + this.value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
	
}
