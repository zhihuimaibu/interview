package 设计模式.原则.单一原则;

/**
 * @author wzh
 * @date 2020/8/18 21:58
 * @description
 */
public class singleReponsibility2 {
    public static void main(String[] args) {
        交通工具公路 交通工具公路 = new 交通工具公路();
        交通工具公路.run("小汽车");
        交通工具公路.run("摩托车");
        交通工具天上 交通工具天上= new 交通工具天上();
        交通工具天上.run("飞机");
    }
}

class 交通工具公路{
    void run(String 交通工具名称){
        System.out.println(交通工具名称+"在公路上行走");
    }
}

class 交通工具天上{
    void run(String 交通工具名称){
        System.out.println(交通工具名称+"在公路上行走");
    }
}
