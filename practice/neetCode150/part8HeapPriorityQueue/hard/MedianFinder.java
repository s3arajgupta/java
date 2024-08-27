package practice.neetCode150.part8HeapPriorityQueue.hard;

import java.util.*;

class MedianFinder {

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println((double) medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void addNum(int num) {

        boolean temp = minHeap.size() >= maxHeap.size() ? maxHeap.add(num) : minHeap.add(num);
        if (temp)
            ;

        if (minHeap.size() == 0 || maxHeap.size() == 0) // ignore rest code for 1st element
            return;

        if (minHeap.peek() <= maxHeap.peek())
            maxHeap.add(minHeap.poll());

        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {

            if (maxHeap.size() > minHeap.size())
                minHeap.add(maxHeap.poll());

            else
                maxHeap.add(minHeap.poll());

        }

    }

    public double findMedian() {

        if (minHeap.size() == maxHeap.size())
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;

        else
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();

    }

}
