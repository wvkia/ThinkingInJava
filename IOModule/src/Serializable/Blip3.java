package Serializable;

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 constructor");
    }

    public Blip3(int i, String s) {
        System.out.println("Blip3 (String,int)");

        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s+"  "+i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3 writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3 readExternal");
        //必须要自己读取并赋值
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructor objects==========================");
        Blip3 blip3 = new Blip3(1,"haha ");
        System.out.println(blip3);
        byte [] arr = new byte[1024];
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object==============================");
        out.writeObject(blip3);
        out.close();
        System.out.println("Reading object===========================");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        blip3 = (Blip3) in.readObject();
        System.out.println(blip3);
    }
}
