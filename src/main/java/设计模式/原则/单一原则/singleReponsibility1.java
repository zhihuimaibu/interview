package 设计模式.原则.单一原则;

/**
 * @author wzh
 * @date 2020/8/18 21:58
 * @description
 */
public class singleReponsibility1 {
    public static void main(String[] args) {
        交通工具 交通工具 = new 交通工具();
        交通工具.run("飞机");
        交通工具.run("小汽车");
        交通工具.run("摩托车");

    }
}
class 交通工具{
    void run(String 交通工具名称){
        System.out.println(交通工具名称+"在公路上行走");
    }
}

