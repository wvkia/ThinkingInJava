package FilePackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] lists;
//        lists = path.list(new DirFilter(""));
        //list接收一个FilenameFilter作为参数，判断文件是否存在目录中
        //list()会为下面的每个文件都调用accpet方法，判断是否满足true
        lists = path.list(new DirFilter(".*"));
        Arrays.sort(lists,String.CASE_INSENSITIVE_ORDER);
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
//此类就是为了实现FilenameFilter，实现accept方法
class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regax) {
        this.pattern = Pattern.compile(regax);
    }

    //接收一个代表特定文件所在目录的File对象，和文件名
    //根据accept方法，判断文件是否存在文件目录中
    @Override
    public boolean accept(File dir, String name) {
        //实现为根据正则表达式判断
        return pattern.matcher(name).matches();
    }
}
