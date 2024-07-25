package streak;

import modules.*;
import java.util.*;

public class restoreMatrix1605 {

    public static void main(String[] args) {

        restoreMatrix1605 sol = new restoreMatrix1605();
        int[] rowSum = { 3, 8 };
        int[] colSum = { 4, 7 };
        int[][] res = sol.restoreMatrix1605func(rowSum, colSum);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] res;
    PriorityQueue<Pair<Integer, Integer>> minHeapRow;
    PriorityQueue<Pair<Integer, Integer>> minHeapCol;

    public int[][] restoreMatrix1605func(int[] rowSum, int[] colSum) {

        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[][colSum.length];
        this.res = res;

        PriorityQueue<Pair<Integer, Integer>> minHeapRow = new PriorityQueue<>((a, b) -> a.getFirst() - b.getFirst());
        PriorityQueue<Pair<Integer, Integer>> minHeapCol = new PriorityQueue<>((a, b) -> a.getFirst() - b.getFirst());
        this.minHeapRow = minHeapRow;
        this.minHeapCol = minHeapCol;

        int rowSumCount = 0;
        for (int i = 0; i < rowSum.length; i++) {
            minHeapRow.add(new Pair<Integer, Integer>(rowSum[i], i));
            rowSumCount += rowSum[i];
        }
        int colSumCount = 0;
        for (int i = 0; i < colSum.length; i++) {
            minHeapCol.add(new Pair<Integer, Integer>(rowSum[i], i));
            colSumCount += colSum[i];
        }

        System.out.println(minHeapRow);
        System.out.println(minHeapCol);

        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(null, null);
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i]
                flag = 0;
                if (minHeapRow.peek().getFirst() > minHeapCol.peek().getFirst()) {
                    flag = 0;
                    pair = minHeapRow.poll();
                } else {
                    flag = 1;
                    pair = minHeapCol.poll();
                }

                if (flag == 0) {
                    res[]
                }
                
            }
        }

        return res;

    }

}
