package ProcessIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            //配置编码
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader erros = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = erros.readLine()) != null) {
                System.err.println(s);
                err = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OSExecute.command("ipconfig");
    }
}
