package ReflectPackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理处理器实现类
 */
class DynamicProxyHandler implements InvocationHandler {
    //实际类对象
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    //代理调用方法，对代理接口的任何方法调用都被重定向到这里
    @Override
    //参数                              代理类对象         被调用的方法          方法参数
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

        //创建动态代理 Proxy.newProxyInstance                         类加载器                                                需要代理的接口列表               InvocationHandler的实现类
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObejct));
        consumer(proxy);
    }
}
