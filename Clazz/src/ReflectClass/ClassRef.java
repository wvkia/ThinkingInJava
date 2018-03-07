package ReflectClass;

/**
 * 获取Class对象
 */
public class ClassRef {
    public static void main(String[] args) {
        //1、通过Class类的forName获取
        try {
            Class<?> clazz = Class.forName("ReflectClass.ClassRef");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、直接获取
        Class<?> clazz = ClassRef.class;
        //3、getClass（）方法
        clazz = new ClassRef().getClass();


    }
}
