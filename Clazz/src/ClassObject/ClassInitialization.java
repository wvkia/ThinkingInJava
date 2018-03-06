package ClassObject;

import java.util.Random;

/***
 * 每个类都有一个class对象，为了生成这个类的对象，JVM虚拟机会使用类加载器将 class文件加载到虚拟中并生成这个class对象
 * 所有的类都是在第一次被引用是进行动态加载的，即程序调用类的静态成员的引用，构造函数也是静态，所有new的时候被当作静态成员被引用
 *
 * 为了使用一个类需要进行 1、加载 2、链接 3、初始化三个步骤
 *
 * 加载   ： 即加载对应字节码，生成Class对象
 *
 * 链接   ：  验证字节码正确性，为静态域分配空间
 *
 * 初始化  ：如果有父类，对其初始化，执行其静态初始化构造器和静态块，然后执行自身的静态构造器和块
 *
 */

class Initable{
    //编译期常量，不需要初始化即可被读取
    static final int staticFinal=47;

    //不是编译期常量，需要初始化
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initialzing Initable");
    }
}
class Initable2{
    static int staticNonFinal=147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNonFinal=74;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> initable = Initable.class;
        System.out.println("=======After create Initable ref===");
        //不会触发初始化
        System.out.println(Initable.staticFinal);
        System.out.println("-------------------------");
        //触发初始化
        System.out.println(Initable.staticFinal2);
        System.out.println("----------------------");
        //触发初始化
        System.out.println(Initable2.staticNonFinal);
        System.out.println("------------------------");
        Class<?> aInitable3 = Class.forName("ClassObject.Initable3");
        System.out.println("=========After creating Initable3 ref=======");
        System.out.println(Initable3.staticNonFinal);
    }
}
