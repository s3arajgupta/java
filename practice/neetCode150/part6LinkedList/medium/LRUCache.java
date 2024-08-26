package practice.neetCode150.part6LinkedList.medium;

import modules.ListNodeDoubly;
import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }

    int capacity;
    HashMap<Integer, ListNodeDoubly> cache;
    ListNodeDoubly least, most;

    public LRUCache(int capacity) {

        cache = new HashMap<>();
        this.capacity = capacity;

        // LRU = least & MRU = most
        this.least = new ListNodeDoubly(0, 0);
        this.most = new ListNodeDoubly(0, 0);
        this.least.next = this.most;
        this.most.prev = this.least;

    }

    // Remove the node, not necessarily LRU Node
    public void remove(ListNodeDoubly node) {

        ListNodeDoubly prev = node.prev;
        ListNodeDoubly next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    // Insert from the Right, MRU Node
    public void insert(ListNodeDoubly node) {

        ListNodeDoubly prev = most.prev;
        ListNodeDoubly next = most;

        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;

    }

    public int get(int key) {

        if (cache.containsKey(key)) {

            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;

        }

        return -1;

    }

    public void put(int key, int value) {

        if (cache.containsKey(key))
            remove(cache.get(key));

        ListNodeDoubly node = new ListNodeDoubly(key, value);

        cache.put(key, node);
        insert(cache.get(key));

        if (cache.size() > capacity) {

            ListNodeDoubly lru = this.least.next;
            remove(lru);
            cache.remove(lru.key);

        }

    }

}
