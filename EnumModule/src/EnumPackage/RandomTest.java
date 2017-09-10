package EnumPackage;
enum Activity{
    SITTING,LYING,STANDING,HOPPING,RUNNING;
}
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class));
        }
    }
}
