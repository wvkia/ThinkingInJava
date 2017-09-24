package ReflectPackage;

import ReflectPackage.pack.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        //不能编译成C，因为C不属于包外部可用

//        if (a instanceof C) {
//            C c = (C) a;
//            c.g();
//        }
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");

    }

    static void callHiddenMethod(Object a, String methodname) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = a.getClass().getDeclaredMethod(methodname);
        method.setAccessible(true);
        method.invoke(a);
    }
}
