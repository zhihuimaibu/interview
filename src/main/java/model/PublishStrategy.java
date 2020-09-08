package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2020/1/18 17:00
 * @description
 */
public class PublishStrategy {
}

interface Publish {
    void publishTopic(Topic topic);

    void removeTopic(Topic topic);

    void setEvent(Topic topic);
}

class weChartPublish implements Publish {
    List<Topic> topicqueue;

    public weChartPublish() {
        topicqueue = QueueTopic.getPublishInstance();
    }

    public void publishTopic(Topic topic) {
        topicqueue.add(topic);
    }

    public void removeTopic(Topic topic) {
        topicqueue.remove(topic);
    }

    public void setEvent(Topic topic) {
        System.out.println("发布者发布主题" + topic.getMessage());
    }
}

class QueueTopic {

    static volatile List<Topic> publishQueues;
    static volatile List<Topic> subscribeQueues;

    public void addPublishTopic(Topic topic) {
        publishQueues.add(topic);
    }

    public void removePublishTopic(Topic topic) {
        publishQueues.remove(topic);
    }

    public static List<Topic> getPublishInstance() {
        if (publishQueues == null) {
            synchronized (QueueTopic.class) {
                if (publishQueues == null) {
                    publishQueues = new ArrayList<Topic>();
                }
            }
        }
        return publishQueues;
    }

    public static List<Topic> getSubscribeInstance() {
        if (subscribeQueues == null) {
            synchronized (QueueTopic.class) {
                if (subscribeQueues == null) {
                    subscribeQueues = new ArrayList<Topic>();
                }
            }
        }
        return subscribeQueues;
    }

    public void notifySubcribe() {
        for (Topic topic : subscribeQueues) {

        }
    }
}

class Topic {
    private String publish;
    private String message;

    public Topic(String publish, String message) {
        this.message = message;
        this.publish = publish;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

interface Subcribe {
    void updateEvent(Topic topic);

    void subcribeTopic(Topic topic);

    void subcribeRemoveTopic(Topic topic);
}

class UserSubcribe implements Subcribe {

    List<Topic> topicQueue;

    public UserSubcribe() {
        topicQueue = QueueTopic.getSubscribeInstance();
    }

    public void updateEvent(Topic topic) {
        System.out.println("订阅者收到主题" + topic.toString() + "的推送：");
    }

    public void subcribeTopic(Topic topic) {
        System.out.println("订阅者订阅主题" + topic.toString());
        topicQueue.add(topic);
    }

    public void subcribeRemoveTopic(Topic topic) {
        System.out.println("订阅者移除主题" + topic.toString());
        topicQueue.remove(topic);
    }
}