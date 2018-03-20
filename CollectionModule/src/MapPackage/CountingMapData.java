package MapPackage;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 继承抽象map接口，实现自定义map
 */
public class CountingMapData extends AbstractMap<Integer, String> {

    private int size;
    private static String[] chars="A B C D E F G".split(" ");

    public CountingMapData(int size) {
        if (size < 0) {
            this.size = 0;
        }
        this.size = size;
    }

    //实现自定义的 Map.Entry
    private static class Entry implements Map.Entry<Integer,String>{
        int index;

        public Entry(int index) {
            this.index = index;
        }

        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        public int hasCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(40));

    }
}
