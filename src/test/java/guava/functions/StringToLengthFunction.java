package guava.functions;

import com.google.common.base.Function;

public class StringToLengthFunction implements Function<String, Integer> {
    public Integer apply(String fruit) {
        return fruit.length();
    }
}
