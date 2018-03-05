package UseIO;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            //ByteArrayInputStream提供字节数组
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("FormattedMemoryInput.java").getBytes()));
            while (true) {
                System.out.print((char) inputStream.readByte());
            }
            //通过异常返回，不应该适用
        } catch (EOFException e) {
            System.err.println("End of stream");
        }


    }
}
