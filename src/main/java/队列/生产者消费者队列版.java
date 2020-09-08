package 队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wzh
 * @date 2020/7/23 13:15
 * @description
 * volatile/cas/atomicInteger/BlockQueue
 */
public class 生产者消费者队列版 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(5);
        myResource myResource = new myResource(blockingQueue);
        new Thread(() -> {
            try {
                myResource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"produce").start();

        new Thread(() -> {
            try {
                myResource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();
        Thread.sleep(5);
        myResource.stop();
    }
}

class myResource{
    public volatile Boolean flag = true;
    public AtomicInteger number = new AtomicInteger();
    public BlockingQueue<String> blockingQueue ;

    public myResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void produce() throws InterruptedException {
        String data ;
        while (flag){
            data = String.valueOf(number.getAndIncrement());
            boolean result = blockingQueue.offer(data, 3, TimeUnit.SECONDS);
            if(result){
                System.out.println(Thread.currentThread().getName()+"生产者生产"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"生产者生产"+data+"失败");
            }
            //TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"生产者不再生产被叫停，即flag=false");
    }
    public void consumer() throws InterruptedException {
        while (flag){
            String result = blockingQueue.poll(2,TimeUnit.SECONDS);
            if(result == null){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"超过两秒钟队列没有数据可消费，停止消费");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"消费者消费的结果是"+result);
        }
        System.out.println(Thread.currentThread().getName()+"消费者不再消费，也被大佬叫停");
    }

    public void stop(){
        flag = false;
        System.out.println(Thread.currentThread().getName()+"5秒之后大佬叫停队列");
    }
}