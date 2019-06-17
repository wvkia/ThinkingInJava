package BasicSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author wukai
 * @date 2019/6/13
 */
public class TCPEchoServer {
    private static final int BUFFSIZE=32;

    public static void main(String[] args) throws IOException {
        int serverPort = 8888;

        ServerSocket serverSocket = new ServerSocket(serverPort);

        int recvMsgSize;
        byte[] reciveBuf = new byte[BUFFSIZE];

        while (true) {
            Socket clntSocket = serverSocket.accept();

            SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
            System.out.println("客户端IP ：" + clientAddress);

            InputStream in = clntSocket.getInputStream();
            OutputStream out = clntSocket.getOutputStream();

            //接收数据直到返回-1为止
            while ((recvMsgSize = in.read(reciveBuf)) != -1) {
                out.write(reciveBuf, 0, recvMsgSize);
            }
            clntSocket.close();

        }
    }
}
