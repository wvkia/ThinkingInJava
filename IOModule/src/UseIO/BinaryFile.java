package UseIO;

import java.io.*;

public class BinaryFile {
    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(bfile));
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            return data;
        }finally {
            inputStream.close();
        }

    }

    public static byte[] read(String filename) throws IOException {
        return read(new File(filename).getAbsoluteFile());
    }
}
