package generics;

class Tuple<K extends Comparable<K>, V extends java.io.Serializable> {
    private K key;
    private V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericsWithMultipleBounds {

    public static void main(String[] args) {
        Tuple<Integer, String> tuple = new Tuple<>(1, "Hello");
        System.out.println("Key: " + tuple.getKey());
        System.out.println("Value: " + tuple.getValue());
    }

}
