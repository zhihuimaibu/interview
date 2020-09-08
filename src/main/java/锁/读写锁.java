package 锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wzh
 * @date 2020/7/20 21:29
 * @description 多个线程读取一个资源类（看电子广告牌，看车站大屏），修改只能一个线程修改（更改数据，变更检票口）：(读读，读写，写写)
 * 写操作：原子+独占 整个过程必须是一个完整的统一体，中间不允许被打断，被分割
 *
 */

class 资源类车站大屏{
    private volatile Map<String, Object> map = new HashMap<>();//保证可见性
    //Lock lock = new ReentrantLock();//占用资源
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在写入");
        try {
            TimeUnit.MICROSECONDS.sleep(500);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key) {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在读取");
        try {
            TimeUnit.MICROSECONDS.sleep(500);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
public class 读写锁 {
    public static void main(String[] args) {
        资源类车站大屏 cache = new 资源类车站大屏();
        for (int i=0; i<5; i++){
            final int finalI = i;
            new Thread(() ->{
                cache.put(finalI+"",finalI);
            },String.valueOf(i)).start();
        }
        for (int i=0; i<5; i++){
            final int finalI = i;
            new Thread(() ->{
                cache.get(finalI+"");
            },String.valueOf(i)).start();
        }

    }
}
