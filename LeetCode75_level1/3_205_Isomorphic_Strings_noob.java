package LeetCode75_level1;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        String s = "PAPER";
        String t = "TITLE";
        int len = s.length();
        
        int[] map1 = new int[len];
        int[] map2 = new int[len];

        for(int i = 0; i < len; i++){
            map1[i] = s.charAt(i);
            map2[i] = t.charAt(i);
            // map1[i] = s.indexOf("R");
            // map1[i] = s.indexOf(s[i]);
        }
        
        System.out.println("map1");
        for(int i = 0; i < len; i++){
            System.out.println(map1[i]);
        }
        System.out.println("map2");
        for(int i = 0; i < len; i++){
            System.out.println(map2[i]);
        }
        System.out.println("diff");
        for(int i = 0; i < len; i++){
            System.out.println(map1[i]-map2[i]);
        }
    }
}