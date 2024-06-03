package practice.adarsh;

import java.util.*;

import modules.TreeNode;

public class leet129 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(sumNumbers(root));

    }

    public static List<String> res  = new ArrayList<>();
    public static int sumNumbers (TreeNode root) {

        if (root == null) return 0;
        
        System.out.println(res);
        StringBuilder strb = new StringBuilder();
        dfsString(root, strb);
        System.out.println(res);
        int answer = 0;
        for (String i : res) answer += Integer.parseInt(i);
        return answer;
        
    }
    
    public static void dfsString (TreeNode root, StringBuilder str) {

        if (root == null) {
            System.out.println(res);
            System.out.println(str.toString());
            System.out.println("res");
            res.add(str.toString());
            System.out.println(res);
        }
        if (root.left != null) {
            System.out.println(str);
            dfsString(root.left, str.append(String.valueOf(root.val)));
            System.out.println(str);
        }
        if (root.right != null) {
            System.out.println(str);
            dfsString(root.right, str.append(String.valueOf(root.val)));
            System.out.println(str);
        }
        
    }
        
    
}
