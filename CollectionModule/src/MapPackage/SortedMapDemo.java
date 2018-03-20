package MapPackage;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        //TreeMap是现唯一实现可排序的Map，key必须实现Compare接口
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap);

        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();

        System.out.println(low);
        System.out.println(high);

        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            }
            it.next();
        }

        System.out.println(low);

        System.out.println(high);

        //生成子集
        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));
    }
}
