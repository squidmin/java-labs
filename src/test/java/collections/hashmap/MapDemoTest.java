package collections.hashmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapDemoTest {

    @Test
    public void getOrDefault_resultsAreEqual() {
        Map<String, Integer> with = MapDemo.withoutGetOrDefault();
        Map<String, Integer> without = MapDemo.withGetOrDefault();
        Assert.assertEquals(with, without);
    }

    @Test
    public void putIfAbsent_returnExpectedResult() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("perfume", 20);
        Map<String, Integer> actual = MapDemo.putIfAbsent();
        Assert.assertEquals(expected, actual);
    }

}
