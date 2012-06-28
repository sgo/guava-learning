package guava.functions;

import com.google.common.base.Predicate;

public class DivisibleByTwoPredicate implements Predicate<Integer> {
    public boolean apply(Integer input) {
        return input % 2 == 0;
    }
}
