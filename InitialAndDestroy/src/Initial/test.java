package Initial;

class  b{
    public b(){
        System.out.println("b + "+" ");
    }
}
public class test {
    public b b = new b();
    public test(){
        System.out.println("test ===");
    }
    {
        System.out.println("==a===");
    }

    public b ba = new b();

    public static void main(String[] args) {
        test t = new test();
    }
}
