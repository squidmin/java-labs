package generics;

public class GenericMethodDemo {

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) { System.out.println(list[i] + " "); }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integers = { 1, 2, 3, 4, 5 };
        String[] strings = { "Ok", "I", "pull", "up" };

        GenericMethodDemo.<Integer>print(integers);
        GenericMethodDemo.<String>print(strings);
    }

}
