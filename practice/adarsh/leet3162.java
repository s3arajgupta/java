package practice.adarsh;

public class leet3162 {

    public static void main(String[] args) {
        // int[] nums1 = {1, 3, 4};
        // int[] nums2 = {1, 3, 4};
        // System.out.println(numberOfPairs(nums1, nums2, 1));
        int[] nums1 = {1,2,4,12};
        int[] nums2 = {2,4};
        System.out.println(numberOfPairs(nums1, nums2, 3));
    }

    public static int numberOfPairs (int[] nums1, int[] nums2, int k) {

        int counter = 0; 
        for (int i = 0; i < nums2.length; i++){
            for (int j = 0; j < nums1.length; j++) {
                if ( (nums1[i] != 0) && ((nums1[j])%(nums2[i]*k) == 0)) counter++;
            }
        }
        return counter;

    }
}
