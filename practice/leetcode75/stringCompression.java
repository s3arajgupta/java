package practice.leetcode75;

public class stringCompression {

    public static void main(String[] args) {

        // char[] chars = {'a'};
        // char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};
        
        // chars = compress(chars);
        // for (char c : chars) System.out.print(c + " ");

        System.out.println(compress(chars));
        // chars = compress(chars);        
        // for (char c : chars) System.out.print(c + " ");

        
    }

    public static int compress(char[] chars) {

        int l = 0, r = 0;
        StringBuilder str = new StringBuilder();
        int count = 0;
        while (r < chars.length) {

            if (chars[l] != chars[r]) {
                count = r - l;
                if (count > 1) {
                    str.append(chars[l]);
                    str.append(count);
                }
                else {
                    str.append(chars[l]);
                }
                count = 0;
                l = r;
                continue;
            }
            r++;
            // System.out.println(str);
            
        }
        count = r - l;
        if (count > 1) {
            str.append(chars[l]);
            str.append(count);
        }
        else {
            str.append(chars[l]);
        }

        // System.out.println(str.length()); // The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

        char[] tempchars = str.toString().toCharArray();
        for (char c : chars) System.out.print(c + " ");
        System.out.println();
        
        for (char c = 0; c < tempchars.length; c++) chars[c] = tempchars[c]; 

        // for ( int c = 0; c < chars.length; c++) {
        //     // System.out.println(chars[c]);
        //     // chars[c] = chars[c];
        // }

        return tempchars.length;

    }
    
}
