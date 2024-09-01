package practice.neetCode150.part13dp.easy;

public class climbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));

    }

    public static int climbStairs(int n) {

        int one = 1, two = 1, temp = 0;

        for (int i = 0; i < n - 1; i++) {

            temp = one;
            one = one + two;
            two = temp;

        }

        return one;

    }

}
