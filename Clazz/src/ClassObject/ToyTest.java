package ClassObject;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
    Toy(){}

    Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class clazz) {
        System.out.println("Class name: " + clazz.getName() + " is interface: " + clazz.isInterface() + " ] ");
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name : " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("ClassObject.FancyToy");
        } catch (Exception e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        //print all interface
        for (Class<?> aClass : c.getInterfaces()) {
            printInfo(aClass);
        }
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            //使用newInstance必须有默认构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);

        }
        printInfo(obj.getClass());

    }
}
