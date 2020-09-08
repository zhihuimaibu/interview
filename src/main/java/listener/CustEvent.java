package listener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/**
 * @author wzh
 * @date 2020/1/15 16:10
 * @description
 */
//事件类型，对事件类型进行监听和发布
public class CustEvent extends EventObject {
    private String sing;//

    /**
     * Constructs a prototypical Event.
     *
     * @param sing The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustEvent(String sing) {
        super(sing);
        this.sing = sing;
    }

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }
}

class CustEventListener implements EventListener {
    public void listener(CustEvent event) {
        System.out.println("抚摸机器狗唱" + event.getSing());
    }
}

//事件监听器和事件进行绑定，发布事件
class CustEventPubish {
    List<CustEventListener> custEventListeners = new ArrayList<CustEventListener>();

    //注册事件监听器
    public void addEventListener(CustEventListener eventListener) {
        custEventListeners.add(eventListener);
    }

    //移除事件监听器
    public void removeListener(CustEventListener eventListener) {
        custEventListeners.remove(eventListener);
    }

    //发布事件
    public void publishEvent() {
        //赋值一份监听器列表
        List<CustEventListener> copyCustEventListeners = new ArrayList<CustEventListener>(custEventListeners);
        for (EventListener eventListener : custEventListeners) {
            ((CustEventListener) eventListener).listener(new CustEvent("小猴子"));
        }
    }
}

class test {
    public static void main(String[] args) {
        CustEventPubish source = new CustEventPubish();
        source.addEventListener(new CustEventListener());
        source.publishEvent();
    }
}