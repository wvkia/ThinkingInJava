package FailFast;

import FullCollection.CollectionData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> iterator = c.iterator();
        c.add("asdf");
        try {
            String s = iterator.next();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
