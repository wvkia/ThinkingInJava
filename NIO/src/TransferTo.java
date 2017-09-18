import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws IOException {
        String source = "source.data";
        String dest = "dest.data";
        FileChannel in = new FileInputStream(source).getChannel(),
                out = new FileOutputStream(dest).getChannel();
//        in.transferTo(0, in.size(), out);
        //or
        out.transferFrom(in,0,in.size());
    }
}
