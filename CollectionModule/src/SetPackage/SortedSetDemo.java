package SetPackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> stringSortedSet = new TreeSet<>();
        Collections.addAll(stringSortedSet, "one two three four five".split(" "));
        System.out.println(stringSortedSet);

        String low = stringSortedSet.first();
        String high = stringSortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> ite = stringSortedSet.iterator();

        System.out.println(stringSortedSet.subSet(low, high));
        System.out.println(stringSortedSet.headSet(high));
        System.out.println(stringSortedSet.tailSet(low));
    }
}
