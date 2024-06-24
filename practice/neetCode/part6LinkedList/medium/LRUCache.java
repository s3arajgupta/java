package practice.neetCode.part6LinkedList.medium;

import java.util.HashMap;

class ListNode {
    public int key, val;
    public ListNode next, prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    int capacity;
    ListNode least, most;
    HashMap<Integer, ListNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // LRU = least & MRU = most
        this.least = new ListNode(0, 0);
        this.most = new ListNode(0, 0);
        this.least.next = this.most;
        this.most.prev = this.least;

    }

    // Remove the key Node
    public void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // Insert at the Right(MRU)
    public void insert(ListNode node) {
        ListNode prev = this.most.prev;
        ListNode next = this.most;

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

        ListNode node = new ListNode(key, value);
        cache.put(key, node);
        insert(cache.get(key));

        if (cache.size() > capacity) {
            ListNode lru = this.least.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

}
