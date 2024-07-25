package practice.neetCodeAll.hard;

import java.util.*;

public class numberOfAtoms {

    public static void main(String args[]) {
        numberOfAtoms sol = new numberOfAtoms();
        System.out.println(sol.countOfAtoms("A2He2A2O2He30A10A5A"));
        System.out.println(sol.countOfAtoms("AA5A20AAA10"));
        System.out.println(sol.countOfAtoms("HO(He10Mg40)8O"));
        System.out.println(sol.countOfAtoms("ABHe2Mg2(HHe25Mg2)8"));
        System.out.println(sol.countOfAtoms("Mg(OH)2"));
        System.out.println(sol.countOfAtoms("(K4(ON(SO3)2)2)"));
    }

    public String countOfAtoms(String formula) {

        Stack<HashMap<String, Integer>> stack = new Stack<>();
        HashMap<String, Integer> currMap = new HashMap<>();
        HashMap<String, Integer> prevMap = new HashMap<>();
        StringBuilder str = new StringBuilder();
        int factor = 0, len = formula.length(), i = 0, start = 0;

        char[] arr = formula.toCharArray();

        while (i < len) {

            // System.out.println(i + " arr[i] " + arr[i]);
            if (arr[i] == '(') {

                // Save currMap into stack
                stack.add(new HashMap<>(currMap));
                // Create new currMap
                currMap.clear();
                i++; // skip i

            } else if (arr[i] == ')') {

                i++; // skip i
                // Finding factor
                start = i;
                while (i < len && Character.isDigit(arr[i]))
                    i++;
                factor =  start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                // if (!stack.isEmpty()) // Good Practice
                // Add currMap to prevMap with a multiplication factor
                prevMap = new HashMap<>(stack.pop());
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    prevMap.put(entry.getKey(), prevMap.getOrDefault(entry.getKey(), 0) + factor * entry.getValue());
                }

                currMap = prevMap;
                // currMap = new HashMap<>(prevMap); // slower

            } else {

                // Find full element, maximum length is 2.
                str.setLength(0);
                str.append(arr[i]);
                i++; // Next Character
                if (i < len && Character.isLowerCase(arr[i])) {
                    str.append(arr[i]);
                    i++;
                }

                // Finding factor
                start = i;
                while (i < len && Character.isDigit(arr[i]))
                    i++;
                factor =  start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                currMap.put(str.toString(), currMap.getOrDefault(str.toString(), 0) + factor);

            }

            // System.out.println("currMap " + currMap);
            // System.out.println("prevMap " + prevMap);
            // System.out.println("stack " + stack);

        }

        // String Construction
        List<Map.Entry<String, Integer>> list = new ArrayList<>(currMap.entrySet());
        list.sort(Map.Entry.comparingByKey());
        str.setLength(0);
        for (Map.Entry<String, Integer> entry : list) {
            str.append(entry.getKey());
            if (entry.getValue() > 1)
                str.append(entry.getValue());
        }
        return str.toString();

    }

    // public String countOfAtoms(String formula) {

    //     Stack<HashMap<String, Integer>> stack = new Stack<>();
    //     HashMap<String, Integer> currMap = new HashMap<>();
    //     HashMap<String, Integer> prevMap = new HashMap<>();
    //     StringBuilder str = new StringBuilder();
    //     int factor = 0, len = formula.length(), i = 0;

    //     char[] arr = formula.toCharArray();

    //     while (i < len) {

    //         // System.out.println(i + " arr[i] " + arr[i]);
    //         if (arr[i] == '(') {

    //             // Save currMap into stack
    //             stack.add(new HashMap<>(currMap));
    //             // Create new currMap
    //             currMap.clear();
    //             i++; // skip i

    //         } else if (arr[i] == ')') {

    //             i++; // skip i
    //             // Finding factor
    //             factor = 0;
    //             while (i < len && Character.isDigit(arr[i])) {
    //                 factor = 10 * factor + (arr[i] - '0');
    //                 i++;
    //             }
    //             factor = (factor == 0) ? 1 : factor;

    //             // if (!stack.isEmpty()) // Good Practice
    //             // Add currMap to prevMap with a multiplication factor
    //             prevMap = new HashMap<>(stack.pop());
    //             for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
    //                 prevMap.put(entry.getKey(), prevMap.getOrDefault(entry.getKey(), 0) + factor * entry.getValue());
    //             }

    //             currMap = prevMap;
    //             // currMap = new HashMap<>(prevMap); // slower

    //         } else {

    //             // Find full element, maximum length is 2.
    //             str.setLength(0);
    //             str.append(arr[i]);
    //             i++; // Next Character
    //             if (i < len && Character.isLowerCase(arr[i])) {
    //                 str.append(arr[i]);
    //                 i++;
    //             }

    //             // Finding factor
    //             factor = 0;
    //             while (i < len && Character.isDigit(arr[i])) {
    //                 factor = 10 * factor + (arr[i] - '0');
    //                 i++;
    //             }
    //             factor = (factor == 0) ? 1 : factor;

    //             currMap.put(str.toString(), currMap.getOrDefault(str.toString(), 0) + factor);

    //         }

    //         // System.out.println("currMap " + currMap);
    //         // System.out.println("prevMap " + prevMap);
    //         // System.out.println("stack " + stack);

    //     }

    //     // String Construction
    //     List<Map.Entry<String, Integer>> list = new ArrayList<>(currMap.entrySet());
    //     list.sort(Map.Entry.comparingByKey());
    //     str.setLength(0);
    //     for (Map.Entry<String, Integer> entry : list) {
    //         str.append(entry.getKey());
    //         if (entry.getValue() > 1)
    //             str.append(entry.getValue());
    //     }
    //     return str.toString();

    // }

}
