package 线程;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author wzh
 * @date 2020/7/28 14:25
 * @description
 *死锁是指两个或两个以上的进程再执行的过程中，
 * 以争夺资源而造成的一种相互等待的现象
 * 若无外力干涉那他们都无法推进下去
 */
public class 死锁 {
    public static void main(String[] args) {
        String str1 ="111";
        String str2 ="222";
        new Thread(new 持有ADD锁的线程(str1,str2),"AAA").start();
        new Thread(new 持有DELETE锁的线程(str1,str2),"BBB").start();
    }
}

class 持有ADD锁的线程 implements Runnable{
    String str1,str2 ;
    public 持有ADD锁的线程(String str1,String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {
        synchronized (str1){
            System.out.println(Thread.currentThread().getName()+"获取add类的锁，准备获取delete的锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str2){
                System.out.println(Thread.currentThread().getName()+"获取delete的锁");
            }
        }
    }
}

class 持有DELETE锁的线程 implements Runnable{
    String str1,str2 ;

    public 持有DELETE锁的线程(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {
        synchronized (str2){
            System.out.println(Thread.currentThread().getName()+"获取delete类的锁，准备获取add的锁");
            synchronized (str1){
                System.out.println(Thread.currentThread().getName()+"获取add的锁");
            }
        }
    }
}
class add{
}
class delete{

}