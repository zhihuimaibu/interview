package 文件;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        String[] arrays = new String[]{"src"};
        if(arrays.length == 0) {
            list = path.list();
        }else {
            list = path.list(new DirFilter(arrays[0]));
        }
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
