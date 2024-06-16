// tc = O(1)
// sc = O(n)

package practice.leetcode75;

import modules.*;
import java.util.*;

public class onlineStockSpan {

    public static void main(String[] args) {

        onlineStockSpan obj = new onlineStockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));

    }

    public onlineStockSpan() {

        stack = new Stack<>();

    }

    public Stack<Pair<Integer, Integer>> stack;

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek().getFirst() <= price) {
            // System.out.println("stack.peek().getFirst() " + stack.peek().getFirst() + " price " + price);
            span = span + stack.pop().getSecond();
        }
        
        stack.add(new Pair<Integer, Integer>(price, span));
        return span;

    }

}
