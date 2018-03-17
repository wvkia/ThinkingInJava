/**
 * 迭代器模式
 */
interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object o) {
        if (next < items.length) {
            items[next++] = o;
        }
    }

    /**
     * 迭代器接口具体实现类
     */
    /**
     * 内部类实现
     * 内部类可以直接获取到外部类的数据和方法，保存有到外部类的引用
     */
    private class SequenceSelector implements Selector {

        private int i=0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    /**
     * 返回当前类的迭代器，采用内部类实现的方法
     * @return
     */
    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        int size = 10;
        Sequence sequence = new Sequence(size);
        for (int i = 0; i < size; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();

        }
    }
}
