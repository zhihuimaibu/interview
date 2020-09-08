package 设计模式.原则.接口隔离原则;

/**
 * @author wzh
 * @date 2020/8/18 22:42
 * @description
 */
public class isolation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface interface1{
    void operation1();
}

interface interface2{
    void operation2();
    void operation3();
}

interface interface3{
    void operation4();
    void operation5();
}
class A {
    void depend1(interface1 interface1){
        interface1.operation1();
    }
    void depend2(interface2 interface2){
        interface2.operation2();
    }
    void depend3(interface2 interface2){
        interface2.operation3();
    }
}

class C{
    void depend1(interface1 interface1){
        interface1.operation1();
    }
    void depend4(interface3 interface3){
        interface3.operation4();
    }
    void depend5(interface3 interface3){
        interface3.operation5();
    }
}
class B implements interface1,interface2{

    @Override
    public void operation1() {
        System.out.println("A依赖B操作1");
    }

    @Override
    public void operation2() {
        System.out.println("A依赖B操作2");
    }

    @Override
    public void operation3() {
        System.out.println("A依赖B操作3");
    }
}

class D implements interface1,interface3{

    @Override
    public void operation1() {
        System.out.println("B依赖D操作1");
    }

    @Override
    public void operation4() {
        System.out.println("B依赖D操作4");
    }

    @Override
    public void operation5() {
        System.out.println("B依赖D操作5");
    }
}