package FilePackage;

import java.io.File;

public class MakeDirectories {

    private static void fileData(File file) {
        System.out.println("Absolute path: " + file.getAbsolutePath()
                + "\n can read: " + file.canRead()
                + "\n can write" + file.canWrite()
                + "\n getName " + file.getName()
                + "\n getParent " + file.getParent()
                + "\n getPath " + file.getPath()
                + "\n length " + file.length()
                + "\n lastModified " + file.lastModified());

        if (file.isDirectory()) {
            System.out.println("It's a directory");
        } else if (file.isFile()) {
            System.out.println("It's a file");
        }
    }

    public static void main(String[] args) {
        File old = new File("C:\\test.java");
        if (old.exists()) {
            System.out.println(old + " exist");
            old.delete();
        } else {
            old.mkdirs();
        }

        File rname = new File("C:\\haha.java");
        old.renameTo(rname);
        fileData(old);
        fileData(rname);

        rname.delete();
    }
}
