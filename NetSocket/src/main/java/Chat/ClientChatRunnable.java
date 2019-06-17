package Chat;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * @author wukai
 * @date 2019/6/14
 */
public class ClientChatRunnable implements Runnable{
    private Socket socket;

    private BufferedReader reader;
    private OutputStream writer;

    public ClientChatRunnable(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String msg = null;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = socket.getOutputStream();
            writer.write("请输入用户名:\n".getBytes());

            msg = reader.readLine();
            System.out.println("用户名: " + msg);

            writer.write("请输入密码:\n".getBytes());
            msg = reader.readLine();
            System.out.println("密码: " + msg);

            writer.write("登陆成功:\n".getBytes());

            while ((msg = reader.readLine()) != null) {
                msg += "\n";

                for (Socket item : ChatServer.clientList) {
                    if (item != socket) {
                        System.out.println("发送消息["+msg+"]到 "+item);
                        item.getOutputStream().write(msg.getBytes());

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLine(String string) {
        System.out.println(string);

    }
}
