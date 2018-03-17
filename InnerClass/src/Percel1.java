/**
 * 内部类
 */

/**
 * 最普通的内部类使用方法
 * 仅仅是使用内部类作为封装对象和方法，简化代码以及模块化代码
 */
public class Percel1 {
    class content{
        private int i=11;
        public int value() {
            return i;
        }
    }
    class Destination{
        private String lable;

        Destination(String whereto) {
            lable = whereto;
        }
        String readLable() {
            return lable;
        }
    }

    public void ship(String dest) {
        content content = new content();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLable());
    }

    public static void main(String[] args) {
        Percel1 percel1 = new Percel1();
        percel1.ship("aaa");
    }
}
