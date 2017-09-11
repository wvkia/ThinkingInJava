package UseIO;

import java.io.*;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        //Reading input by lines
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        //readLine为null时表示文件尾
        //readline会取出  \n
        while ((s = in.readLine()) != null) {
            stringBuilder.append(s).append("\n");
        }
        in.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("");
        System.out.println(read(PathUtil.path+"BufferedInputFile.java"));
    }
}
