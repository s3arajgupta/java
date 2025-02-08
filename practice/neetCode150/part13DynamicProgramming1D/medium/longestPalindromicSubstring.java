package practice.neetCode150.part13DynamicProgramming1D.medium;

public class longestPalindromicSubstring {

    public static void main(String[] args) {

        longestPalindromicSubstring sol = new longestPalindromicSubstring();

        System.out.println(sol.longestPalindrome("babad"));
        System.out.println(sol.longestPalindrome("baad"));
        System.out.println(sol.longestPalindrome("a"));
        System.out.println(sol.longestPalindrome("aaaa"));
        System.out.println(sol.longestPalindrome("aacabdkacaa"));

    }

    public String longestPalindrome(String s) {

        int l = 0, r = 0, reslen = 0, n = s.length();
        String res = "";

        for (int i = 0; i < n; i++) {

            // for odd reslen
            l = i;
            r = i;

            while (l >= 0 && r < n && (s.charAt(l) == s.charAt(r))) {

                if (r - l + 1 > reslen) {
                    reslen = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                l--;
                r++;

            }

            // for even reslen

            l = i;
            r = i + 1;

            while (l >= 0 && r < n && (s.charAt(l) == s.charAt(r))) {

                if (r - l + 1 > reslen) {
                    reslen = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                l--;
                r++;

            }

        }

        return res;

    }

}
