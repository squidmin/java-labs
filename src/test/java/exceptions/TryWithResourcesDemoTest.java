package exceptions;

import org.junit.Test;

public class TryWithResourcesDemoTest {

    @Test(expected = Exception.class)
    public void classA_close_whenInvoked_throwsException() throws Exception {
        try (TryWithResourcesDemo.ClassA instance = new TryWithResourcesDemo.ClassA()) {}
    }

    @Test(expected = Exception.class)
    public void classA_method_whenInvoked_throwsException() throws Exception {
        try (TryWithResourcesDemo.ClassA instance = new TryWithResourcesDemo.ClassA()) { instance.method(); }
    }

    @Test(expected = Exception.class)
    public void classB_method_whenInvoked_throwsException() throws Exception {
        try (TryWithResourcesDemo.ClassB instance = new TryWithResourcesDemo.ClassB()) { instance.method(); }
    }

}
