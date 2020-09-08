package 队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzh
 * @date 2020/7/22 22:08
 * @description 多线程判断用while
 * 一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，循环5次
 */
public class 生产者消费者初级版 {

    public static void main(String[] args) {
        //操作同一个资源类
        ResourceData resourceData = new ResourceData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++){
                try {
                    resourceData.increament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++){
                try {
                    resourceData.decreament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
}

/**
 * 多个线程操作的资源类
 */
static class ResourceData {
    int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void increament() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            //操作
            number++;
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + number);
    }

    void decreament() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + number);
    }
}
}