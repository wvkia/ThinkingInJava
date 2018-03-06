package Serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Horse implements Serializable{
}

class Animal implements Serializable {
    private String name;
    private Horse preferredHorse;

    Animal(String name, Horse preferredHorse) {
        this.name = name;
        this.preferredHorse = preferredHorse;
    }

    @Override
    public String toString() {
        return name+" [ "+super.toString()+" ]"+preferredHorse+" \n";
    }
}
public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Horse horse =new Horse();
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Animal("A", horse));
        list.add(new Animal("B", horse));
        list.add(new Animal("C", horse));
        System.out.println("Animals ============="+list);

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream out1 = new ObjectOutputStream(buf1);
        //写入两次，在同一个流中
        out1.writeObject(list);
        out1.writeObject(list);
        //写入到另一个完全不同的流
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(buf2);
        out2.writeObject(list);

        //序列回来
        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));

        List<Animal>
                list1 = (List<Animal>) in1.readObject(),
                list2 = (List<Animal>) in1.readObject(),
                list3 = (List<Animal>) in2.readObject();
        System.out.println("List1 =============          " + list1);
        System.out.println("List2 =============          " + list2);
        System.out.println("List3 =============          " + list3);
        //注意list1和list2采用同一个地址

    }
}
