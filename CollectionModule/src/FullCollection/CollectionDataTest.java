package FullCollection;

import java.util.LinkedHashSet;
import java.util.Set;

class Goverment implements Generator<String> {
    String[] foundation = ("a a d f g g h jh a").split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Goverment(), 9));


        set.addAll(CollectionData.list(new Goverment(), 9));
        System.out.println(set);
    }
}
