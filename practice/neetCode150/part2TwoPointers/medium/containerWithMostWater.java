package practice.neetCode150.part2TwoPointers.medium;

public class containerWithMostWater {

    public static void main(String args[]) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(containerWithMostWaterFunc(height));

    }

    public static int containerWithMostWaterFunc(int[] height) {

        int max = Integer.MIN_VALUE, area;

        for (int i = 0, j = height.length - 1; i < j;) {

            area = (j - i) * Math.min(height[i], height[j]);
            if (area > max)
                max = area;

            if (height[i] > height[j])
                j--;
            else
                i++;

        }

        return max;

    }

}
