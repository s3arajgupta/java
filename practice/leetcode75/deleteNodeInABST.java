// package practice.leetcode75;

// import modules.TreeNode;

// public class deleteNodeInABST {

//     public static void main(String[] args) {

//         TreeNode root = new TreeNode(5);
//         root.left = new TreeNode(3);
//         root.left.left = new TreeNode(2);
//         root.left.right = new TreeNode(4);
//         root.right = new TreeNode(6);
//         root.right.right = new TreeNode(4);

//         System.out.println(deleteNode(root, 5));

//     }

//     public static TreeNode deleteNode(TreeNode root, int key) {

//         if (root == null)
//             return null;

//         return func(root, key);

//     }

//     public static TreeNode func(TreeNode root, int key) {

//         if (root == null)
//             return null;

//         if (root.val == key){
//             if 
//         }

//         if (root.left != null && root.left.val == key) {
//             deleteleft(root);
//         }
//         if (root.right != null && root.right.val == key) {
//             deleteright(root);
//         }
//         if (root.left != null && root.left.val < key)
//             func(root.left, key);
//         if (root.right != null && root.right.val < key)
//             func(root.right, key);

//         return root;

//     }

//     public static void deleteright(TreeNode root) {

//         if (root.right.left != null) {
//             root.right.val = root.right.left.val;
//             root.right.left = null;
//         } else if (root.right.right != null) {
//             root.right.val = root.right.right.val;
//             root.right.right = null;
//         } else {
//             root.right = null;
//         }

//     }

//     public static void deleteleft(TreeNode root) {

//         if (root.left.right != null) {
//             root.left.val = root.left.right.val;
//             root.left.right = null;
//         } else if (root.left.left != null) {
//             root.left.val = root.left.left.val;
//             root.left.left = null;
//         } else {
//             root.left = null;
//         }

//     }

// }
