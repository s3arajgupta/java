package practice.neetCode.part6LinkedList.medium;

public class findTheDuplicateNumber {
    
    public static void main(String[] args) {

        // int[] nums = {1,3,4,2,2};
        // int[] nums = {3,1,3,4,2};
        // int[] nums = {3,3,3,3,3};
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate(nums));
        
    }

    public static int findDuplicate (int[] nums) {
        
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break; 
            // System.out.println(slow + " " + fast);
        }
        // System.out.println(slow + " " + fast);

        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
            System.out.println(slow + " " + slow2);
        }
        
        return slow;
        // return slow2;

    }

    // public static int findDuplicate (int[] nums) {
        
    //     final ListNode root = new ListNode();
    //     ListNode slow = new ListNode(0, null);
    //     ListNode fast = new ListNode(0, null);

    //     root.next = slow;
    //     root.next = fast;

    //     while (true) {

    //         // slow = new ListNode(nums[0], )); 
    //         slow = slow.next;
    //         fast = new ListNode(nums[fast.next.val]);

    //         if (slow == fast) break; 
            
    //     }

    //     ListNode slow2 = new ListNode(0, null);

    //     while (slow2.val == slow.val) {

    //         slow2.val = nums[slow2.val];
    //         slow.val = nums[slow.val];

    //     }

    //     return slow2.val;

    // }
    
}
