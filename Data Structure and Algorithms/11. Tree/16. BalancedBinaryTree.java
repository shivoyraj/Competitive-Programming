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
            
	public static Integer height(TreeNode root) {
		
		if(root==null)
			return 0;
		
		Integer hl = height(root.left);
		Integer hr = height(root.right);
        
        if(hl==null || hr == null)
            return null;
            
		return (Math.abs(hr-hl)<=1) ? Math.max(hr,hl)+1 : null;
		
	}
    
    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(height(root)==null)
            return false;
        
        return true;
    }
}