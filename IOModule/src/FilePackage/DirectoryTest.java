package FilePackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class DirectoryTest {
    //所有满足正则的文件数组
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "dirs : " + PPrint.pformat(dirs) + " \n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDir(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDir(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDir(start, ".*");
    }

    //递归调用
    public static TreeInfo walk(String start) {
        return recurseDir(new File(start), ".*");
    }

    static TreeInfo recurseDir(File start, String regex) {
        TreeInfo treeInfo = new TreeInfo();
        for (File file : start.listFiles()) {
            if (file.isDirectory()) {
                treeInfo.dirs.add(file);
                treeInfo.addAll(recurseDir(file, regex));
            } else {
                if (file.getName().matches(regex)) {
                    treeInfo.files.add(file);
                }
            }
        }
        return treeInfo;
    }


    public static void main(String[] args) {
        //All directory
        PPrint.pprint(DirectoryTest.walk(".").dirs);
        //All files beginning with 'D'
        for (File file : DirectoryTest.local(".", "D.*")) {
            System.out.println(file);
        }
        System.out.println("===========================");
        //All java file
        for (File file : DirectoryTest.walk(".", "D.*\\java")) {
            System.out.println(file);
        }
        System.out.println("=============================");
        //Class file containning z or Z
        for (File file : DirectoryTest.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file);
        }
    }
}
