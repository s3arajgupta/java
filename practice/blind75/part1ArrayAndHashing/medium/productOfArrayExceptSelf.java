package practice.blind75.part1ArrayAndHashing.medium;

public class productOfArrayExceptSelf {

    public static void main (String args[]){

        int[] nums = {1,2,3,4};
        int[] res = new int[nums.length];

        res = productExceptSelf(nums);

        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }

    }

    public static int[] productExceptSelf(int[] nums){

        int []lhs = new int[nums.length];
        int []rhs = new int[nums.length];

        int product;
        lhs[0] = 1;
        rhs[nums.length-1] = 1;

        product = lhs[0];
        for (int i = 1; i < nums.length; i++){
            product *= nums[i-1];
            lhs[i] = product;
        }
        
        product = rhs[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--){
            product *= nums[i+1];
            rhs[i] = product;
        }

        // for (int i = 0; i < lhs.length; i++)
        //     System.out.println(lhs[i]);
        // for (int i = 0; i < rhs.length; i++)
        //     System.out.println(rhs[i]);

        for (int i = 0; i < nums.length; i++)
            nums[i] = lhs[i]*rhs[i];
        
        // return new int[]{};
        return nums;
    }

}
