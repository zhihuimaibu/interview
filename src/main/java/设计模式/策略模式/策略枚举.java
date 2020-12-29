package 设计模式.策略模式;

import java.util.Arrays;

/**
 * 策略模式：context 具体的策略类 定义一组算法，将他们分别封装起来并且每种算法都可以互换
 */
public class 策略枚举 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String sysbol = args[1];
        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数是：" + Arrays.toString(args));
        System.out.println("运行结果是：" + a + sysbol + b + "=" + Caculator.ADD.exec(a, b));
    }
}

enum Caculator {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value = "";

    Caculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);
}