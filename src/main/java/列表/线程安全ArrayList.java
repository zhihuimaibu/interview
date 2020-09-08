package 列表;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wzh
 * @date 2020/7/16 20:11
 * @description
 */
public class 线程安全ArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList strings = new CopyOnWriteArrayList();
        strings.add("1");
        strings.add("2");
        HashSet<Object> objects = new HashSet();
        objects.add("1");
    }
}
