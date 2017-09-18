package Serializable;

import java.io.*;
import java.util.Random;

/**
 * Serializable会保存一个对象网，直接从字节流里获取信息，不经过构造器
 */
class Data implements Serializable{
    private int id;

    public Data(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
public class Worm implements Serializable{
    private static Random random = new Random();
    private Data[] data = {
            new Data(random.nextInt(10))
            , new Data(random.nextInt(10))
            , new Data(random.nextInt(10))
    };

    //序列化读取不会被调用
    public Worm() {
        System.out.println("Constructor");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Data datum : data) {
            stringBuilder.append(datum);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm();
        System.out.println(worm);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.data"));
        out.writeObject("Worm storage");
        out.writeObject(worm);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.data"));
        String s = (String) in.readObject();
        System.out.println(s);
        Worm worm1 = (Worm) in.readObject();
        System.out.println(worm1);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm stogae2");

        out2.writeObject(worm);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        System.out.println(s);
        Worm worm2 = (Worm) in2.readObject();
        System.out.println(worm2);
    }

}
