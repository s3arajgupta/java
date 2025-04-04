package practice.neetCode150.part13DynamicProgramming1D.medium;

public class palindromicSubstrings {

    public static void main(String[] args) {

        palindromicSubstrings sol = new palindromicSubstrings();

        System.out.println(sol.countSubstrings("abc"));
        System.out.println(sol.countSubstrings("aaa"));
        System.out.println(sol.countSubstrings("a"));

    }

    public int isPallindrome(String s, int l, int r) {

        int res = 0;
        int n = s.length();

        while (l >= 0 && r < n && s.charAt(r) == s.charAt(l)) {

            res++;
            l--;
            r++;

        }

        return res;

    }

    public int countSubstrings(String s) {

        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            // for odd pallindromes
            res += isPallindrome(s, i, i);

            // for even pallindromes
            res += isPallindrome(s, i, i + 1);

        }

        return res;

    }

}
