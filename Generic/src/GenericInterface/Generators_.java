package GenericInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Generators_ {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer fnumber : fnumbers) {
            System.out.println(fnumber);
        }
    }
}
