package practice.neetCode150.part6LinkedList.medium;

public class findTheDuplicateNumber {

    public static void main(String[] args) {

        int[] nums = { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums) {

        int slow1 = 0, fast = 0;

        while (true) {

            slow1 = nums[slow1];
            fast = nums[nums[fast]];

            if (slow1 == fast)
                break;

        }

        int slow2 = 0;

        while (slow2 != slow1) {

            slow1 = nums[slow1];
            slow2 = nums[slow2];

        }

        return slow1;

    }

}
