package model;

/**
 * @author wzh
 * @date 2020/1/7 16:42
 * @description 抽象工厂模式：
 * 1 抽象工厂
 * 2 具体工厂
 * 3 抽象产品
 * 4 具体产品
 * 具体工厂和具体产品  1：n
 * 工厂方法模式中我们是一个具体的工厂只创建一个具体的产品，
 * 而抽象工厂模式中，是一个工厂不再只创建一个具体的产品，而是创建一组产品,
 */
public class AbstractFactory {
    public static void main(String[] args) {
        AK_Factory ak_factory = new AK_Factory();
        ak_factory.produceBullet().loading();
        ak_factory.produceGun().shooting();

        MK41_Factory mk41_factory = new MK41_Factory();
        mk41_factory.produceBullet().loading();
        mk41_factory.produceGun().shooting();
    }
}

//产品接口
interface Gun {
    void shooting();
}

interface Bullet {
    void loading();
}

//具体产品
class AK implements Gun {

    public void shooting() {
        System.out.println("shooting with Ak");
    }
}

class MK41 implements Gun {

    public void shooting() {
        System.out.println("shooting with MK41");
    }
}

class AK_Bullet implements Bullet {

    public void loading() {
        System.out.println("loading bullet with AK");
    }
}

class MK41_Bullet implements Bullet {

    public void loading() {
        System.out.println("loading bullet with MK41_Bullet");
    }
}

//工厂类
interface Factory {
    Gun produceGun();

    Bullet produceBullet();
}

class AK_Factory implements Factory {

    public Gun produceGun() {
        return new AK();
    }

    public Bullet produceBullet() {
        return new AK_Bullet();
    }
}

class MK41_Factory implements Factory {

    public Gun produceGun() {
        return new MK41();
    }

    public Bullet produceBullet() {
        return new MK41_Bullet();
    }
}