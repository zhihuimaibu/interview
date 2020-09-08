package 设计模式.原则.依赖倒转.改进;

/**
 * @author wzh
 * @date 2020/8/24 22:53
 * @description person接收消息
 * 依赖关系传递的三种方式：
 *      1 基于接口的传递
 *      2 基于构造方法的传递
 *      3 基于setter方法的传递
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person p = new Person();
        p.receive(new Email());
        p.receive(new Wexin());
    }
}

interface Ireceiver{
    String getInfo();
}
//邮件
class Email implements Ireceiver{
    public String getInfo(){
        return "Hello world";
    }
}
//微信
class Wexin implements Ireceiver{

    @Override
    public String getInfo() {
        return "weixin hello world";
    }
}
class Person{
    public void receive(Ireceiver ireceiver){
        System.out.println(ireceiver.getInfo());
    }
}