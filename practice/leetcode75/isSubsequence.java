package practice.leetcode75;

public class isSubsequence {

    public static void main(String[] args) {

        System.out.println(isSubsequenceFunc("abc", "ahbgdc"));
        System.out.println(isSubsequenceFunc("axc", "ahbgdc"));
        System.out.println(isSubsequenceFunc("", "ahbgdc"));
        System.out.println(isSubsequenceFunc("axc", ""));
        
    }

    public static boolean isSubsequenceFunc(String s, String t) {

        if (s.length() == 0) return true;
        // if (t.length() == 0) return false;

        int tp = 0, sp = 0;
        while (tp < t.length()) {

            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                if (sp == s.length()) return true;
            }
            tp++;
            
        }

        return false;
        
    }
    
}
