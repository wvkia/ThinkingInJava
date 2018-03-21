package MapPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//土拨鼠类
class Groudhog{
    protected int number;

    public Groudhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groudhog # " + number;
    }
}
//天气预测类
class Prediction{
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of winter";
        }else {
            return "Early spring";
        }

    }
}

public class SpringDetector {
    public static <T extends Groudhog> void detectSpring(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groudhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map = " + map);
        Groudhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));

        }else{
            System.out.println("key not found: " +gh);
        }

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        detectSpring(Groudhog.class);
    }
}


