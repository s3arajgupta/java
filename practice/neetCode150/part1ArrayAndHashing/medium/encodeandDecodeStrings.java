package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.*;

public class encodeandDecodeStrings {

    public static void main(String args[]) {

        List<String> strs = new ArrayList<>();
        strs.add("lin#tlin#tlin#tlin#t");
        strs.add("null");
        System.out.println("io: " + strs);

        String s = encode(strs);
        System.out.println("encode: " + s);

        strs = decode(s);
        System.out.println("decode: " + strs);

    }

    public static String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs.size(); i++)
            res = res.append(strs.get(i).length() + "#" + strs.get(i));

        return res.toString();

    }

    public static List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            int checkpoint = str.indexOf("#", i); // Find the next '#'
            int digitLength = Integer.parseInt(str.substring(i, checkpoint));
            String valueStr = new String(str.substring(checkpoint + 1, checkpoint + digitLength + 1));

            res.add(valueStr);
            i = checkpoint + digitLength;

        }

        return res;

    }

}
