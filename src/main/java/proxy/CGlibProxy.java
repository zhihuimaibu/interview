package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wzh
 * @date 2020/1/10 14:57
 * @description
 */
public class CGlibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloService helloService = (HelloService) enhancer.create();
        helloService.sayHello();
    }
}

class HelloService {

    public HelloService() {
        System.out.println("HelloService 构造");
    }

    public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers-->>" + name);
        return null;
    }

    void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}

class MyMethodInterceptor implements MethodInterceptor {

    /**
     * @param o           cglib生成的代理对象
     * @param method      被代理对象方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置通知");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("插入后置通知");
        return object;
    }
}