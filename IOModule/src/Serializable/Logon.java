package Serializable;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * transient瞬时关键字，表示某些字段不允许被序列化
 * 只能和serializable使用
 */
public class Logon implements Serializable{

    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "logon info: \n" + username + " date " + date + " pass"+password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Logon logon  =new Logon("abc","bca");
        System.out.println("Logon a "  +logon);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logon.out"));
        out.writeObject(logon);
        out.close();
        TimeUnit.SECONDS.sleep(1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("logon.out"));
        System.out.println("Recoving =======================");
        logon = (Logon) in.readObject();
        System.out.println(logon);
        //被序列化之后的date仍为原先，并未重新生成
    }
}
