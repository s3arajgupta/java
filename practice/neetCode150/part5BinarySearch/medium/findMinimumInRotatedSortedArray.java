package practice.neetCode150.part5BinarySearch.medium;

public class findMinimumInRotatedSortedArray {

    public static void main(String args[]) {

        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {

        int r = nums.length - 1, l = 0, min = Integer.MAX_VALUE;
        int mid = l;

        while (l <= r) {

            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            mid = l + (r - l) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return min;

    }

}
