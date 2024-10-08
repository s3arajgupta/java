package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.*;

public class encodeandDecodeStrings {

    public static void main(String args[]) {

        List<String> strs = new ArrayList<>();
        strs.add("lin#tlin#tlin#tlin#t");
        strs.add("null");
        System.out.println("io: " + strs);

        String s = encode(strs);
        System.out.println("en: " + s);

        strs = decode(s);
        System.out.println("de: " + strs);

    }

    public static String encode(List<String> strs) {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < strs.size(); i++)
            str = str.append(strs.get(i).length() + "#").append(strs.get(i));

        return str.toString();

    }

    public static List<String> decode(String str) {

        int checkpoint = 0;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '#') {

                StringBuilder digitStr = new StringBuilder();

                for (int j = checkpoint; j < i; j++)
                    digitStr.append(str.charAt(j));

                int intParser = Integer.parseInt(digitStr.toString());
                digitStr.setLength(0);

                StringBuilder valueStr = new StringBuilder();

                while (intParser > 0) {
                    valueStr.append(str.charAt(i + 1));
                    i++;
                    intParser--;
                }

                res.add(valueStr.toString());
                valueStr.setLength(0);

                checkpoint = i + 1;

            }

        }

        return res;

    }

}
