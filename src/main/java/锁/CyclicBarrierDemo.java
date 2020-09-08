package 锁;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wzh
 * @date 2020/7/21 21:31
 * @description 做加法
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("***开会****");
        });
        for (int i = 1; i <= 7; i++){
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"来到第"+ finalI +"人");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
