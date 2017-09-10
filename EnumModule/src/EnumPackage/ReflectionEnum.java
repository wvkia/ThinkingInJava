package EnumPackage;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
enum Explore{
    HERE,THERE;
        }
public class ReflectionEnum {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("_---------------------------------");
        System.out.println("Interfaces: ");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base:  "+enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore containAll(Enum) ? "+exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum) : ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);

        //Decompile the code for the enum
//        OSExecute.command("javap Explore");
    }

}
