package wzg;

/**
 * @author wzh
 * @date 2020/2/21 10:09
 * @description
 */
public class one {
    public static void main(String args[]) {
        String str = "main-action-holder";
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
            split[i].substring(0, 1).toUpperCase().concat(split[i].substring(1));
            System.out.println(split[i]);
        }
    }
}