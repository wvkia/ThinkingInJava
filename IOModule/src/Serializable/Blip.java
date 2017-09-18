package Serializable;

import java.io.*;

/**
 * Externalizable需要自己写对应的读取和写入方法，且会执行默认的public构造器，如果没有pulic或者默认构造器，则会报错
 */

/**
 * 注意和Serializable的区别，Serializable是完全以它存储的二进制为基础来构造，而不调用构造器，
 * 但Externalizable会调用默认的构造器，然后调用readExternal方法
 */
class Blip1 implements Externalizable{
    //pulic的公有构造器
    public Blip1(){
        System.out.println("Blip1 constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        System.out.println("Blip2 construtor");
    }
    @Override

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2 readExternal");
    }
}
public class Blip {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing Objects===================");
        Blip1 blip1 =new Blip1();
        Blip2 blip2 = new Blip2();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip.out"));
        System.out.println("Saving Object==============================");
        out.writeObject(blip1);
        out.writeObject(blip2);
        out.close();
        //Now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip.out"));
        System.out.println("Recovering blip1 ============================");
        blip1 = (Blip1) in.readObject();

        //下面会报错
        System.out.println("Recovering blip2 ============================");
        blip2 = (Blip2) in.readObject();
    }
}
