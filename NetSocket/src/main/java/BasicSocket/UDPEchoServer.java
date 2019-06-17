package BasicSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wukai
 * @date 2019/6/3
 */
public class UDPEchoServer {
    private static final int ECHOMAX=222;

    public static void main(String[] args) throws IOException {
        int serverPort = 8888;

        DatagramSocket socket = new DatagramSocket(serverPort);
        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);

        while (true) {
            socket.receive(packet);
            System.out.println("Handling client at " + packet.getAddress().getHostAddress() + " on port " + packet.getPort()+" message= "+packet.getData());

            socket.send(packet);
            packet.setLength(ECHOMAX);

        }
    }
}
