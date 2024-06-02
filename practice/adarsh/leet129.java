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

    public static List<StringBuilder> res  = new ArrayList<>();
    public static int sumNumbers (TreeNode root) {
        
        StringBuilder strb  = new StringBuilder();
        dfsString(root, strb);
        // res.add(dfsString(root, strb));
        System.out.println(res);
        int answer = 0;
        for (StringBuilder i : res) answer += Integer.parseInt(i.toString());
        return answer;
        
    }

    public static void dfsString (TreeNode root, StringBuilder str) {

        if (root == null) res.add(str);
        if (root.left != null) {
            System.out.println(root.val);
            dfsString(root.left, str.append(String.valueOf(root.val)));
        }
        if (root.right != null) {
            System.out.println(root.val);
            dfsString(root.right, str.append(String.valueOf(root.val)));
        }
        
    }
        
    
}
