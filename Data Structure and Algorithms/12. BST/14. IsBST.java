class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    
    Integer prev;
    
    public boolean isValidBST(TreeNode root) {
        
		if (root == null)
			return true;
        
        boolean res1 = isValidBST(root.left);
        
        if(prev==null || root.val>prev)
            prev = root.val;
        
        else if(root.val<=prev)
            return false;
        
       boolean res2 = isValidBST(root.right);
        
       return res1 && res2;
    }
}