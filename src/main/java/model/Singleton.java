package model;

/*
   单例模式 ：懒汉模式  和  饿汉模式
   Person p = new Person();
   1.分配空间
   2.引用
   3.赋值
 */
public class Singleton {
    static volatile Person a;

    private Singleton() {

    }

    public static Person getInstance() {
        if (a == null) {
            synchronized (Singleton.class) {
                if (a == null) {
                    Person tempPerson = new Person();
                    System.out.println("初始话完成" + tempPerson.hashCode());
                    a = tempPerson;
                }
            }
        }
        return a;
    }
}


class Person {
    String name;
    String age;
}

class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Person p = Singleton.getInstance();
                    System.out.println(p.hashCode());
                }
            }).start();
        }
    }
}
