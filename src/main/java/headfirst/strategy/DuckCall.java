package headfirst.strategy;

public class DuckCall {
    public QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void call() {
        quackBehavior.quack();
    }
}
