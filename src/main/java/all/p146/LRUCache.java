package all.p146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    int size;
    int capacity;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新值，调整位置
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (size >= capacity) {
                // 删除尾节点，删除表中映射
                DLinkedNode node = removeTail();
                map.remove(node.key);
                size--;
            }
            // 插入头节点
            DLinkedNode node = new DLinkedNode(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
        }
    }


    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
