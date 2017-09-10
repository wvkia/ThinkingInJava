package EnumMethod;

import java.text.DateFormat;
import java.util.Date;
//枚举类
public enum  ConstantSpecificMethod {
    //enum实例实现对应的抽象方法
    DETE_TIME{
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    //抽象方法
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod constantSpecificMethod : values()) {
            System.out.println(constantSpecificMethod.getInfo());
        }
    }
}
