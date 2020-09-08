package headfirst.strategy;

public class TestDuckCall {
    public static void main(String[] args) {
        DuckCall duckCall = new DuckCall();
        duckCall.setQuackBehavior(new Quack());
        duckCall.call();
    }
}
