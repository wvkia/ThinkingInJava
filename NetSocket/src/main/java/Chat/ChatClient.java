package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * @author wukai
 * @date 2019/6/14
 */
public class ChatClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        String serverIp = "127.0.0.1";
        int serverPort = 8888;
        Socket socket = new Socket(serverIp, serverPort);

        final OutputStream outputStream = socket.getOutputStream();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //读取控制台输入
        final Scanner scanner = new Scanner(System.in);


        final CountDownLatch countDownLatch = new CountDownLatch(2);

        //处理socket读请求
        new Thread(new Runnable() {
            public void run() {
                try {
                    String msg = null;

                    while ((msg = reader.readLine()) != null) {
                        System.out.println(msg);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        }).start();

        //处理从控制写数据到socket
        new Thread(new Runnable() {

            public void run() {
                try {
                    String msg = null;
                    while ((msg = scanner.next()) != null) {
                        msg += "\n";
                        outputStream.write(msg.getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }

            }
        }).start();

        countDownLatch.await();
        socket.close();
    }
}
