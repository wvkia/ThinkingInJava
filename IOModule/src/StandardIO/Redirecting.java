package StandardIO;

import UseIO.PathUtil;

import java.io.*;

/**
 * 标准输入、输出、错误 重定向
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(PathUtil.StandardIOPath + "Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(PathUtil.StandardIOPath + "test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);

        }
        reader.close();
        out.close();
        System.setOut(console);
    }
}
