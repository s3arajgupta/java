package practice.neetCode150.part5BinarySearch.easy;

public class binarySearch {

    public static void main(String args[]) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));

    }

    public static int search(int[] nums, int target) {

        int mid, start = 0, end = nums.length - 1;

        while (start <= end) {

            mid = start + ((end - start) / 2);

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else
                return mid;

        }

        return -1;

    }

}
