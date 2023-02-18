package exceptions;

import org.junit.Test;

public class TryWithResourcesTest {

    @Test(expected = Exception.class)
    public void classA_close_whenInvoked_throwsException() throws Exception {
        try (TryWithResources.ClassA instance = new TryWithResources.ClassA()) {}
    }

    @Test(expected = Exception.class)
    public void classA_method_whenInvoked_throwsException() throws Exception {
        try (TryWithResources.ClassA instance = new TryWithResources.ClassA()) { instance.method(); }
    }

    @Test(expected = Exception.class)
    public void classB_method_whenInvoked_throwsException() throws Exception {
        try (TryWithResources.ClassB instance = new TryWithResources.ClassB()) { instance.method(); }
    }

}
