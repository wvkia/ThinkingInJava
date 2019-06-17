package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wukai
 * @date 2019/5/27
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 10000);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        //写数据到server
        out.write("Hello Server \0".getBytes());

        //接收数据
        int b;
        while ((b = in.read()) != 0) {
            System.out.print((char) b);
        }
        System.out.println();

        socket.close();
    }
}
