package practice.neetCode150.part8HeapPriorityQueue.medium;

import java.util.Random;

public class kthLargestElementInAnArray {

    public static void main(String[] args) {

        kthLargestElementInAnArray sol = new kthLargestElementInAnArray();

        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(sol.findKthLargest(nums, 4));

    }

    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;

        return quickSelect(nums, k, 0, nums.length - 1);

    }

    public int quickSelect(int[] nums, int k, int l, int r) {

        if (l == r)
            return nums[l];

        int pivotIndex = new Random().nextInt(r - l + 1) + l;

        pivotIndex = partition(nums, l, r, pivotIndex);

        if (k == pivotIndex)
            return nums[k];
        else if (k < pivotIndex)
            return quickSelect(nums, k, l, pivotIndex - 1);
        else
            return quickSelect(nums, k, pivotIndex + 1, r);

    }

    private int partition(int[] nums, int l, int r, int pivotIndex) {

        int pivotValue = nums[pivotIndex];

        swap(nums, pivotIndex, r); // Move pivot to end

        int storeIndex = l;

        for (int i = l; i < r; i++) {

            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }

        }

        swap(nums, storeIndex, r); // Move pivot to its final place

        return storeIndex;

    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
