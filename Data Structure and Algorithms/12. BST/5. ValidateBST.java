class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    Integer prev;
    Boolean res = true;

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        isValidBST(root.left);

        if (prev == null || root.val > prev)
            prev = root.val;

        else if (root.val <= prev) {
            res = false;
            return res;
        }

        isValidBST(root.right);

        return res;
    }
}