package 线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author wzh
 * @date 2020/7/23 21:22
 * @description 怎么用？？
 * 为什么会出现？？高并发  多线程
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new Thread2());
        //多个线程抢一个futureTask，就只计算一次
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask, "BBB").start();
        //int result2 = futureTask.get();//要求获得callable线程的计算结果，如果没有计算完成就要阻塞，一般放在最后
        System.out.println(Thread.currentThread().getName()+"*******");

        int result1 = 100;
        //int result2 = futureTask.get();//要求获得callable线程的计算结果，如果没有计算完成就要阻塞，一般放在最后

       /* while(!futureTask.isDone()){

        }*/
        int result2 = futureTask.get();
        System.out.println("result=" + (result1 + result2));
    }
}

class Thread2 implements Callable<Integer> {

    //抛异常
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"call");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
