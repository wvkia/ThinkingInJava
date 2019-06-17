package UseIO;

import java.io.*;
import java.util.HashMap;

public class BufferedInputFile {
    //通过reader读取文件
    public static String read(String filename) throws IOException {
        filename = PathUtil.path + filename;
        //Reading input by lines
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        //readLine为null时表示文件尾
        //readline会取出  \n

        while ((s = in.readLine()) != null) {
            stringBuilder.append(s).append("\n");
        }
        char c;
        //回到开始位置

        in.close();
        return stringBuilder.toString();
    }

    //通过inputstream读取文件
    public static String read0(String filename) throws IOException {
        filename = PathUtil.path + filename;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        //每次读取一个字节
        while ((i = in.read()) != -1) {
            stringBuilder.append((char) i);
        }
        in.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("");
        System.out.println("=============this is reader =-===============");
        System.out.println(read("BufferedInputFile.java"));
        System.out.println("===============this is inputstream=================");
        System.out.println(read0("BufferedInputFile.java"));
    }
}
