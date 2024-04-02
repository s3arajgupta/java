// Time Complexity: O(3N), where N = size of the given array
// Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).

// Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).

package practice.striversSDE180.arrays;

public class nextPermutation {
    
    public static void main(String args[]){

        // int[] nums = {1,3,2};
        // int[] nums = {1, 2};
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        // int[] nums = {7, 6, 5, 4, 3, 0, 0};
        int [] ans = nextPermutationFunc(nums);
        // System.out.println(ans.toString());
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public static int[] nextPermutationFunc(int[] nums){

        int index = -1;
        
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if (index == -1){
            for (int i = 0; i <= ((nums.length-1)/2); i++){
                int temp = nums[i];
                nums[i] = nums[nums.length-i-1];
                nums[nums.length-1-i] = temp;
                // break;
            }
            System.out.println("if");
            return nums;
        }

        System.out.println("index " + index);

        for (int i = nums.length-1; i > index; i--){
            if (nums[index] < nums[i]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        int i = index + 1;
        int j = nums.length-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
        return nums;
    }
}
