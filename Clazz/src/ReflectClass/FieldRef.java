package ReflectClass;

import java.lang.reflect.Field;

/**
 * Class的域
 */
class father{
    public int a;
    private long b;
    protected  short c;
}
public class FieldRef  extends father{
    public String name;
    private String age;
    protected String field;

    public static void main(String[] args) {
        Class c = FieldRef.class;

        //获取所有 公有 字段，包括父类
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---");



        //获取所有字段，只限定到本类
        fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);

        }
        System.out.println("--");




        //根据字段名称获取，只能是公有
        try {
            Field f = c.getField("name");
            System.out.println(f);
            //为对象的字段设置值
            FieldRef temp = new FieldRef();
            f.set(temp, "wvkia");
            System.out.println(temp.name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("--------------------");




        //根据名称获取，可以是私有的
        try {
            Field f = c.getDeclaredField("age");
            System.out.println(f);
            FieldRef temp = new FieldRef();

            //私有域 设置值，需要暴力解除私有限定
            f.setAccessible(true);
            f.set(temp, "12");

            System.out.println(temp.age);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
