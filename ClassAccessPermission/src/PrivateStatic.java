class soup1{
    private soup1() {

    }
    //static方法可以访问 private的构造器
    public static soup1 makeSoup1() {
        return new soup1();
    }
}
class soup2{
    private soup2() {

    }

    //单例模式
    private static soup2 soup2 = new soup2();
    public static soup2 access() {
        return soup2;
    }
}
public class PrivateStatic {
}
