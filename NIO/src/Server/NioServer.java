package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author wukai
 * @date 2019/5/27
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel listenChannel = ServerSocketChannel.open();
        listenChannel.bind(new InetSocketAddress(10000));
        listenChannel.configureBlocking(false);
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        //缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        while (true) {
            selector.select();//阻塞，直到监听事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            //
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                //连接接收
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);//监听读

                    System.out.println("和 [" + socketChannel.getRemoteAddress() + " 建立连接 ");
                } else if (key.isReadable()) {
                    byteBuffer.clear();

                    //如果读取到流末尾说明TCP断开，需要关闭通道，取消监听read
                    if (((SocketChannel) key.channel()).read(byteBuffer) == -1) {
                        key.channel().close();
                        continue;
                    }

                    //遍历数据
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        byte b = byteBuffer.get();

                        if (0 == b) {//消息到达 \0，代表消息结束
                            System.out.println();

                            //响应client，写数据传给client
                            byteBuffer.clear();
                            byteBuffer.put("Hello,Client\0".getBytes());
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()) {
                                ((SocketChannel) key.channel()).write(byteBuffer);
                            }

                        }else {
                            System.out.print((char) b);
                        }
                    }
                }
                keyIterator.remove();
            }
        }

    }
}
