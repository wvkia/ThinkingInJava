import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
    static final  int LENGTH = 0x8FFF;
    static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fileChannel = new RandomAccessFile("data.txt", "rw").getChannel();
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');

        }
        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);

    }
    private static class LockAndModify extends Thread {
        private ByteBuffer byteBuffer;
        private int start,end;

        LockAndModify(ByteBuffer mmb, int start, int end) {
            this.start =start;
            this.end = end;
            mmb.limit(end);
            mmb.position(start);
            byteBuffer = mmb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                FileLock lock = fileChannel.lock(start, end, false);
                System.out.println("Lock start " + start + " end " + end);
                while (byteBuffer.position() < byteBuffer.limit() - 1) {
                    byteBuffer.put((byte) (byteBuffer.get() + 1));
                }
                lock.release();
                System.out.println("Released " + start + " " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
