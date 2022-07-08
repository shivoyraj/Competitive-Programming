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
            
		if(Math.abs(hr-hl)<=1)
			return Math.max(hr+1,hl+1);
        
        else
            return null;
		
	}
    
    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(height(root)==null)
            return false;
        
        return true;
    }
}