/**
 * @author wukai
 * @date 2018/11/22
 */
public class Simple {
    public static void main(String[] args) {
        try {
            e();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void e() throws Exception {
        try {
            f();
        } catch (Exception e) {
            throw e;
        }

    }
    public static void f() throws Exception {
        throw new Exception("f");
    }
}
