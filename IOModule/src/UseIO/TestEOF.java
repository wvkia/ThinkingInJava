package UseIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read(PathUtil.path+"TestEOF.java")
                                .getBytes()));
        while (dataInputStream.available() != 0){
            System.out.print((char)dataInputStream.readByte());
        }
    }
}
