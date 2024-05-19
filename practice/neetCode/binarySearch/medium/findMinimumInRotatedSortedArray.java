package practice.neetCode.binarySearch.medium;

public class findMinimumInRotatedSortedArray {

    public static void main (String args[]){

        // int[] nums = {3,4,5,1,2};
        // int[] nums = {5,4};
        // int[] nums = {3,4,5,6,7,1,2};
        // int[] nums = {4,5,6,7,0,1,2};
        // int[] nums = {4};
        int[] nums = {2,1};
        System.out.println(findMin(nums));
        
    }

    public static int findMin (int[] nums){

        int r = nums.length - 1, l = 0, min = Integer.MAX_VALUE;
        int mid = l;

        while (l <= r) {

            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            mid = l + (r-l)/2;
            min = Math.min(min, nums[mid]);
            // System.out.println(l + "=" + mid + "=" + r);
            // System.out.println(nums[l] + "|" + nums[mid] + "|" + nums[r]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
            // System.out.println(nums[l] + " " + nums[mid] + " " + nums[r]);
        }
        return min;

    }

    // public static int findMin (int[] nums){

    //     int l = 0, r = nums.length - 1, m = 0;
    //     Integer min = Integer.MAX_VALUE;
    //     while (l <= r) {
    //         m = l + (r-l)/2;
    //         if (nums[r] <= nums[m]) {
    //             min = Math.min(min, nums[m]);
    //             l = m + 1;
    //         }
    //         else {
    //             min = Math.min(min, nums[m]);
    //             r = m-1;
    //         }
    //     }

    //     return min;

    // }
}
