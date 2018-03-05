package UseIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = PathUtil.path + "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("value "+ i +" : "+rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");;
        for (int i = 0; i < 7; i++) {
            randomAccessFile.writeDouble(i * 12.6);
        }
        randomAccessFile.writeUTF("The end of file");
        randomAccessFile.close();
        display();
        randomAccessFile = new RandomAccessFile(file, "rw");
        //double为8个字节
        randomAccessFile.seek(5 * 8);
        randomAccessFile.writeDouble(45.666);
        randomAccessFile.close();
        display();
        File f = new File(file);
        f.delete();
    }
}
