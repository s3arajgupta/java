package practice.neetCode.arrayAndHashing.easy;

public class validAnagramOptimal {

    public static boolean isAnagramFunc(String s, String t) {

        int[] arr = new int[26];
        
        for (char i : s.toCharArray())
            arr[i - 'a']++;
        for (char i : t.toCharArray())
            arr[i - 'a']--;
        
        for (int i : arr)
            if (i != 0)
                return false;
        
        return true;

    }

    public static void main (String args[]){

        System.out.println(isAnagramFunc("anagram", "naagram"));
        System.out.println(isAnagramFunc("aaaaaabbbbbb", "aabb"));
        System.out.println(isAnagramFunc("ab", "a"));
        
    }

    
}
