/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

package practice.blind75.part8HeapPriorityQueue.hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {

        // boolean temp = minHeap.size() >= maxHeap.size() ? maxHeap.add(num) : minHeap.add(num);

        if (minHeap.size() == 0 || maxHeap.size() == 0)
            return;
        // System.out.println("maxHeap " + maxHeap);
        // System.out.println("minHeap " + minHeap);

        if (minHeap.peek() <= maxHeap.peek()) {
            // int pop = minHeap.poll();
            // maxHeap.add(pop);
            maxHeap.add(minHeap.poll());
        }
        // System.out.println("maxHeap " + maxHeap);
        // System.out.println("minHeap " + minHeap);

        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                // int pop = maxHeap.poll();
                // minHeap.add(pop);
                minHeap.add(maxHeap.poll());
            } else {
                // int pop = minHeap.poll();
                // maxHeap.add(pop);
                maxHeap.add(minHeap.poll());
            }
        }
        // System.out.println("maxHeap " + maxHeap);
        // System.out.println("minHeap " + minHeap);

    }

    public double findMedian() {

        // System.out.println("5maxHeap " + maxHeap);
        // System.out.println("minHeap " + minHeap);
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}

public class findMedianFromDataStream {

    public static void main(String[] args) {

        MedianFinder obj = new MedianFinder();
        // obj.addNum(1);
        // obj.addNum(2);
        // // obj.findMedian();
        // System.out.println(obj.findMedian());
        // obj.addNum(3);
        // // obj.findMedian();
        // System.out.println(obj.findMedian());

        obj.addNum(3);
        obj.addNum(2);
        obj.addNum(7);
        obj.addNum(4);
        System.out.println(obj.findMedian());

    }

}
