/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

package practice.leetcode75;

import java.util.*;

class SmallestInfiniteSet {

    PriorityQueue<Integer> minheap = new PriorityQueue<>(); // minimumKeyAtRoot
    HashSet<Integer> numSet = new HashSet<>();
    Integer nextSmallest = 1;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {

        if (!minheap.isEmpty()) {
            int smallest = minheap.poll();
            numSet.remove(smallest);
            return smallest;
        }
        return nextSmallest++;

    }

    public void addBack(int num) {

        if (num < nextSmallest)
            if (numSet.add(num))
                minheap.offer(num); // insertion
    }
}