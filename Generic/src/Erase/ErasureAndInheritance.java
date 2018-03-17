package Erase;

class GeneriaBase<T>{
    private T element;

    public void set(T ag) {
        element = ag;
    }
    public T get() {
        return element;
    }
}

class Derived1<T> extends GeneriaBase {

}

class Derived2<T> extends GeneriaBase {

}
public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object o = derived2.get();
        derived2.set(o);
    }
}
