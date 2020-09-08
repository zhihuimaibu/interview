package collection;

import java.util.Map;

public class map {
    public int initSize = 16;
    Node[] arr;
    int size = 0;
    double loadFactor = 0.75;
    int i = 0;
    boolean flag = false;

    public void add(Node node) {
        i = node.hashCode() & (initSize - 1);
        if (initSize * loadFactor > size) {
            if (arr[i] == null)
                arr[i] = node;
            else {
                //遍历每一个节点看是否相等
                for (Node e = arr[i]; e != null; e = e.next) {
                    if (node.key.equals(e.key) && e.hashCode() == node.hashCode()) {
                        e = node;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    node.next = arr[i];
                    arr[i] = node;
                }
            }
            size++;
        } else {
            //扩容
            int old = initSize;
            initSize = initSize << 1;
            Node[] newTable = new Node[initSize];
            for (int i = 1; i < old; i++) {
                Node e = arr[i];
                newTable[(initSize - 1) & e.hashCode()] = e;
            }
        }
    }

    public map(int initSize, double loadFactor) {
        this.initSize = initSize;
        this.loadFactor = loadFactor;
        throw new RuntimeException();
        //if (initSize > 0)
        //arr = new Node[initSize];
        //else
        //  throw new RuntimeException("");
    }

    public map() {
        arr = new Node[initSize];
    }
}

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(V value) {
        return this.value = value;
    }
}