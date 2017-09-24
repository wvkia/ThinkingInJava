package ReflectPackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String arg = null;
        System.out.println("++++++++proxy : " + proxy.getClass() + " .method " + method + " , args " + args);
        return method.invoke(proxied, args);
    }
}
public class SimpleDynamicProxy {
    public static void consumer(Interface in) {
        in.doSomething();
        in.somethingElse("boomana");
    }

    public static void main(String[] args) {
        RealObejct realObejct = new RealObejct();
        consumer(realObejct);
        System.out.println("++++++++++++++++++++++++");
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObejct));
        consumer(proxy);
    }
}
