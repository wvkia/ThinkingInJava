package ReflectClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class father1{
    protected void test(){}
}
public class MethodRef  extends father1{
    public static void main(String[] args) {
        Class c = MethodRef.class;

        //获取所有公有方法，包括父类也包括object类
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("-------------------------------");

        //获取所有方法，但只限于本类
        methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //根据方法名称和参数类型获取method

        System.out.println("-------------------------------");
        try {
            Method m = c.getMethod("equals", Object.class);
            System.out.println(m);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------");
        //通过invoke方法可以执行方法
        try {
            Method m = c.getMethod("toString");
            MethodRef methodRef = new MethodRef();
            Object o = m.invoke(methodRef);
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
