import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String source = "source.data";
        String dest = "dest.data";
        FileChannel channel = new FileOutputStream(source).getChannel();
        channel.write(ByteBuffer.wrap("someText".getBytes()));
        channel.close();

        channel = new FileInputStream(source).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        channel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());


        //decode
        buffer.rewind();
        String encode = System.getProperty("file.encoding");
        System.out.println("decode String " + encode + " " + Charset.forName(encode).decode(buffer));
        channel = new FileOutputStream(source).getChannel();
        channel.write(ByteBuffer.wrap("Some txt ".getBytes("UTF-16BE")));
        channel.close();

        //Now try reading again
        buffer.clear();
        channel = new FileInputStream(source).getChannel();
        channel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        //Use a CharBuffer to write through
        channel = new FileOutputStream(source).getChannel();
        buffer = ByteBuffer.allocate(24);
        buffer.asCharBuffer().put("some text");
        channel.write(buffer);
        channel.close();
        //read and display
        channel = new FileInputStream(source).getChannel();
        buffer.clear();
        channel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
