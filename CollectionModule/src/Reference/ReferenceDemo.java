package Reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {
    public static void main(String[] args) {
        //强引用
        Object o = new Object();

        //软引用
        SoftReference<String> softReference = new SoftReference<String>("");
        //弱引用
        WeakReference<Object> weakReference = new WeakReference<Object>("");

    }
}
