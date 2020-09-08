package headfirst.strategy;

public class TestModelQuack {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithRock());
        modelDuck.performFly();
    }
}
