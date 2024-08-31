package modules;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printTree(TreeNode node) {

        if (node == null) {

            System.out.println("Empty Tree!!");
            return;

        }

        dfs(node);
        System.out.println();

    }

    public void dfs(TreeNode node) {

        if (node == null) {
            System.out.print("null,");
            return;
        }

        System.out.print(node.val + ",");
        dfs(node.left);
        dfs(node.right);

    }

}
