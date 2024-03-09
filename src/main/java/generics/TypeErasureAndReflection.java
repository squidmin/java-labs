package generics;

class Printer<T> {
    public void print(T item) {
        System.out.println("Type of item: " + item.getClass().getSimpleName());
    }
}

public class TypeErasureAndReflection {

    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>();
        printer.print(10);

        Printer<String> printer2 = new Printer<>();
        printer2.print("Hello");
    }

}
