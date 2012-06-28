package guava;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import guava.functions.AdultFamilyPredicate;
import guava.functions.FamilyPredicate;
import guava.functions.ToPersonTransformer;
import guava.functions.YouthPredicate;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.filterEntries;
import static com.google.common.collect.Maps.newHashMap;
import static java.lang.Integer.valueOf;
import static junit.framework.Assert.*;

public class MapsProvides {

    private HashMap<String, Integer> map;
    private HashMap<String, Integer> left;
    private HashMap<String, Integer> right;
    private MapDifference<String, Integer> difference;
    private Map<String, Integer> filtered;
    private Map<String, ToPersonTransformer.Person> people;

    @Before
    public void setUp() throws Exception {
        map = newHashMap();
        left = newHashMap();
        right = newHashMap();
    }

    @Test
    public void factoryMethod() {
        assertNotNull(newHashMap());
    }

    @Test
    public void difference() {
        left.put("John Doe", 25);
        right.put("John Doe", 20);

        difference = Maps.difference(left, right);

        assertFalse(difference.areEqual());
        assertEquals(valueOf(25), difference.entriesDiffering().get("John Doe").leftValue());
        assertEquals(valueOf(20), difference.entriesDiffering().get("John Doe").rightValue());
    }

    @Test
    public void filters() {
        map.put("John Doe", 25);
        map.put("Esther Doe", 24);
        map.put("Timmy Doe", 8);
        map.put("Jane Smith", 16);

        filtered = Maps.filterEntries(map, new AdultFamilyPredicate());

        assertTrue(filtered.containsKey("John Doe"));
        assertTrue(filtered.containsKey("Esther Doe"));
        assertFalse(filtered.containsKey("Timmy Doe"));
        assertFalse(filtered.containsKey("Jane Smith"));

        filtered = Maps.filterKeys(map, new FamilyPredicate());

        assertTrue(filtered.containsKey("John Doe"));
        assertTrue(filtered.containsKey("Esther Doe"));
        assertTrue(filtered.containsKey("Timmy Doe"));
        assertFalse(filtered.containsKey("Jane Smith"));

        filtered = Maps.filterValues(map, new YouthPredicate());

        assertTrue(filtered.containsKey("Timmy Doe"));
        assertTrue(filtered.containsKey("Jane Smith"));
        assertFalse(filtered.containsKey("John Doe"));
        assertFalse(filtered.containsKey("Esther Doe"));
    }

    @Test
    public void transformations() {
        map.put("John Doe", 25);

        people = Maps.transformEntries(map, new ToPersonTransformer());

        assertEquals("John Doe", people.get("John Doe").name);
        assertEquals(25, people.get("John Doe").age);
    }

    @Test
    public void lazyOperations() {
        map.put("John Doe", 25);
        people = Maps.transformEntries(map, new ToPersonTransformer());

        assertEquals("John Doe", people.get("John Doe").name);

        map.put("Jane Smith", 16);
        assertEquals("Jane Smith", people.get("Jane Smith").name);
    }
}
