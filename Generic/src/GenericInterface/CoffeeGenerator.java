package GenericInterface;

import java.util.Iterator;
import java.util.Random;
//实现生成器
//继承Iterable接口，用于返回一个迭代器Iterator，通常用于foreach
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class,Mocha.class};
    private static Random random = new Random(47);

    private int size = 0;
    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) {
        this.size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Iterator实现类，迭代器模式
     */
    class CoffeeIterator implements Iterator<Coffee> {

        //内部类可访问外部类域和方法
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            //通过this关键字获取外部类方法
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        System.out.println("==================");
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }
}
