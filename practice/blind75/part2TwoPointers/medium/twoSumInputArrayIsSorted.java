package practice.blind75.part2TwoPointers.medium;

public class twoSumInputArrayIsSorted {

    public static void main (String args[]){

        int []  numbers = {2,7,11,15};
        int target = 13;
        int [] res = twoSumIndex (numbers, target);
        for (int i : res) System.out.println(i);
    }

    public static int[] twoSumIndex (int[] numbers, int target){

        for (int i = 0, j = numbers.length-1; i < j;){

            if ((numbers[i] + numbers[j]) > target){
                j--;
                continue;
            }
            if ((numbers[i] + numbers[j]) < target){
                i++;
                continue;
            }
            if ((numbers[i] + numbers[j]) == target) return new int[]{i+1, j+1};
            
        }

        return new int[]{};
    }
    
}
