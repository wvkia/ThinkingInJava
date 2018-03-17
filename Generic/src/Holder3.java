/**
 * 简单类型参数T
 * @param <T>
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Integer> holder3 = new Holder3<>(1);
        Integer a = holder3.getA();
        System.out.println(a);
        //Error compile
//        holder3.setA("sadf");
    }
}
