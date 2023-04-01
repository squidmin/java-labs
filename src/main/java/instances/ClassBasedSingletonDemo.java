package instances;

public class ClassBasedSingletonDemo {

    private static ClassBasedSingletonDemo INSTANCE;

    private ClassBasedSingletonDemo() {}  // Private constructor.

    public synchronized static ClassBasedSingletonDemo getInstance() {
        if (INSTANCE == null) { INSTANCE = new ClassBasedSingletonDemo(); }
        return INSTANCE;
    }

    // Getters and setters

    public static void main(String[] args) {
        ClassBasedSingletonDemo.INSTANCE = ClassBasedSingletonDemo.getInstance();
        System.out.println(ClassBasedSingletonDemo.INSTANCE);
        /*
         * As long as `getInstance()` is called (rather than the constructor), only one instance is created.
         * This approach to creating a Singleton doesn't guarantee thread safety, unless the `synchronized` keyword is
         *   used to guarantee the atomicity of the operation.
         */
        ClassBasedSingletonDemo instance = ClassBasedSingletonDemo.getInstance();
        System.out.println(instance);  // Prints the same address.
    }

}
