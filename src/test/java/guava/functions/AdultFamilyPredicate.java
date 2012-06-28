package guava.functions;

import com.google.common.base.Predicate;

import java.util.Map;

public class AdultFamilyPredicate implements Predicate<Map.Entry<String, Integer>> {
    public boolean apply(Map.Entry<String, Integer> input) {
        return input.getKey().endsWith("Doe") && input.getValue() > 18;
    }
}
