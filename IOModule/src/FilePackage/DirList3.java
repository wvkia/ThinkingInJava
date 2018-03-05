package FilePackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] lists;

        final String reg = ".*";
        lists = path.list(new FilenameFilter() {
            private Pattern pattern=Pattern.compile(reg);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(lists,String.CASE_INSENSITIVE_ORDER);
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
