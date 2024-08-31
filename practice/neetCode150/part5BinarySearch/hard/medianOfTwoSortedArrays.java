package practice.neetCode150.part5BinarySearch.hard;

public class medianOfTwoSortedArrays {

    public static void main(String[] args) {

        medianOfTwoSortedArrays sol = new medianOfTwoSortedArrays();

        // int[] nums1 = { 1, 3 };
        // int[] nums2 = { 2 };
        // int[] nums1 = { 1, 2 };
        // int[] nums2 = { 3, 4 };
        int[] nums1 = {};
        int[] nums2 = { 3, 4 };

        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n)
            return findMedianSortedArrays(nums2, nums1);

        int total = m + n;
        int half = (total + 1) / 2;

        int l = 0, r = m, mid = 0, j = 0;

        while (l <= r) {

            mid = l + (r - l) / 2;
            j = half - mid;

            int nums1Left = (mid > 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            int nums1Right = (mid < m) ? nums1[mid] : Integer.MAX_VALUE;
            int nums2Left = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            // Partition is correct
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {

                if (total % 2 == 0) // even
                    return (double) (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2;
                else // odd
                    return (double) Math.max(nums1Left, nums2Left);

            }

            else if (nums1Left > nums2Right)
                r = mid - 1;

            else
                l = mid + 1;

        }

        return -1.0;

    }

}
