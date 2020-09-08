package headfirst.strategy;

public class muteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("slience");
    }
}
