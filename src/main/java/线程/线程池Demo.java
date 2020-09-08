package 线程;

import java.util.concurrent.*;

/**
 * @author wzh
 * @date 2020/7/26 20:36
 * @description
 * Array Arrays
 * Collection Collections
 * Executor Executors 辅助工具类
 */
public class 线程池Demo {
    public static void main(String[] args) {
        //查看服务器是几核？
        System.out.println(Runtime.getRuntime().availableProcessors());
/*
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定数线程 一池5个处理线程
*/
/*
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 一池1个处理线程
*/
/*
        ExecutorService threadPool = Executors.newCachedThreadPool();// 一池N个处理线程
*/
        //自己配置线程池参数
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,1L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 20; i++){
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"正在办理业务");
                });

                new Thread().start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}