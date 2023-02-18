package collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUpgradesDemoTest {

    @Test
    public void getOrDefault_resultsAreEqual() {
        Map<String, Integer> with = MapUpgradesDemo.withoutGetOrDefault();
        Map<String, Integer> without = MapUpgradesDemo.withGetOrDefault();
        Assert.assertEquals(with, without);
    }

    @Test
    public void putIfAbsent_returnExpectedResult() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 20);
        Map<String, Integer> actual = MapUpgradesDemo.putIfAbsent();
        Assert.assertEquals(expected, actual);
    }

}
