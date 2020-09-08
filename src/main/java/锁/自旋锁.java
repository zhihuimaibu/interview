package 锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wzh
 * @date 2020/7/16 23:12
 * @description 循环比较，直到成功为止
 * spinkLock
 */
public class 自旋锁 {
    //AtomicReference<Thread> atomicReference = new AtomicReference<>();//初始值为null
    AtomicInteger atomicReference = new AtomicInteger();//初始值为0

    void mylock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(0,1)){
            System.out.println(Thread.currentThread().getName()+"自旋");
        }
    }

    void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(1,0);
    }
    public static void main(String[] args) throws InterruptedException {
        自旋锁 a = new 自旋锁();
        new Thread(() -> {
            a.mylock();
            System.out.println("t1获得自旋锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.myUnlock();
            System.out.println("t1释放锁");
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            a.mylock();
            System.out.println("t2获得自旋锁");
            a.myUnlock();
            System.out.println("t2释放锁");
        },"t2").start();
    }
}
