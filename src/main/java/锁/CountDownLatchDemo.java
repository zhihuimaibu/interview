package 锁;

import java.util.concurrent.CountDownLatch;

/**
 * @author wzh
 * @date 2020/7/20 22:32
 * @description枚举复习 做减法
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"上完晚自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长离开教室，锁门");
    }
}
