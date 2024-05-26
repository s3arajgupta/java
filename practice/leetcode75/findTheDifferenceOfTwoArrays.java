// answer.add(res.toArray()); // ? Research when to use this.
// answer.add(Arrays.asList(res)); // ? We convert the array to a list of integers using Arrays.asList(array).
package practice.leetcode75;

import java.util.*;

public class findTheDifferenceOfTwoArrays {

    public static void main(String[] args) {

        // int[] nums1 = {1,2,3};
        // int[] nums2 = {2,4,6};
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        // List<List<Integer>> res = findDifference(nums1, nums2);
        // System.out.println(res);
        System.out.println(findDifference(nums1, nums2));
        
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set <Integer> set1 = new HashSet<>();
        Set <Integer> set2 = new HashSet<>();
        Set <Integer> res = new HashSet<>();

        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);

        for (int i : nums1) {
            if (set2.contains(i)) continue;
            else res.add(i);
        }
        temp = new ArrayList<>(res);
        answer.add(temp);
        
        res.removeAll(res);
        for (int i : nums2) {
            if (set1.contains(i)) continue;
            else res.add(i);
        }
        temp = new ArrayList<>(res);
        answer.add(temp);

        return answer;

    }
    
}
