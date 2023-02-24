package collections.iterator;

import org.junit.Test;

public class HasNextDemoTest {

    @Test
    public void hasNext_upperBound_3() {
        HasNextDemo.run(3);
    }

    @Test
    public void hasNext_upperBound_4() { HasNextDemo.run(4); }

    @Test
    public void hasNext_upperBound_5() {
        HasNextDemo.run(5);
    }

}
