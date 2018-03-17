import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] i = new int[5];
        int[] j = new int[9];
        //用一个对象填充数组
        Arrays.fill(i, 23);
        Arrays.fill(j, 24);

        System.out.println("i = " + i);
        System.out.println("J = " + j);

        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j =" + Arrays.toString(j));
    }
}
