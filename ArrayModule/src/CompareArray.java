import java.util.Arrays;

public class CompareArray {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];

        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);

        System.out.println(Arrays.equals(a1, a2));
    }
}
