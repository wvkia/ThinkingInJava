/**
 * 泛型方法
 * 泛型方法的泛型可以独立于类存在
 */
public class GenericMethod {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.f("sd");

    }
}
