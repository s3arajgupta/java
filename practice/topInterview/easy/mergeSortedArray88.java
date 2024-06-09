package practice.topInterview.easy;

public class mergeSortedArray88 {

    public static void main(String args[]) {

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) System.out.print(i + " ");

        // int[] nums1 = { 2, 0 };
        // int[] nums2 = { 1 };
        // merge(nums1, 1, nums2, 1);
        // for (int i : nums1)
        //     System.out.print(i + " ");

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int temp = 0;
        for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; k--) {

            for (int f : nums1)
                System.out.print(f + " ");
            System.out.println();
            System.out.println(k + " " + i + " " + j);

            if (i < 0 && j < 0) break;

            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
                continue;
            }
            if (nums1[i] > nums2[j]) {

                temp = nums1[i];
                nums1[i] = nums2[j];
                nums1[k] = temp;
                i--;
            }
        }

    }

}