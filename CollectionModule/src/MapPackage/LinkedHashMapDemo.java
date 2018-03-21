package MapPackage;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //linkedHashMap以插入顺序返回键值对
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedMap);

        System.out.println("=================");

        //LRU least-recently-order  最近最少未使用
        //设置初始容量和扩容参数
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        //设置最近最少未使用，于是没有被访问的元素就会出现在队列的最前面，适合一些需要定期清理的程序
        System.out.println(linkedMap);
        System.out.println("-----------------------------");
        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        System.out.println("====");
        linkedMap.get(0);
        System.out.println(linkedMap);
    }
}
