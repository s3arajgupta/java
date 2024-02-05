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

        // System.out.println(colorsCopy.size());

        colorsCopy.add("A");
        colorsCopy.add("B");
        colorsCopy.add("C");
        colorsCopy.add("D");

        // colorsCopy.addAll(colors);
        Collections.copy(colorsCopy, colors);
        System.out.println(colorsCopy);
        
        Collections.shuffle(colors);
        System.out.println("shuffle " + colors);
        
        Collections.reverse(colors);
        System.out.println("reverse " + colors);
    

        List <String> colorMod = colors.subList(0, 2);

        System.out.println("mod " + colorMod);
        System.out.println(new ArrayList<>(colors.subList(1, 3)));
        System.out.println(new ArrayList<>(colors.subList(1, 2)));


        colorMod.add("beige");
        List<String> colorCom = new ArrayList<>();
        for (String s : colors)
            colorCom.add(colorMod.contains(s)? "Yes" : "No");

        System.out.println(colorCom);

    
        Collections.swap(colorCom, 2, 3);
        System.out.println(colorCom);

        List <String> colorJoin = new ArrayList<>();
        colorJoin.addAll(colorCom);
        colorJoin.addAll(colors);
        System.out.println("Join " + colorJoin);

        // List<String> colorClone = new ArrayList<>();
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // colorClone.add("null");
        // System.out.println("colorCloneNull " + colorClone);  
        // Collections.copy(colorClone, colorJoin);

        // ArrayList<String> colorClone = (ArrayList<String>)colorCom.clone();
        // System.out.println("colorCloneNew " + colorClone);


        colorCom.removeAll(colorCom);
        System.out.println(colorCom);

        System.out.println(colorCom.isEmpty());

        // colors.trimToSize(); ###############################

        // System.out.println(colorCom.ens);
        // colorCom.ensureCapacity(6)

        
        
    }
}
