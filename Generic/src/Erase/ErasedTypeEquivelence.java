package Erase;

import com.sun.media.sound.SoftTuning;

import java.util.ArrayList;

/**
 * 泛型都是通过擦除实现的，没有对应 的泛型类
 */
public class ErasedTypeEquivelence {
    public static void main(String[] args) {
        Class cl1 = new ArrayList<Integer>().getClass();
        Class cl2 = new ArrayList<Long>().getClass();
        System.out.println(cl1 == cl2);
    }
}
