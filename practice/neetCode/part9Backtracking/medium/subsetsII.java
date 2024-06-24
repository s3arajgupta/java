// DP won't work because we are creating the subsets.

package practice.neetCode.part9Backtracking.medium;

import java.util.*;

public class subsetsII {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));

    }

    public static List<List<Integer>> results;
    public static List<Integer> temp;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        results = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(nums); // sorted order is must
        backtracking(0, temp, nums);
        return results;

    }

    public static void backtracking(int n, List<Integer> temp, int[] nums) {

        if (n >= nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }

        // all subsets which include nums[i]
        temp.add(nums[n]);
        backtracking(n + 1, temp, nums);
        temp.remove(temp.size() - 1);

        // all subsets which do not include nums[i]
        while (n < nums.length - 1 && nums[n] == nums[n + 1])
            n++;
        backtracking(n + 1, temp, nums);

    }

    // public static List<List<Integer>> results;
    // public static List<Integer> temp;

    // public static List<List<Integer>> subsetsWithDup(int[] nums) {

    // results = new ArrayList<>();
    // temp = new ArrayList<>();
    // backtracking(0, temp, nums);
    // HashSet<List<Integer>> resultsSet = new HashSet<>();
    // for (List<Integer> i : results) resultsSet.add(i);
    // results = new ArrayList<>(resultsSet);
    // return results;

    // }

    // public static void backtracking(int n, List<Integer> temp, int[] nums) {

    // if (n >= nums.length) {
    // results.add(new ArrayList<>(temp));
    // return;
    // }

    // temp.add(nums[n]);
    // backtracking(n + 1, temp, nums);
    // temp.remove(temp.size() - 1);
    // backtracking(n + 1, temp, nums);

    // }

}
