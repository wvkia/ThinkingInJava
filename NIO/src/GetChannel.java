import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;

    //旧的IO 中的 FileInputStream、FileOutputStream、RandomAccessFile被修改，可产生channel对象
    public static void main(String[] args) throws IOException {
        File file = new File("data.data");
        //Write a file
        FileChannel fileChannel = new FileOutputStream("data.data").getChannel();
        //中文写入文件没有问题，buteBuffer.get()会乱码
        fileChannel.write(ByteBuffer.wrap("Some text你好 ".getBytes()));
        fileChannel.close();
        //Add to the end of file
        fileChannel = new RandomAccessFile("data.data","rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("Some end".getBytes()));
        fileChannel.close();
        //Read the file
        fileChannel = new FileInputStream("data.data").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char)byteBuffer.get());
        }
//        file.delete();
    }
}
