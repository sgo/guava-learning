package guava.functions;

import com.google.common.base.Predicate;

public class FamilyPredicate implements Predicate<String> {
    public boolean apply(String input) {
        return input.endsWith("Doe");
    }
}
