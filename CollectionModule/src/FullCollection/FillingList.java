package FullCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress{
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString()+" "+s;
    }
}
public class FillingList {
    public static void main(String[] args) {
        StringAddress stringAddress = new StringAddress("hello");
        //注意，此处Collections.nCopies通过同一个对象引用填充整个容器
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, stringAddress));
        System.out.println(list);
        stringAddress.setS("haha");
        System.out.println(list);
        //fill也是如此
        Collections.fill(list, new StringAddress("world"));
        System.out.println(list);

    }
}
