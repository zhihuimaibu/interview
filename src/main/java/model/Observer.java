package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2020/1/15 17:26
 * @description 主题是要干什么:
 * 公众号的主题是推送消息
 * 报社的主题的送报纸
 * 商家的主题是上新商品
 * 微博。。。。
 * 这时候改进了：发布者把主题都放在盒子里，这个盒子就称之为调度中心，订阅者从盒子里注册要拿的主题，当发布者发布主题时由调度中心处理订阅者注册到的调度中心的代码，相当于队列
 * 观察者是接受什么:
 * 关注公众号的用户接收消息
 * 订阅报纸的用户收报纸
 * 关注商家的用户查看上新商品
 * 1 抽象的主题
 * 2 具体的主题
 * 3 抽象的观察者
 * 4 具体的观察者
 */
public class Observer {
    public static void main(String[] args) {
        WechatSubject subject = new WechatSubject();
        Observers zhangsan = new UserObservers("zhangsan");
        Observers lisi = new UserObservers("lisi");
        Observers wangwu = new UserObservers("wangwu");
        subject.registerOberver(zhangsan);
        subject.registerOberver(lisi);
        subject.registerOberver(wangwu);
        subject.setMessage("欢迎关注饿了么公众号");
    }
}

interface Subject {
    void registerOberver(Observers observers);

    void removeOberver(Observers observers);

    void notifyOberver();
}

class WechatSubject implements Subject {

    List<Observers> wechatSubject;
    String message;

    public WechatSubject() {
        wechatSubject = new ArrayList<Observers>();
    }

    public void registerOberver(Observers observer) {
        wechatSubject.add(observer);
    }

    public void removeOberver(Observers observer) {
        wechatSubject.remove(observer);
    }

    public void notifyOberver() {
        for (Observers observer : wechatSubject) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("微信公众号推送消息:" + message);
        notifyOberver();
    }
}

interface Observers {
    void update(String message);
}

class UserObservers implements Observers {

    private String userName;
    private String message;

    public UserObservers(String userName) {
        this.userName = userName;
    }

    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(userName + "收到推送的信息:" + message);
    }
}