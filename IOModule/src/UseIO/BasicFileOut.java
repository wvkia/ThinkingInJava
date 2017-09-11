package UseIO;

import java.io.*;

public class BasicFileOut {
    static String file =PathUtil.path+ "BasicOut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(BufferedInputFile.read(PathUtil.path+"BasicFileOut.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int linecount = 1;
        String s;
        while ((s =bufferedReader.readLine()) !=null){
            out.println(linecount++ + " : "+s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
