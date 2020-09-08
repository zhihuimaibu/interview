package model;

public class LazySingleton {
    public final static Person p = new Person();

    private LazySingleton() {

    }
}


class test1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Person p = LazySingleton.p;
                    System.out.println(p.hashCode());
                }
            }).start();
        }
    }
}