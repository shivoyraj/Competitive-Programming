/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode sortedArrayToBST(int[] nums, int l , int r) {
        
        if(r<l)
            return null;

        int m = (l+r)/2;
        TreeNode root = new TreeNode(nums[m]);

        root.left = sortedArrayToBST(nums,l,m-1);
        root.right = sortedArrayToBST(nums,m+1,r);

        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
}