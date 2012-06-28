package guava;

import com.google.common.collect.Sets;
import guava.functions.DivisibleByTwoPredicate;
import org.junit.Test;

import java.util.HashSet;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.complementOf;
import static com.google.common.collect.Sets.newHashSet;
import static guava.SetsProvides.TestEnum.ONE;
import static guava.SetsProvides.TestEnum.THREE;
import static guava.SetsProvides.TestEnum.TWO;
import static java.util.EnumSet.of;
import static junit.framework.Assert.assertEquals;

public class SetsProvides {

    @Test
    public void inlineFactoryMethod() {
        final HashSet<Integer> numbers = newHashSet(1, 2, 3);
        assertEquals(3, numbers.size());
    }

    @Test
    public void cartesianProduct() {
        assertEquals(newHashSet(newArrayList(1, 3), newArrayList(2, 3)), Sets.cartesianProduct(newHashSet(1, 2), newHashSet(3)));
    }

    @Test
    public void complementOfEnum() {
        assertEquals(of(ONE, THREE), complementOf(of(TWO)));
    }

    enum TestEnum {ONE, TWO, THREE}

    @Test
    public void difference() {
        assertEquals(newHashSet(2), Sets.difference(newHashSet(1, 2), newHashSet(1, 3)));
    }

    @Test
    public void symmetricDifference() {
        assertEquals(newHashSet(2, 3), Sets.symmetricDifference(newHashSet(1, 2), newHashSet(1, 3)));
    }

    @Test
    public void filter() {
        assertEquals(newHashSet(2, 4), Sets.filter(newHashSet(1, 2, 3, 4), new DivisibleByTwoPredicate()));
    }

    @Test
    public void intersection() {
        assertEquals(newHashSet(2), Sets.intersection(newHashSet(1, 2), newHashSet(2, 3)));
    }

    @Test
    public void union() {
        assertEquals(newHashSet(1, 2, 3), Sets.union(newHashSet(1, 2), newHashSet(3)));
    }

    @Test
    public void lazyOperations() {
        final HashSet<Integer> source1 = newHashSet(1, 2);
        final HashSet<Integer> source2 = newHashSet(3);
        final Sets.SetView<Integer> union = Sets.union(source1, source2);

        assertEquals(newHashSet(1, 2, 3), union);

        source1.add(4);
        source2.add(4);
        source2.add(5);
        assertEquals(newHashSet(1, 2, 3, 4, 5), union);
    }
}
