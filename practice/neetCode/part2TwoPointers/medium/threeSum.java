package practice.neetCode.part2TwoPointers.medium;

import java.util.*;

public class threeSum {

    public static void main (String args[]){

        // int [] nums = {-1,0,1,2,-1,-4};
        int [] nums = {1,-1,-1,0};
        List<List<Integer>> res = threeSumFunc(nums);
        System.out.println("res " + res);

    }

    public static List<List<Integer>> threeSumFunc (int[] nums){

        List<Integer> arr = new ArrayList<>();
        for (int i : nums) arr.add(i);
        Collections.sort(arr);
        // System.out.println(arr);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.size()-2; i++){
            // System.out.println(arr.get(i));
            int complement = 0-arr.get(i);
            for(int j = i+1, k = arr.size()-1; j < k;){

                // System.out.println("i " + arr.get(i));
                // System.out.println("j " + arr.get(j));
                // System.out.println("k " + arr.get(k));
                if(arr.get(j) + arr.get(k) == complement){
                    res.add(new ArrayList<>(Arrays.asList(arr.get(i), arr.get(j), arr.get(k))));
                    // System.out.println( "=");
                    k--;
                    j++;
                    continue;
                }
                if(complement < (arr.get(j) + arr.get(k))){
                    k--;
                    // System.out.println( "<");
                    continue;
                }
                if(complement > (arr.get(j) + arr.get(k))){
                    // System.out.println( ">");
                    j++;
                    continue;
                }
            }
        }
        // System.out.println("res " + res);

        Set<List<Integer>> setOfLists = new HashSet<>(res);
        List<List<Integer>> unList = new ArrayList<>(setOfLists);

        // return Collections.emptyList();
        return unList;
    }

}
