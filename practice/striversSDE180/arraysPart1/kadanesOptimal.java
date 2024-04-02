package practice.striversSDE180.arraysPart1;

public class kadanesOptimal {

    public static void main (String args[]){

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(function(arr));
        function(arr);
        
    }
    
    static int function(int[] arr){

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start=0, stop=0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (sum > max) {
                max = sum;
                stop = i+1;
            }

            if (sum < 0){
                sum = 0;
                start = i+1;
            }
        }

        for (int i = start; i < stop; i++){
            System.out.print(arr[i] + " ");
            
        }
        
        return max;
    }
}
