package practice.neetCode150.part2TwoPointers.medium;

import java.util.Arrays;

public class twoSumInputArrayIsSorted {

    public static void main(String args[]) {

        int[] numbers = { 2, 7, 11, 15 };
        int target = 13;
        System.out.println(Arrays.toString(twoSumIndex(numbers, target)));

    }

    public static int[] twoSumIndex(int[] numbers, int target) {

        for (int i = 0, j = numbers.length - 1; i < j;) {

            if ((numbers[i] + numbers[j]) > target) {
                j--;
                continue;
            }

            if ((numbers[i] + numbers[j]) < target) {
                i++;
                continue;
            }

            else
                return new int[] { i + 1, j + 1 };

        }

        return new int[] {};

    }

}
