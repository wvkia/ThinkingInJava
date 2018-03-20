package FullCollection;

import java.util.LinkedHashMap;

class Pair<K, V>{
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key=k;
        value=v;
    }
}

public class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }
}
