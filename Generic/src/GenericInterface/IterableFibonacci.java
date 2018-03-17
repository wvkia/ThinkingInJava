package GenericInterface;

import java.util.Iterator;

/**
 * 适配器模式
 * 实现Iterable接口
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                //内部类实现，通过this关键字调用外部类的next()方法
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
}
