import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(new int[]{1, 2, 3, 4, 5});
        System.out.println(intBuffer.get(3));
        intBuffer.put(3, 222);
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.print(i+" ");
        }
    }
}
