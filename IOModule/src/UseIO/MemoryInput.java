package UseIO;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        //read以int型返回下一字节
        while ((c = reader.read()) != -1){
            System.out.print((char) c);
        }
    }
}
