package all.p146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache2(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() >= capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }


    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
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
