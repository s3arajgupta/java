// This kind of problems are identifying your comprehension and simplifying skills.

package practice.leetcode75;

import java.util.Deque;
import java.util.LinkedList;

public class dota2Senate {

    public static void main(String[] args) {

        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDRD"));

    }

    public static String predictPartyVictory(String senate) {

        int n = senate.length();
        Deque<Integer> R = new LinkedList<>();
        Deque<Integer> D = new LinkedList<>();

        char[] arr = senate.toCharArray();

        for (int i = 0; i < n; i++) {

            if (arr[i] == 'R') {
                R.add(i);
            } else {
                D.add(i);
            }

        }

        // System.out.println(R);
        // System.out.println(D);

        int x = 0, y = 0;
        while (R.size() != 0 && D.size() != 0) {

            x = R.removeFirst();
            y = D.removeFirst();

            if (x < y) {
                R.add(n - 1 + x);
            } else {
                D.add(n - 1 + y);
            }

        }

        return !R.isEmpty() ? "Radiant" : "Dire";

    }

    // public static String predictPartyVictory(String senate) {

    // int n = senate.length();
    // Deque<Integer> R = new LinkedList<>();
    // Deque<Integer> D = new LinkedList<>();

    // char[] arr = senate.toCharArray();

    // for (int i = 0; i < n; i++) {

    // if (arr[i] == 'R') {
    // R.add(i);
    // } else {
    // D.add(i);
    // }

    // }

    // // System.out.println(R);
    // // System.out.println(D);

    // int x = 0;
    // while (R.size() != 0 && D.size() != 0) {

    // if (R.peekFirst() < D.peekFirst()) {
    // x = R.removeFirst();
    // R.add(n - 1 + x);
    // D.removeFirst();
    // } else {
    // x = D.removeFirst();
    // D.add(n - 1 + x);
    // R.removeFirst();
    // }

    // }

    // return !R.isEmpty() ? "Radiant" : "Dire";

    // }

    // public static String predictPartyVictory(String senate) {

    // int n = senate.length();
    // Deque<Integer> R = new LinkedList<>();
    // Deque<Integer> D = new LinkedList<>();

    // // char[] arr = senate.toCharArray();

    // for (int i = 0; i < n; i++) {

    // if (senate.charAt(i) == 'R') {
    // R.add(i);
    // }
    // if (senate.charAt(i) == 'D') {
    // D.add(i);
    // }

    // }

    // // System.out.println(R);
    // // System.out.println(D);

    // int x = 0;
    // while (R.size() != 0 && D.size() != 0) {

    // if (R.peekFirst() < D.peekFirst()) {
    // x = R.removeFirst();
    // R.add(n - 1 + x);
    // D.removeFirst();
    // } else {
    // x = D.removeFirst();
    // D.add(n - 1 + x);
    // R.removeFirst();
    // }

    // }

    // return !R.isEmpty() ? "Radiant" : "Dire";

    // }

}
