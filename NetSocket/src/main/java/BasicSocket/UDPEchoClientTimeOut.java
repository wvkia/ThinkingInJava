package BasicSocket;

import java.io.IOException;
import java.net.*;

/**
 * @author wukai
 * @date 2019/6/3
 */
public class UDPEchoClientTimeOut {
    private static final int TIMEOUT=3000;//超时
    private static final int MAXTRIES=5;//最大重试


    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int serverPort=8888;
        String message = "hello";

        InetAddress serverAddress = InetAddress.getByName(host);//server host
        byte[] bytesToSend = message.getBytes();

        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(TIMEOUT);

        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, serverPort);
        DatagramPacket receiverPacket =
                new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);

        int tries=0;
        boolean receivedResponse = false;

        do {
            socket.send(sendPacket);
            try {
                socket.receive(receiverPacket);
                if (!receiverPacket.getAddress().equals(serverAddress)) {
                    throw new IOException("接收到未知source");
                }

                receivedResponse = true;
            } catch (IOException e) {
                tries++;
                System.out.println("超时，" + (MAXTRIES - tries) + " 重试。。。");
                e.printStackTrace();
            }

        } while ((!receivedResponse) && (tries < MAXTRIES));

        if (receivedResponse) {
            System.out.println("接收信息: " + new String(receiverPacket.getData()));
        }else {
            System.out.println("没有返回--");

        }

        socket.close();
    }
}
