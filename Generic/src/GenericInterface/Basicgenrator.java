package GenericInterface;

public class Basicgenrator<T> implements Generator<T> {
    private Class<T> type;

    public Basicgenrator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // type对应的类必须有默认构造器，因为newInstance调用的是默认构造器
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new Basicgenrator<>(type);
    }


    public static void main(String[] args) {
        Generator<CounterObejct> gen = Basicgenrator.create(CounterObejct.class);
        for (int i = 0; i < 2; i++) {
            System.out.println(gen.next());
        }
    }
}
//测试类
class CounterObejct{
    private static long counter=0;

    @Override
    public String toString() {
        return " " + counter;
    }
}