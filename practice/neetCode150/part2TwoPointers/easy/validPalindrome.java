package practice.neetCode150.part2TwoPointers.easy;

public class validPalindrome {

    public static void main (String args[]){

        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    public static boolean isPalindrome(String s){

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                // System.out.println("1");
                continue;
            }
            
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                // System.out.println("2");
                continue;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            
            i++;
            j--;
            
        }
        
        return true;
    }
    
    
}
