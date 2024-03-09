package generics;

interface Comparator<T> {
    int compare(T o1, T o2);
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

public class GenericInterfaces {

    public static void main(String[] args) {
        StringLengthComparator comparator = new StringLengthComparator();
        System.out.println("Comparison: " + comparator.compare("apple", "banana"));
    }

}
