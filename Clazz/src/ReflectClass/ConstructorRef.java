package ReflectClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Class的构造器对象
 */

public class ConstructorRef {

    public ConstructorRef() {
    }

    private ConstructorRef(String name) {
    }

    public static void main(String[] args) {
        Class<?> c = ConstructorRef.class;

        //所有"公有的"构造方法
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("-----");
        //获取所有构造方法，包括私有
        constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----");
        //根据参数获取 单个 公有
        Constructor con = null;
        try {
            con = c.getConstructor(String.class);
            System.out.println(con);
        } catch (NoSuchMethodException e) {
            System.out.println("Couldn't find ..");
        }
        System.out.println("-----");
        //根据参数获取 单个 从所有的构造方法中找
        try {
            con = c.getDeclaredConstructor(String.class);
            System.out.println(con);
        } catch (NoSuchMethodException e) {
            System.out.println("Couldn't find ..");
        }
        System.out.println("--");
        //构造器可以用来创建对象
        try {
            Object o=con.newInstance("name");
            System.out.println(o.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
