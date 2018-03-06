import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String source = "source.data";
        String dest = "dest.data";
        File sour = new File(source),des = new File(dest);
        if (!sour.exists()){
            sour.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(sour);
            outputStream.write("nihao".getBytes());
            outputStream.close();
        }
        if (!des.exists()) {
            des.createNewFile();
        }
        FileChannel in = new FileInputStream(source).getChannel(),
                out = new FileOutputStream(dest).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        //通过-1判断是否到底末尾
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip();  //Prepare for writing
            out.write(byteBuffer);
            byteBuffer.clear(); //Prepare for reading
        }
    }
}
