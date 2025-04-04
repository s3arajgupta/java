package practice.neetCode150.part13DynamicProgramming1D.medium;

public class houseRobber {

    public static void main(String[] args) {

        houseRobber sol = new houseRobber();

        // int[] nums = { 1, 2, 3, 1 };
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(sol.rob(nums));

    }

    public int rob(int[] nums) {

        int rob1 = 0, rob2 = 0, temp = 0;

        // [rob1, rob2, i, i+1]
        for (int i : nums) {

            temp = Math.max(i + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;

    }

}
