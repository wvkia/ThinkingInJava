package GenericInterface;

//注意这里的实现，之所以叫做生成器，和python的生成器效果是一致的
public class Fibonacci implements Generator<Integer> {
    private int count=0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 4; i++) {
            System.out.println(fibonacci.next()+" ");

        }
    }
}
