package 设计模式.原则.单一原则;

/**
 * @author wzh
 * @date 2020/8/18 21:58
 * @description
 */
public class singleReponsibility3 {
    public static void main(String[] args) {
        交通工具集合 交通工具集合 = new 交通工具集合();
        交通工具集合.run公路("小汽车");
        交通工具集合.run公路("摩托车");
        交通工具集合.run天上("飞机");
    }
}

class 交通工具集合{
    void run公路(String 交通工具名称){
        System.out.println(交通工具名称+"在公路上行走");
    }
    void run天上(String 交通工具名称){
        System.out.println(交通工具名称+"在天上行走");
    }
}
