import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
    private static void symmeticScramble(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            charBuffer.mark();
            char c1 = charBuffer.get();
            char c2 = charBuffer.get();
            charBuffer.reset();
            charBuffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char [] data = "UsingBuffers".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer  = buffer.asCharBuffer();
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());
        symmeticScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmeticScramble(charBuffer);

        System.out.println(charBuffer.rewind());
    }
}
