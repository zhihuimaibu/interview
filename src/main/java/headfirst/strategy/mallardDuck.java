package headfirst.strategy;

public class mallardDuck extends Duck {

    public mallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("mallardDuck ------");
    }
}
