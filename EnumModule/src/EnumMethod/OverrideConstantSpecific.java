package EnumMethod;

public enum  OverrideConstantSpecific {
    NUT,
    //覆盖常量方法
    WASHER{
        void  f(){
            System.out.println("Override method");
        }
    };
    void f(){
        System.out.println("Default method");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific overrideConstantSpecific : values()) {
            System.out.println(overrideConstantSpecific+": ");
            overrideConstantSpecific.f();
        }
    }

}
