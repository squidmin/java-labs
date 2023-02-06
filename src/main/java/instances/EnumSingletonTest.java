package instances;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE.getInstance();
        System.out.println(instance.hashCode());
        /*
         * This approach has serialization and thread-safety guaranteed by the enum implementation itself, which
         *   ensures internally that only the single instance is available, correcting the thread-safety problems with
         *   the class-based Singleton implementation.
         */
        instance = EnumSingleton.INSTANCE.getInstance();
        System.out.println(instance.hashCode());  // Prints the same hash code.
    }
}
