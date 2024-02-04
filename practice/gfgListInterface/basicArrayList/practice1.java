package practice.gfgListInterface.basicArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class practice1 {
    
    public static void main (String args[]){

        List<String> colors = new ArrayList<>();

        colors.add("blue");
        colors.add("red");
        colors.add("white");

        // System.out.println(colors);
        for(String s : colors){
            System.out.println(s);
        }

        colors.add(0, "black");
        colors.add(colors.size(), "brown");

        System.out.println(colors);

        System.out.println(colors.get(1));

        colors.set(1, "pink");

        System.out.println(colors);

        // colors.remove("red");
        colors.remove(2);
        System.out.println(colors);

        System.out.println(colors.contains("pink"));

        Collections.sort(colors);
        System.out.println(colors);

        List<String> colorsCopy = new ArrayList<>();

        // colorsCopy.addAll(colors);
        Collections.copy(colors, colorsCopy);
        System.out.println(colorsCopy);

        // List<Integer> nums = new ArrayList<>();

        // nums.add(1);
        // nums.add(2);
        // nums.add(3);

        // // System.out.println(nums);
        // for(Integer i : nums){
        //     System.out.println(i);
        // }

    }
}
