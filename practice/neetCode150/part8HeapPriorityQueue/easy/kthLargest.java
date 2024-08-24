package practice.neetCode150.part8HeapPriorityQueue.easy;

import java.util.PriorityQueue;

class kthLargest {

    public static void main(String[] args) {

        int[] nums = { 4, 5, 8, 2 };
        kthLargest obj = new kthLargest(3, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));

    }

    private PriorityQueue<Integer> heap;
    private int k;

    public kthLargest(int k, int[] nums) {

        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) // O(n)
            add(i);
        // System.out.println(heap);

    }

    public int add(int val) {
        if (heap.size() < k)
            heap.offer(val);
        else if (val > heap.peek()) { // smallest element
            heap.poll(); // remove the top/smallest element
            heap.add(val); // add the new element
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * 
 * int param_1 = obj.add(val);
 */