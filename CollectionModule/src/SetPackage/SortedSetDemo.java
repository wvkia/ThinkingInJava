package SetPackage;

import java.util.*;

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

        EnumSet<Thread.State> set =HashMap
    }
}
