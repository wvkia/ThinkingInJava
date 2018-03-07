package ReflectClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class SomeMethods {
    private static Pattern p=Pattern.compile("\\w+\\.");

    public static void getMethod(String clazzName) {
        try {
            Class<?> c = Class.forName(clazzName);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor ctor : ctors) {
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));

            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getMethod("ReflectClass.SomeMethods");
    }
}
