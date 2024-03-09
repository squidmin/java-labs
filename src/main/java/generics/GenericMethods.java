package generics;

public class GenericMethods {

    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Integer Array: ");
        printArray(intArray);

        String[] stringArray = {"apple", "banana", "orange"};
        System.out.print("String Array: ");
        printArray(stringArray);
    }

}
