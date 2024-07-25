package practice.neetCode150.part2TwoPointers.hard;

public class trappingRainWater {

    public static void main (String args[]){

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }

    public static int trap (int[] height){

        int unit = 0;
        int maxl = height[0], maxr = height[height.length - 1];

        for (int i = 0, j = height.length-1; i < j;){

            // unit = unit + Math.min(maxr, maxl);
            if (maxl < maxr){
                unit = unit + Math.min(maxr, maxl) - height[i];
                i++;
                maxl = Math.max(maxl, height[i]);
            } 
            else{
                unit = unit + Math.min(maxr, maxl) - height[j];
                j--;
                maxr = Math.max(maxr, height[j]);
            } 
            // System.out.println(unit);
        }

        return unit;
    }
    
}
