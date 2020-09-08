package 设计模式.原则.里氏替换原则;

/**
 * @author wzh
 * @date 2020/9/3 20:37
 * @description
 * 继承问题？父类修改所有子类多有可能出现问题，引用基类的地方都能透明地使用其子类，子类中尽量不要重写父类的方法
 * 解决方法：父类和子类抽象出来一个基类，原有的继承关系去掉，采用依赖，聚合，组合的方法
 */
public class 里氏替换 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.func1(1,3));
        System.out.println(a.func1(2,3));

        B b = new B();
        System.out.println(b.func1(1,3));
        System.out.println(b.func1(2,3));
        System.out.println(b.func2(2,3));
    }
}

class A {
    public int func1(int a, int b) {
        return a - b;
    }
}

class B extends A {
    //重写了A类的方法，可能是无意识的，已经不满足里氏替换原则了
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}