package EnumMethod;

import java.util.EnumSet;

public class CarWash {
    public enum Cycle{
        //重写抽象方法
        BASIC{
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },BLOWDRY{
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC);

    public void add(Cycle cycle){
        cycles.add(cycle);
    }
    public void washcar(){
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash= new CarWash();
        System.out.println(wash);
        wash.washcar();
        //Order of addition is umimportant
        wash.add(Cycle.BASIC);
        wash.add(Cycle.BLOWDRY);

        System.out.println(wash);

        wash.washcar();
    }
}
