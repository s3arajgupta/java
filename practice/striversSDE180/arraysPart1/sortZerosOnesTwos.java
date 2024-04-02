package practice.striversSDE180.arraysPart1;

public class sortZerosOnesTwos {
    
    public static void main (String args[]){

        int[] nums = {2,0,1};
        // int[] nums = {2,0,2,1,1,0};
        nums = sortZerosOnesTwosFunc(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] sortZerosOnesTwosFunc(int[] nums){

        int mid = 0, low = 0, high = nums.length-1, temp;

        while(mid < high){

            if (nums[mid] == 0){
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++; 
                low++;
            }
            else if (nums[mid] == 1){
                mid++;
            }
            else{
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        return nums;
    }
    
}
