package practice.neetCode150.part3SlidingWindow.medium;
// package practice.neetCode.slidingWindow.medium;

// import java.util.Collections;
// import java.util.HashMap;

// public class longestRepeatingCharacterReplacement {

//     public static void main (String args[]){

//         // String s = "ABAB";
//         // int k = 2;
//         // String s = "ABAA";
//         // int k = 0;
//         String s = "AABABBA";
//         int k = 1;
//         // String s = "ABBB";
//         // int k = 2;
//         int res = characterReplacement(s, k);
//         System.out.println(res);
        
//     }

//     public static int characterReplacement(String s, int k) {

//         HashMap<Character, Integer> map = new HashMap<>();
//         int left = 0, right = 0, max = 0, maxf = 0;

//         for (int i = 0; i < s.length(); i++){
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//             // System.out.println("i " + i);
//             // System.out.println("map " + map);
            
//             // maxf ?
//             maxf = Math.max(maxf, map.get(s.charAt(i)));
//             // We can use if else instead of while
//             while ((right-left+1) - maxf > k){
//                 // System.out.println("while: " + ((right-left+1) - Collections.max(map.values())));
//                 map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
//                 left++;
//                 // System.out.println("mapwhile " + map);
//                 // System.out.println("maxwhile " + (right-left));
//             }

//             right++;
//             max = Math.max(max, right-left);
//             // System.out.println("max " + max);
//         }
//         return max;
//     }
    
//     // // Not the correct implmentation but partially working kudos!
//     // public static int characterReplacement(String s, int k) {

//     //     HashMap<Character, Integer> map = new HashMap<>();
//     //     int left = 0, right = 0, max = 0;

//     //     for (int i = 0; i < s.length(); i++){
//     //         map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 1) + 1);

//     //         while ((right-left+1) - Collections.max(map.values()) > k){
//     //             map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
//     //             left++;
//     //         }

//     //         right++;
//     //         max = Math.max(max, right-left + 1);
//     //     }
//     //     return max;
//     // }

//     // Not the correct implmentation but partially working kudos!
//     // public static int characterReplacement(String s, int k) {

//     //     int left =0 , right = 0, max = 0, count = 0;
//     //     int tempk = k;
        
//     //     while (right < s.length()){

//     //         if (s.charAt(right) == s.charAt(left)){
//     //             count++;
//     //         }
//     //         else{
//     //             if (tempk != 0){
//     //                 count++;
//     //                 tempk--;
//     //             }
//     //             else {
//     //                 System.out.println("reset");
//     //                 left++;
//     //                 right = left;
//     //                 tempk = k;
//     //                 count = 0;
//     //                 count++;
//     //             }
//     //         }
//     //         max = Math.max(max, count);
//     //         System.out.println(s.charAt(right) + " " + max + " " + tempk + " " + count);
//     //         right++;
//     //     }
//     //     return max;        
//     // }
// }
