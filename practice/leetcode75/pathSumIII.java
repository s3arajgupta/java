package practice.leetcode75;

import java.util.HashMap;

import modules.TreeNode;

public class pathSumIII {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));

    }

    public static int res;
    public static long prefixSum;
    public static HashMap<Long, Integer> map;

    public static int pathSum(TreeNode root, int targetSum) {

        res = 0;
        prefixSum = 0;
        map = new HashMap<>();
        backtracking(root, 0, targetSum);
        return res;

    }

    public static void backtracking(TreeNode root, long prefixSum, int targetSum) {

        if (root == null)
            return;

        prefixSum = prefixSum + root.val;

        // If map contains a sum equal to (prefixSum - targetSum), we need to increment
        // count that many times
        if (map.containsKey(prefixSum - targetSum)) {
            res = res + map.get(prefixSum - targetSum);
        }

        // There can be cases when the prefixSum is directly equal to targetSum, we need
        // to increment count
        if (prefixSum == targetSum)
            res++;

        // Update the prefixSum till current node and its count
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        // recurse
        backtracking(root.right, prefixSum, targetSum);
        backtracking(root.left, prefixSum, targetSum);

        // Update map and Backtrack
        map.put(prefixSum, map.get(prefixSum) - 1);

    }

}
