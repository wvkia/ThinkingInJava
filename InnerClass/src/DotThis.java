public class DotThis {
    void f() {
        System.out.println("Dot this");

    }

    public class Inner {
        /**
         *
         * @return
         */
        public DotThis outer() {
            //this 关键字
            //通过外部类的名字+this关键字  可以返回外部类 的引用
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        //创建内部类可以通过 对象方法创建
        DotThis.Inner dti = dotThis.inner();
        //或者通过外部类对象 new关键字
        //因为必须存在外部类引用才能有内部类对象

        DotThis.Inner inner = dotThis.new Inner();
        dti.outer().f();
    }
}
