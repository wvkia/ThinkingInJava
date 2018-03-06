package ClassObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 使用 注册工厂 模式
 * @param <T>
 */

interface Factory<T>{
    T create();
}
class Part{
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFacotries = new ArrayList<>();
    static {
        partFacotries.add(new FuelFilter.Factory());
        partFacotries.add(new AirFilter.Factory());
        partFacotries.add(new OilFilter.Factory());

        partFacotries.add(new FanBelt.Factory());
    }

    private static Random random = new Random(47);
    public static Part createRandom() {
        int n=random.nextInt(partFacotries.size());
        return partFacotries.get(n).create();
    }
}

//分类标识
class Filter extends Part {

}

class FuelFilter extends Filter {
    //为每个类型创建一个class factory
    public static class Factory implements ClassObject.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {
    //为每个类型创建一个class factory
    public static class Factory implements ClassObject.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class OilFilter extends Filter {
    //为每个类型创建一个class factory
    public static class Factory implements ClassObject.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

//分类标识
class Belt extends Part {

}

class FanBelt extends Belt {
    public static class Factory implements ClassObject.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }

}
