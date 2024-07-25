package practice.neetCode150.part5BinarySearch.medium;

public class searchInRotatedSortedArray {

    public static void main(String args[]) {

        int[] nums = { 3, 4, 5, 6, 1, 2 };
        System.out.println(search(nums, 5));
        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        // System.out.println(search(nums, 0));

    }

    public static int search(int[] nums, int target) {

        int l = 0, mid = 0, r = nums.length - 1;

        while (l <= r) {

            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;

            // left sorted
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            // right sorted
            else {
                if (target < nums[mid] || target > nums[r])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;

    }
}
