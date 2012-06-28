package guava;

import com.google.common.collect.Iterables;
import guava.functions.DivisibleByTwoPredicate;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;
import static junit.framework.Assert.*;

public class IterablesProvides {

    private Iterator<Integer> cycle;

    @Test
    public void allElementsMatchPredicate() {
        assertTrue(all(newArrayList(2, 4), new DivisibleByTwoPredicate()));
        assertFalse(all(newArrayList(1, 2, 3, 4), new DivisibleByTwoPredicate()));
    }

    @Test
    public void anyElementMatchesPredicate() {
        assertTrue(any(newArrayList(1, 2, 3), new DivisibleByTwoPredicate()));
        assertFalse(any(newArrayList(1, 3), new DivisibleByTwoPredicate()));
    }

    @Test
    public void concatenation() {
        assertEquals(newArrayList(1, 2, 3), newArrayList(concat(newArrayList(1, 2), newArrayList(3))));
    }

    @Test
    public void contains() {
        assertTrue(Iterables.contains(newArrayList(1), 1));
        assertFalse(Iterables.contains(newArrayList(1), 2));
    }

    @Test
    public void cycle() {
        cycle = Iterables.cycle(newArrayList(1, 2)).iterator();
        assertEquals(valueOf(1), cycle.next());
        assertEquals(valueOf(2), cycle.next());
        assertEquals(valueOf(1), cycle.next());
    }

    @Test
    public void filtering() {
        assertEquals(newArrayList(2, 4), newArrayList(filter(newArrayList(1, 2, 3, 4), new DivisibleByTwoPredicate())));
    }

    @Test
    public void elementFrequency() {
        assertEquals(3, frequency(newArrayList(1, 1, 1), 1));
    }

    @Test
    public void isEmptyOnIterables() {
        assertTrue(isEmpty(newArrayList()));
        assertFalse(isEmpty(newArrayList(1)));
    }

    @Test
    public void iteratesUpToCertainLimitFromSource() {
        assertEquals(newArrayList(1, 2), newArrayList(limit(newArrayList(1, 2, 3), 2)));
    }
    
    @Ignore
    @Test public void test() {
//        Iterables.mergeSorted(newArrayList(newArrayList(5, 4), newArrayList(3, 2, 1)));
    }
}
