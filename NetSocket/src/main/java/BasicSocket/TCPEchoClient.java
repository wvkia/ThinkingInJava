package BasicSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author wukai
 * @date 2019/5/30
 */
public class TCPEchoClient {
    public static void main(String[] args) throws IOException {
        String server = "127.0.0.1"; //server name or ip address
        String messge = "sdf";
        int port = 8888;
        byte[] data = messge.getBytes();

        //创建socket用于连接server使用指定port
        Socket socket = new Socket(server, port);
        System.out.println("客户端连接到 server " + server + "，发送信息" + messge);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);

        //接收从server的回传信息
        int totalBytesRcvd = 0;//接收字节数
        int bytesRc;//接收的字节数

        while (totalBytesRcvd < data.length) {
            if ((bytesRc = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1) {
                throw new SocketException("连接中断");
            }

            //统计
            totalBytesRcvd += bytesRc;

        }
        System.out.println("客户端接收 " + new String(data));
        socket.close();

    }
}
