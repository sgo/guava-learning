package guava.functions;

import com.google.common.collect.Maps;

public class ToPersonTransformer implements Maps.EntryTransformer<String, Integer, ToPersonTransformer.Person> {
    public Person transformEntry(String key, Integer value) {
        final Person p = new Person();
        p.name = key;
        p.age = value;
        return p;
    }

    public static class Person {
        public String name;
        public int age;
    }
}
