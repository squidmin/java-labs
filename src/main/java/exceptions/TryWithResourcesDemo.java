package exceptions;

public class TryWithResourcesDemo {

    static class ClassA implements AutoCloseable {
        public ClassA() {
            System.out.println("ClassA constructor called.");
        }

        public void method() throws Exception { throw new Exception("ClassA method called."); }

        @Override
        public void close() throws Exception {
            System.out.println("ClassA close() method called.");
            throw new Exception("Unable to complete close() invocation!");
        }
    }

    static class ClassB implements AutoCloseable {
        public ClassB() { System.out.println("ClassB constructor called."); }

        public void method() throws Exception { throw new Exception("ClassB method called."); }

        @Override
        public void close() { System.out.println("ClassB close() method called."); }
    }

    public static void main(String[] args) {
        try (ClassA classA = new ClassA(); ClassB classB = new ClassB()) {
            classA.method();
            classB.method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Executing `finally` block.");
        }
    }

}
