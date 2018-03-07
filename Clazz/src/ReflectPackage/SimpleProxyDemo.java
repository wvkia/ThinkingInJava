package ReflectPackage;

interface Interface{
    void doSomething();

    void somethingElse(String arg);
}

//实现类
class RealObejct implements Interface {
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Something else "  +arg);
    }
}

//代理类
class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy something");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse + "+arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface in) {
        in.doSomething();
        in.somethingElse("Boom");
    }

    public static void main(String[] args) {
        consumer(new RealObejct());
        System.out.println("============================");
        consumer(new SimpleProxy(new RealObejct()));

    }
}
