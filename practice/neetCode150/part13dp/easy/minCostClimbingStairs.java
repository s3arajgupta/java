package practice.neetCode150.part13dp.easy;

public class minCostClimbingStairs {

    public static void main(String[] args) {

        minCostClimbingStairs sol = new minCostClimbingStairs();
        int[] cost = { 10, 15, 20 };
        System.out.println(sol.minCostClimbingStairsFunc(cost));

    }

    // public int minCostClimbingStairsFunc(int[] cost) {

    // for (int i = cost.length - 3; i >= 0; i--) {
    // cost[i] = Math.min(cost[i] + cost[i + 1], cost[i] + cost[i + 2]);
    // }
    // // return Math.min(cost[0], cost[1]);
    // return cost[0] > cost[1] ? cost[1] : cost[0];

    // }

    public int minCostClimbingStairsFunc(int[] cost) {

        int one = 0, two = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(one, two);
            two = one;
            one = cost[i];
        }

        // return Math.min(cost[0], cost[1]);
        return cost[0] > cost[1] ? cost[1] : cost[0];

    }

}
