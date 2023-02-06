package instances;

public class Singleton {

    private static Singleton INSTANCE;
    private String info = "Initial info class";

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) { INSTANCE = new Singleton(); }
        return INSTANCE;
    }

    // Getters and setters

    public static void main(String[] args) {
        Singleton.INSTANCE = Singleton.getInstance();
        System.out.println(Singleton.INSTANCE);
        /*
         * As long as `getInstance()` is called (rather than the constructor), only one instance is created.
         */
        Singleton.INSTANCE = Singleton.getInstance();  // Prints the same address.
        System.out.println(Singleton.INSTANCE);
    }

}
