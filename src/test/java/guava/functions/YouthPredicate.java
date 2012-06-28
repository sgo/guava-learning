package guava.functions;

import com.google.common.base.Predicate;

public class YouthPredicate implements Predicate<Integer> {
    public boolean apply(Integer input) {
        return input < 18;
    }
}
