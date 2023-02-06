package instances;

public class ClassBasedSingleton {

    private static ClassBasedSingleton INSTANCE;
    private String info = "Initial info class";

    private ClassBasedSingleton() {}  // Private constructor.

    public static ClassBasedSingleton getInstance() {
        if (INSTANCE == null) { INSTANCE = new ClassBasedSingleton(); }
        return INSTANCE;
    }

    // Getters and setters

    public static void main(String[] args) {
        ClassBasedSingleton.INSTANCE = ClassBasedSingleton.getInstance();
        System.out.println(ClassBasedSingleton.INSTANCE);
        /*
         * As long as `getInstance()` is called (rather than the constructor), only one instance is created.
         */
        ClassBasedSingleton.INSTANCE = ClassBasedSingleton.getInstance();  // Prints the same address.
        System.out.println(ClassBasedSingleton.INSTANCE);
    }

}
