// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

package practice.leetcode75;

public class findPeakElement {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1 };
        // int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElementFunc(nums));

    }

    public static int findPeakElementFunc(int[] nums) {

        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int l = 1, r = n - 2, mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1])
                l = mid + 1;
            else if (nums[mid] > nums[mid + 1])
                r = mid - 1;
            else
                r = mid - 1;
        }

        return mid;

    }

}