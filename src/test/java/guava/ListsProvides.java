package guava;

import guava.functions.StringToLengthFunction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.*;
import static junit.framework.Assert.assertEquals;

public class ListsProvides {

    @Test
    public void inlineFactoryMethod() {
        final ArrayList<Integer> numbers = newArrayList(1, 2, 3);
        assertEquals(3, numbers.size());
    }

    @Test
    public void partitioning() {
        final ArrayList<Integer> source = newArrayList(1, 2, 3);
        final List<List<Integer>> partitions = partition(source, 2);
        assertEquals(newArrayList(1, 2), partitions.get(0));
        assertEquals(newArrayList(3), partitions.get(1));
    }

    @Test
    public void reverseElementOrder() {
        assertEquals(newArrayList(3, 2, 1), reverse(newArrayList(1, 2, 3)));
    }

    @Test
    public void transformations() {
        final List<Integer> numbers = transform(newArrayList("apple", "orange", "banana"), new StringToLengthFunction());
        assertEquals(newArrayList(5, 6, 6), numbers);
    }

    @Test
    public void lazyOperations() {
        final ArrayList<String> source = newArrayList("apple", "orange", "banana");
        final List<Integer> target = transform(source, new StringToLengthFunction());
        assertEquals(newArrayList(5, 6, 6), target);

        source.add("pineapple");
        assertEquals(newArrayList(5, 6, 6, 9), target);
    }
}
