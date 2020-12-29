package 文件;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        Pattern pattern = Pattern.compile(regex);
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return  pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        String[] arrays = new String[]{"src"};
        if(arrays.length == 0) {
            list = path.list();
        }else {
           // list = path.list(filter(""));
            list = path.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
