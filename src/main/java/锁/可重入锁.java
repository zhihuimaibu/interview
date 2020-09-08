package 锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzh
 * @date 2020/7/16 22:15
 * @description 指的的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层的方法会自动获取锁
 * 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 *  synchronized/reentrantlock就是典型的可重入锁
 * synchronized ： t1线程获取发短信的锁也获得发邮件的锁
 */
public class 可重入锁{
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        },"t1").start();

        new Thread(() -> {
            phone.sendSms();
        },"t2").start();
        System.out.println("reentrantlock就是典型的可重入锁");

        Thread t3 = new Thread(new Phone());
        Thread t4 = new Thread(new Phone());

        t3.start();
        t4.start();
    }
}

class Phone implements Runnable {
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName()+"发送短信");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发送邮件***********");
    }

    //reentrantlock例子-------------------------
    Lock lock = new ReentrantLock(true);
    @Override
    public void run() {
        get();
    }
    public void get(){
       // lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"get()方法");
            set();
        }finally {
            lock.unlock();
            //lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"set()方法");
        }finally {
            lock.unlock();
        }
    }
}