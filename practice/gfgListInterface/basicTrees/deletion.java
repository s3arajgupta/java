package practice.gfgListInterface.basicTrees;

public class deletion {
    
}

// class BinaryTree {
//     // Existing code

//     public TreeNode delete(TreeNode root, int val) {
//         if (root == null)
//             return root;

//         if (val < root.val)
//             root.left = delete(root.left, val);
//         else if (val > root.val)
//             root.right = delete(root.right, val);
//         else {
//             if (root.left == null)
//                 return root.right;
//             else if (root.right == null)
//                 return root.left;

//             root.val = minValue(root.right);
//             root.right = delete(root.right, root.val);
//         }
//         return root;
//     }

//     private int minValue(TreeNode root) {
//         int minValue = root.val;
//         while (root.left != null) {
//             minValue = root.left.val;
//             root = root.left;
//         }
//         return minValue;
//     }
// }


// Certainly! Let's consider a scenario where the node to be deleted has two children. We'll illustrate this with an example.

// Suppose we have the following binary tree:

// markdown
// Copy code
//         10
//        /  \
//       5    20
//      / \  /  \
//     3   7 15  25
//              /
//             22
// Now, let's say we want to delete the node with the value 20.

// Here's how the deletion process would work:

// Find the Node to Delete:

// Start from the root node (10) and traverse down the tree to find the node with the value 20.
// Identify the Node with Two Children:

// Upon reaching the node with the value 20, we find that it has two children (15 and 25).
// Find the In-Order Successor:

// To maintain the properties of a binary search tree, we need to find a suitable replacement for the node to be deleted.
// The in-order successor of a node in a binary search tree is the smallest node in its right subtree.
// In this case, the in-order successor of 20 is the smallest node (22) in its right subtree.
// Replace the Node with the In-Order Successor:

// We replace the value of the node to be deleted (20) with the value of its in-order successor (22).
// After replacing the value, we need to remove the in-order successor (22) from its original position.
// Delete the In-Order Successor from its Original Position:

// We perform a recursive deletion on the right subtree of the node to be deleted, starting from the in-order successor (22).
// Since 22 has no left child, we simply remove it from the tree.
// Adjusted Tree:

// After deletion, the binary tree will be adjusted accordingly.
// Adjusted Tree:

// markdown
// Copy code
//         10
//        /  \
//       5    22
//      / \  /  \
//     3   7 15  25
//              /
//             22
// This process ensures that the binary search tree property is maintained, where all values in the left subtree of a node are less than the node's value, and all values in the right subtree are greater.
