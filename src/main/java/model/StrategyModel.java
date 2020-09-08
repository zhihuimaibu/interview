package model;

/**
 * @author wzh
 * @date 2020/1/8 10:34
 * @description 策略模式的主要组成部分
 * 1 环境角色，持有策略的引用
 * 2 抽象策略角色
 * 3 具体的策略角色
 */
public class StrategyModel {

}

class Context {
    private Stragegy stragegy;

    public Context(Stragegy stragegy) {
        this.stragegy = stragegy;
    }

    public void contextInteface() {
        stragegy.strategyInteface();
    }
}

interface Stragegy {
    public void strategyInteface();
}

class StragegyA implements Stragegy {

    public void strategyInteface() {

    }
}

class StragegyB implements Stragegy {

    public void strategyInteface() {

    }
}

class StragegyC implements Stragegy {

    public void strategyInteface() {

    }
}