import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        //Alocation automatically zeroes the ByteBuffer
        int i = 0;
        while (i++ < buffer.limit()) {
            if (buffer.get() != 0) {
                System.out.println("nonzero");

            }
        }

        System.out.println("I = " + i);
        buffer.rewind();
        //
        buffer.asCharBuffer().put("woody");
        char c;
        while ((c = buffer.getChar()) != 0) {
            System.out.print(c+" ");
        }
        System.out.println();
        buffer.rewind();
        //
        buffer.asShortBuffer().put((short) 34);
        System.out.println(buffer.getShort());
        buffer.rewind();
        //
        buffer.asIntBuffer().put(12);
        System.out.println(buffer.getInt());
        buffer.rewind();
        //
        buffer.asDoubleBuffer().put(2.3);
        System.out.println(buffer.getDouble());

        buffer.rewind();
    }
}
