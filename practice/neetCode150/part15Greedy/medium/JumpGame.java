package practice.neetCode150.part15Greedy.medium;

public class JumpGame {

    public static void main(String[] args) {

        JumpGame obj = new JumpGame();

        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(obj.canJump(nums));

    }

    public boolean canJump(int[] nums) {

        int goal = nums.length - 1;

        if (goal == 0)
            return true;
        else if (nums[0] == 0)
            return false;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (i + nums[i] >= goal)
                goal = i;

        }

        return goal == 0;

    }

}
