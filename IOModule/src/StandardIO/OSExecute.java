package StandardIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String cmd) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(cmd.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);

            }
            System.out.println("===========================");
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = error.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (err) {
            throw new OSExecuteException("Error executing " + cmd);
        }
    }

    public static void main(String[] args) {
        OSExecute.command("java -version");

    }
}

class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}
