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
        Singleton.INSTANCE = Singleton.getInstance();  // As long as `getInstance()` is called, only one instance is created.
        System.out.println(Singleton.INSTANCE);
    }

}
