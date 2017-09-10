package EnumPackage;
enum Search{
    HITHER,YOU
}

public class UpcaseEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        //no values() in enum
        for (Enum anEnum : e.getClass().getEnumConstants()) {
            System.out.println(anEnum);
        }
    }
}
