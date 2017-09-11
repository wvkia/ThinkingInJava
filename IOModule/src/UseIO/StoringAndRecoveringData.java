package UseIO;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(PathUtil.path + "Data.txt")));
        out.writeDouble(1.2);
        out.writeUTF("That was pi");
        out.writeDouble(1.1);
        out.writeUTF("Square root of 2");
        out.close();


        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(PathUtil.path + "Data.txt")));
        System.out.println(in.readDouble());
        //Only readUTF() will re over the Java-UTF String properly;
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());

        System.out.println(in.readUTF());

    }
}
