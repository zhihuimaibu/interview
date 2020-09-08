package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        washFace wf = new washFace();
        InvocationHandler ih = new washFaceProxy(wf);
        wash washFaceProxy = (wash) Proxy.newProxyInstance(wf.getClass().getClassLoader(), wf.getClass().getInterfaces(), ih);
        washFaceProxy.wash();
    }
}


interface wash {
    void wash();
}

class washFace implements wash {
    public void wash() {
        System.out.println("洗脸");
    }
}

class washFaceProxy implements InvocationHandler {

    public Object targetObject;

    public washFaceProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("洗面奶");
        method.invoke(targetObject, args);
        System.out.println("香香");
        return null;
    }
}