package instances;

public class ClassBasedSingleton {

    private static ClassBasedSingleton INSTANCE;
    private String info = "Ok I pull up. (Initial class info)";

    private ClassBasedSingleton() {}  // Private constructor.

    public synchronized static ClassBasedSingleton getInstance() {
        if (INSTANCE == null) { INSTANCE = new ClassBasedSingleton(); }
        return INSTANCE;
    }

    // Getters and setters

    public static void main(String[] args) {
        ClassBasedSingleton.INSTANCE = ClassBasedSingleton.getInstance();
        System.out.println(ClassBasedSingleton.INSTANCE);
        /*
         * As long as `getInstance()` is called (rather than the constructor), only one instance is created.
         * This approach to creating a Singleton doesn't guarantee thread safety, unless the `synchronized` keyword is
         *   used to guarantee the atomicity of the operation.
         */
        ClassBasedSingleton instance = ClassBasedSingleton.getInstance();  // Prints the same address.
        System.out.println(instance);
    }

}
