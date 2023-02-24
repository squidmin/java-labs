package instances;

import org.junit.Test;

public class EnumSingletonDemoTest {

    @Test
    public void test() {
        EnumSingletonDemo instance = EnumSingletonDemo.INSTANCE.getInstance();
        System.out.println(instance.hashCode());
        /*
         * This approach has serialization and thread-safety guaranteed by the enum implementation itself, which
         *   ensures internally that only the single instance is available, correcting the thread-safety problems with
         *   the class-based Singleton implementation.
         */
        instance = EnumSingletonDemo.INSTANCE.getInstance();
        System.out.println(instance.hashCode());  // Prints the same hash code.
    }

}
