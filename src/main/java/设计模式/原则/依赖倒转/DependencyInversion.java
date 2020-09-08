package 设计模式.原则.依赖倒转;

/**
 * @author wzh
 * @date 2020/8/24 22:53
 * @description person接收消息
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person p = new Person();
        p.receive(new Email());
    }
}

class Email{
    public String getInfo(){
        return "Hello world";
    }
}

class Wechat{
    public String getInfo(){
        return "wechat";
    }
}

/**
 * 问题：
 *   比较简单和容易想到该方案
 *   获取的对象是微信或者短息，person要写方法和接收类
 * 解决方法：
 *  引入一个Ireceriver接口，表示接收者，与person发生依赖
 *  因为微信和email等等都是接收的范围，他们各自实现ireceiver接口，就是依赖倒转原则
 */
class Person{
    public void receive(Email email){
        email.getInfo();
    }
    public void receive(Wechat wechat){
        wechat.getInfo();
    }
}